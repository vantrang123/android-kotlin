package com.tom.baseandroid.di.module

import com.tom.baseandroid.di.scope.ActivityScoped
import com.tom.baseandroid.ui.EmptyActivity
import com.tom.baseandroid.ui.login.LoginActivity
import com.tom.baseandroid.ui.main.MainActivity
import com.tom.baseandroid.ui.splash.SplashActivity
import com.tom.baseandroid.ui.tutorial.TutorialActivity
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

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributesTutorialActivity(): TutorialActivity
}