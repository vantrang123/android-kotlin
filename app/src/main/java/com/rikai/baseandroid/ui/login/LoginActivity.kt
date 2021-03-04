package com.rikai.baseandroid.ui.login

import androidx.navigation.fragment.NavHostFragment
import com.rikai.baseandroid.R
import com.rikai.baseandroid.base.BaseActivity
import com.rikai.baseandroid.databinding.ActivityLoginBinding
import com.rikai.baseandroid.di.injectViewModel
import com.rikai.baseandroid.ui.main.MainViewModel
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