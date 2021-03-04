package com.rikai.baseandroid.di.module

import android.content.Context
import com.rikai.baseandroid.Application
import com.rikai.baseandroid.BuildConfig
import com.rikai.baseandroid.R
import com.rikai.baseandroid.data.local.DbService
import com.rikai.baseandroid.data.model.BaseConfig
import com.rikai.baseandroid.data.remote.Service
import com.rikai.baseandroid.preference.ConfigurationPrefs
import com.rikai.baseandroid.preference.IConfigurationPrefs
import com.rikai.baseandroid.utils.Constants
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): Service =
        retrofit.create(Service::class.java)

    @Provides
    @Singleton
    @Named("IO")
    fun provideBackgroundDispatchers(): CoroutineDispatcher =
        Dispatchers.IO

    @Provides
    @Singleton
    @Named("MAIN")
    fun provideMainDispatchers(): CoroutineDispatcher =
        Dispatchers.Main

    @Provides
    @Singleton
    fun provideDbService() = DbService()

    @Provides
    fun provideBaseConfig(context: Context): BaseConfig {
        return BaseConfig(
                BuildConfig.APPLICATION_ID,
                Constants.SOCKET_URL,
                BuildConfig.BASE_URL,
                "",
                context.getString(R.string.app_name)
        )
    }

    @Singleton
    @Provides
    fun provideManagerPrefs(context: Context, baseConfig: BaseConfig): IConfigurationPrefs {
        return ConfigurationPrefs(
            context,
            baseConfig
        )
    }
}