package com.tom.baseandroid.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tom.baseandroid.BuildConfig
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.BaseConfig
import com.tom.baseandroid.data.network.NoConnectionException
import com.tom.baseandroid.data.remote.Service
import com.tom.baseandroid.preference.IConfigurationPrefs
import com.tom.baseandroid.utils.Constants
import com.tom.baseandroid.utils.NetworkUtil.Companion.isConnected
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        context: Context,
        prefs: IConfigurationPrefs
    ): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .protocols(listOf(Protocol.HTTP_1_1))
            .connectTimeout(45L, TimeUnit.SECONDS)
            .writeTimeout(45L, TimeUnit.SECONDS)
            .readTimeout(45L, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor {
                if (!isConnected(context))
                    throw NoConnectionException(
                        context.getString(R.string.no_network)
                    )
                val request = it.request()
                val builder = request.newBuilder()
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Content-Language", prefs.language)
                    .addHeader(
                        "x-rapidapi-key",
                        BuildConfig.APIKEY
                    )
                    .addHeader("x-rapidapi-host", "shopee.p.rapidapi.com")
                prefs.apiToken?.let { accessToken ->
                    builder.addHeader(
                        "Authorization",
                        "${Constants.KEY_BEARER} $accessToken"
                    )
                }
                it.proceed(builder.build())
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseConfig: BaseConfig, okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(baseConfig.endPoint)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
}