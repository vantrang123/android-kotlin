package com.tom.baseandroid.ui.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseViewModel
import com.tom.baseandroid.data.local.DbService
import com.tom.baseandroid.data.model.ErrorMessage
import com.tom.baseandroid.data.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Named

class LoginViewModel @Inject constructor(
        private val context: Context,
        private val dbService: DbService,
        @Named("IO") private val io: CoroutineDispatcher,
        @Named("MAIN") private val main: CoroutineDispatcher
) : BaseViewModel() {
    private val emailMatch = MutableLiveData<Boolean>()
    private val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\$"

    val loginResult = MutableLiveData<Pair<User?, Boolean>>()
    val signUpResult = MutableLiveData<Pair<User?, Boolean>>()

    fun isEmailFormatCorrect(it: String): LiveData<Boolean> {
        val pattern: Pattern = Pattern.compile(emailRegex)
        val matcher: Matcher = pattern.matcher(it)
        emailMatch.value = matcher.matches()

        return emailMatch
    }

    fun checkLogin(email: String, password: String) {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val result = withContext(io) { async { dbService.getUser(email, password) } }
                result.await().apply {
                    isLoading.postValue(false)
                    loginResult.postValue(Pair(this, this != null))
                    if (this == null) error.postValue(ErrorMessage(message = context.getString(R.string.error_not_found_account)))
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
                loginResult.postValue(Pair(null, false))
            }
        }
    }

    fun saveAccount(user: User) {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val result = withContext(io) { async { dbService.addOrUpdateUser(user) } }
                result.await().apply {
                    isLoading.postValue(false)
                    signUpResult.postValue(Pair(user, this))
                    if (!this) error.postValue(ErrorMessage(message = context.getString(R.string.error_some_thing_wrong)))
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
                signUpResult.postValue(Pair(null, false))
            }
        }
    }
}