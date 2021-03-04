package com.tom.baseandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tom.baseandroid.base.BaseViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel() {
    private val emailMatch = MutableLiveData<Boolean>()

    private val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\$"

    fun isEmailFormatCorrect(it: String): LiveData<Boolean> {

        val pattern: Pattern = Pattern.compile(emailRegex)
        val matcher: Matcher = pattern.matcher(it)
        emailMatch.value = matcher.matches()

        return emailMatch
    }
}