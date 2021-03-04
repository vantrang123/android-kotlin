package com.rikai.baseandroid

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.rikai.baseandroid.data.model.BaseConfig
import com.rikai.baseandroid.di.component.DaggerAppComponent
import com.rikai.baseandroid.notify.AppNotificationManager
import com.rikai.baseandroid.notify.SocketManager
import com.rikai.baseandroid.preference.IConfigurationPrefs
import com.rikai.baseandroid.utils.Constants.ON_CHANGED_ORDER_STATUS
import com.rikai.baseandroid.utils.Constants.ON_CHANGED_SHOPPING_ORDER_STATUS
import com.rikai.baseandroid.utils.Constants.ON_CHANGED_SUBSCRIPTION
import com.rikai.baseandroid.utils.Constants.ON_CHANGE_SHOP_CONFIRM
import com.rikai.baseandroid.utils.Constants.ON_TRACKING_STAFF_LOCATION
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber
import javax.inject.Inject

class Application : DaggerApplication(), Application.ActivityLifecycleCallbacks {

    @Inject
    lateinit var mSocketManager: SocketManager

    @Inject
    lateinit var baseConfig: BaseConfig

    @Inject
    lateinit var configurationPrefs: IConfigurationPrefs

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()

        // realm
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("base.realm")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        // timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // notification
        AppNotificationManager.createNotificationChannel(
                this,
                baseConfig.applicationID,
                baseConfig.notificationChannelName
        )

        // socket
        if (!configurationPrefs.apiToken.isNullOrEmpty()) {
            onRegisterSocketListener(mSocketManager)
        } else {
            mSocketManager.disconnect()
        }
    }

    private fun onRegisterSocketListener(socketManager: SocketManager) {
        if (!socketManager.isRegisterSocketListener()) {
            socketManager.onChannels(
                    arrayListOf(
                            ON_CHANGED_ORDER_STATUS,
                            ON_CHANGE_SHOP_CONFIRM,
                            ON_TRACKING_STAFF_LOCATION,
                            ON_CHANGED_SHOPPING_ORDER_STATUS,
                            ON_CHANGED_SUBSCRIPTION
                    )
            )
        }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

    override fun onActivityStarted(activity: Activity) {}

    override fun onActivityResumed(activity: Activity) {}

    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {}
}