package com.tom.baseandroid.di.module

import com.tom.baseandroid.di.scope.FragmentScoped
import com.tom.baseandroid.ui.home.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *Created by VanTrang.
 */

@Module
abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeNewFeedFragment(): NewFeedFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeLiveStreamFragment(): LiveStreamFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeNotificationFragment(): NotificationFragment

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeAccountFragment(): AccountFragment
}