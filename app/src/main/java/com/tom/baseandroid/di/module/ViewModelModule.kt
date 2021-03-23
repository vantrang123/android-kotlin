package com.tom.baseandroid.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.di.ViewModelKey
import com.tom.baseandroid.di.factory.ViewModelFactory
import com.tom.baseandroid.ui.home.HomeViewModel
import com.tom.baseandroid.ui.login.LoginViewModel
import com.tom.baseandroid.ui.player.PlayerViewModel
import com.tom.baseandroid.ui.search.SearchViewModel
import com.tom.baseandroid.ui.splash.SplashViewModel
import com.tom.baseandroid.ui.tutorial.TutorialViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    internal abstract fun providesPlayerViewModel(viewModel: PlayerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun providesSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun providesLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EmptyViewModel::class)
    internal abstract fun providesEmptyViewModel(viewModel: EmptyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TutorialViewModel::class)
    internal abstract fun providesTutorialViewModel(viewModel: TutorialViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun providesHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun providesSearchViewModel(viewModel: SearchViewModel): ViewModel
}