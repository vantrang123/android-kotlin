package com.tom.baseandroid.di.module

import android.content.Context
import com.tom.baseandroid.R
import com.tom.baseandroid.data.model.BaseConfig
import com.tom.baseandroid.preference.IConfigurationPrefs
import com.tom.baseandroid.utils.Constants
import com.tom.baseandroid.utils.NetworkUtil.Companion.isConnected
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
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
    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor, context: Context, prefs: IConfigurationPrefs): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(45L, TimeUnit.SECONDS)
                .writeTimeout(45L, TimeUnit.SECONDS)
                .readTimeout(45L, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor {
                    if (!isConnected(context))
                        throw IOException(
                                context.getString(R.string.no_network)
                        )
                    val request = it.request()
                    val builder = request.newBuilder()
                            .addHeader("Content-Type", "application/x-www-form-urlencoded")
                            .addHeader("Content-Language", prefs.language)
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
    fun provideRetrofit(baseConfig: BaseConfig, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(baseConfig.endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }
}