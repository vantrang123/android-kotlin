package com.rikai.baseandroid.di.module

import com.rikai.baseandroid.di.scope.FragmentScoped
import com.rikai.baseandroid.ui.login.LoginFragment
import com.rikai.baseandroid.ui.login.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeLoginFragment(): LoginFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeSignUpFragment(): SignUpFragment
}