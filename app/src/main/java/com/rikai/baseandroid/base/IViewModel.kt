package com.rikai.baseandroid.base

import androidx.lifecycle.MutableLiveData
import com.rikai.baseandroid.data.model.ErrorMessage

interface IViewModel {
    var isLoading: MutableLiveData<Boolean>
    var error: MutableLiveData<ErrorMessage>
}