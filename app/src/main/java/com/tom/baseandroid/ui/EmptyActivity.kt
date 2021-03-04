package com.tom.baseandroid.ui

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.ActivityEmptyBinding
import com.tom.baseandroid.di.injectViewModel

class EmptyActivity : BaseActivity<ActivityEmptyBinding, EmptyViewModel>() {
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_empty
}