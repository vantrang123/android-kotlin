package com.tom.baseandroid.ui.login

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.databinding.ActivityLoginBinding
import com.tom.baseandroid.di.injectViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun initView() {
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_login
}