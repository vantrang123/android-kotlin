package com.tom.baseandroid.service

import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.tom.baseandroid.BuildConfig
import com.tom.baseandroid.R
import com.tom.baseandroid.notify.AppNotificationManager
import com.tom.baseandroid.ui.OutAppNotificationActivity

/**
 *Created by VanTrang on 8/22/2019.
 */
class MyFirebaseMessageService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val type = remoteMessage.data["refer_schema"]
        val data = remoteMessage.data["refer_id"]

        AppNotificationManager.handleNotification(this,
                remoteMessage,
                BuildConfig.APPLICATION_ID,
                R.drawable.ic_launcher_foreground,
                Intent(applicationContext, OutAppNotificationActivity::class.java).apply {
                    putExtra(OutAppNotificationActivity.OUT_APP_NOTIFICATION_TYPE, type)
                    putExtra(OutAppNotificationActivity.OUT_APP_NOTIFICATION_DATA, data)
                    addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                })
    }
}