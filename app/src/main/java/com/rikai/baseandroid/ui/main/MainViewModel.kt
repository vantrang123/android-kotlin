package com.rikai.baseandroid.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rikai.baseandroid.base.BaseViewModel
import com.rikai.baseandroid.data.local.DbService
import com.rikai.baseandroid.data.model.ErrorMessage
import com.rikai.baseandroid.data.model.Player
import com.rikai.baseandroid.data.repository.PlayerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

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
                val result = async(context = io) {
                    repository.observerPlayers()
                }
                result.await().apply {
                    _players.postValue(body())
                    isLoading.postValue(false)
                    if (body() != null) dbService.saveAll(body()!!)
                }
            } catch (e: Throwable) {
                error.postValue(ErrorMessage(message = e.message ?: "Unknown error"))
            }
        }
    }
}