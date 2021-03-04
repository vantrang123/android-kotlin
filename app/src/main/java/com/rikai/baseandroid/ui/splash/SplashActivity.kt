package com.rikai.baseandroid.ui.splash

import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.rikai.baseandroid.R
import com.rikai.baseandroid.base.BaseActivity
import com.rikai.baseandroid.databinding.ActivitySplashBinding
import com.rikai.baseandroid.di.injectViewModel
import com.rikai.baseandroid.extensions.lauchActivity
import com.rikai.baseandroid.ui.login.LoginActivity

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun initView() {
        binding.ivLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in).apply {
            duration =  2_000
        })

        Handler(Looper.getMainLooper()).postDelayed({
            lauchActivity<LoginActivity> { }
            overridePendingTransition(R.anim.hold, R.anim.enter)
        }, 2_000)
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_splash
}