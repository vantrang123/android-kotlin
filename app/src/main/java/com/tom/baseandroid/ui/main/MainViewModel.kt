package com.tom.baseandroid.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tom.baseandroid.base.BaseViewModel
import com.tom.baseandroid.data.local.DbService
import com.tom.baseandroid.data.model.ErrorMessage
import com.tom.baseandroid.data.model.Player
import com.tom.baseandroid.data.repository.PlayerRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Named
import kotlin.Exception

class MainViewModel @Inject constructor(
    private val repository: PlayerRepository,
    private val dbService: DbService,
    @Named("IO") private val io: CoroutineDispatcher,
    @Named("MAIN") private val main: CoroutineDispatcher
) : BaseViewModel() {
    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> get() = _players

    fun getListPlayers() {
        viewModelScope.launch(main) {
            try {
                isLoading.postValue(true)
                val result = withContext(io) { async { repository.observerPlayers() } }
                result.await().apply {
                    _players.postValue(body())
                    isLoading.postValue(false)
                    if (body() != null) dbService.saveAll(body()!!)
                }
            } catch (e: Exception) {
                handleError(e.message)
            }
        }
    }

    private fun handleError(message: String?) {
        isLoading.postValue(false)
        error.postValue(ErrorMessage(message = message ?: "Unknown error"))
    }
}