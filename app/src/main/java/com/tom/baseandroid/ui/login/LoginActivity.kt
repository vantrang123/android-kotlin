package com.tom.baseandroid.ui.login

import androidx.lifecycle.Observer
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.data.network.NetworkConnectionLiveData
import com.tom.baseandroid.databinding.ActivityLoginBinding
import com.tom.baseandroid.di.injectViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun initView() {
        initViewModel()
    }

    override fun initViewModel() {
        super.initViewModel()
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_login

    override fun onBackPressed() {
        moveTaskToBack(false)
    }
}