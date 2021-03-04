package com.tom.baseandroid.base

import androidx.lifecycle.MutableLiveData
import com.tom.baseandroid.data.model.ErrorMessage

interface IViewModel {
    var isLoading: MutableLiveData<Boolean>
    var error: MutableLiveData<ErrorMessage>
}