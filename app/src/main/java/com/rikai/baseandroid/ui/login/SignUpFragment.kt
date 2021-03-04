package com.rikai.baseandroid.ui.login

import com.rikai.baseandroid.R
import com.rikai.baseandroid.base.BaseFragment
import com.rikai.baseandroid.base.EmptyViewModel
import com.rikai.baseandroid.databinding.FragmentSignUpBinding
import com.rikai.baseandroid.di.injectViewModel

class SignUpFragment : BaseFragment<FragmentSignUpBinding, EmptyViewModel>() {

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {

    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_sign_up
}