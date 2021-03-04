package com.rikai.baseandroid.ui

import com.rikai.baseandroid.R
import com.rikai.baseandroid.base.BaseActivity
import com.rikai.baseandroid.base.EmptyViewModel
import com.rikai.baseandroid.databinding.ActivityEmptyBinding
import com.rikai.baseandroid.di.injectViewModel

class EmptyActivity : BaseActivity<ActivityEmptyBinding, EmptyViewModel>() {
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_empty
}