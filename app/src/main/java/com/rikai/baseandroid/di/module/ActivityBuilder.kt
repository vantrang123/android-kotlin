package com.rikai.baseandroid.di.module

import com.rikai.baseandroid.di.scope.ActivityScoped
import com.rikai.baseandroid.ui.EmptyActivity
import com.rikai.baseandroid.ui.login.LoginActivity
import com.rikai.baseandroid.ui.main.MainActivity
import com.rikai.baseandroid.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributesSplashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun contributesLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributesEmptyActivity(): EmptyActivity
}