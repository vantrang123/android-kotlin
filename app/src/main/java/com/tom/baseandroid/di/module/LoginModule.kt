package com.tom.baseandroid.di.module

import com.tom.baseandroid.di.scope.FragmentScoped
import com.tom.baseandroid.ui.login.LoginFragment
import com.tom.baseandroid.ui.login.SignUpFragment
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