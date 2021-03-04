package com.tom.baseandroid.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tom.baseandroid.data.model.ErrorMessage
import com.tom.baseandroid.data.network.NetworkConnectionLiveData

abstract class BaseViewModel : ViewModel(), IViewModel {
    override var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    override var error: MutableLiveData<ErrorMessage> = MutableLiveData()
}