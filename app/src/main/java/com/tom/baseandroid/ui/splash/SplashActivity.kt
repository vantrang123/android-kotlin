package com.tom.baseandroid.ui.splash

import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.databinding.ActivitySplashBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.lauchActivity
import com.tom.baseandroid.preference.IConfigurationPrefs
import com.tom.baseandroid.ui.login.LoginActivity
import com.tom.baseandroid.ui.main.MainActivity
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    @Inject
    lateinit var pref: IConfigurationPrefs

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun initView() {
        binding.ivLogo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in).apply {
            duration =  2_000
        })
        Handler(Looper.getMainLooper()).postDelayed({
            if (pref.user == null) lauchActivity<LoginActivity> { } else lauchActivity<MainActivity> { }
        }, 2_000)
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_splash
}