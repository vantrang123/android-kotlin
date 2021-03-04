package com.tom.baseandroid.di.component

import com.tom.baseandroid.Application
import com.tom.baseandroid.di.module.ActivityBuilder
import com.tom.baseandroid.di.module.AppModule
import com.tom.baseandroid.di.module.NetworkModule
import com.tom.baseandroid.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        NetworkModule::class,
        AppModule::class,
        ViewModelModule::class,
    ]
)
interface AppComponent : AndroidInjector<Application> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}