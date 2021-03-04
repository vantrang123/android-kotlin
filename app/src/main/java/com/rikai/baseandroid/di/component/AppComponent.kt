package com.rikai.baseandroid.di.component

import com.rikai.baseandroid.Application
import com.rikai.baseandroid.di.module.ActivityBuilder
import com.rikai.baseandroid.di.module.AppModule
import com.rikai.baseandroid.di.module.NetworkModule
import com.rikai.baseandroid.di.module.ViewModelModule
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