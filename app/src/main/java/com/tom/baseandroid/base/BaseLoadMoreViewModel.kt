package com.tom.baseandroid.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tom.baseandroid.utils.NetworkState

abstract class BaseLoadMoreViewModel<T> : BaseViewModel() {
    var total = 15
    protected var page = 0

    protected val _state = MutableLiveData<NetworkState>()
    val state: LiveData<NetworkState>
        get() = _state

    protected val _list = MutableLiveData<MutableList<T>>()
    val data: LiveData<MutableList<T>>
        get() = _list

    fun loadData(isRefresh: Boolean, isLoggedIn: Boolean = true) {
        if (!isLoggedIn) {
            refreshData()
            return
        }
        when {
            state.value == NetworkState.LOADING -> {
                return
            }
            isRefresh -> {
                page = 0
            }
            (_list.value?.size ?: 0) < total -> {
                page += 1
            }
            else -> return
        }
        loadMore()
    }

    private fun refreshData() {
        total = 15
        page = 0
        _state.postValue(NetworkState.LOADED)
        _list.postValue(arrayListOf())
    }

    fun setLoading() {
        isLoading.postValue(page == 0)
        if (page != 0) {
            _state.postValue(NetworkState.LOADING)
        }
    }

    fun dismissLoading() {
        isLoading.postValue(false)
        if (page != 0) {
            _state.postValue(NetworkState.LOADED)
        }
    }

    protected abstract fun loadMore()
}