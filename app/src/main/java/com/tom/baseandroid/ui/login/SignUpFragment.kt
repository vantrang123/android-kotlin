package com.tom.baseandroid.ui.login

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.FragmentSignUpBinding
import com.tom.baseandroid.di.injectViewModel

class SignUpFragment : BaseFragment<FragmentSignUpBinding, EmptyViewModel>() {

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {

    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_sign_up
}