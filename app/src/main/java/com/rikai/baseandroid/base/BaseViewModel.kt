package com.rikai.baseandroid.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rikai.baseandroid.data.model.ErrorMessage

abstract class BaseViewModel : ViewModel(), IViewModel {
    override var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    override var error: MutableLiveData<ErrorMessage> = MutableLiveData()
}