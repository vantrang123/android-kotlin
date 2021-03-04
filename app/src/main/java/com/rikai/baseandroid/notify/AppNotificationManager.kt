package com.rikai.baseandroid.notify

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.rikai.baseandroid.event.RxEvent
import com.rikai.baseandroid.event.SystemEvent
import com.rikai.baseandroid.extensions.getDefault
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

object AppNotificationManager {

    fun createNotificationChannel(context: Context, channelId: String, channelName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val descriptionText = "description Text"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun handleNotification(
            context: Context,
            remoteMessage: RemoteMessage,
            channelId: String,
            @DrawableRes smallIcon: Int,
            intent: Intent
    ) {

        val title = remoteMessage.data["title"]
        val message = remoteMessage.data["message"]
        if (title.isNullOrEmpty() || message.isNullOrEmpty()) {
            FirebaseAnalytics.getInstance(context).logEvent("PUSH_NOTIFICATION_ERROR", Bundle().apply {
                putString("data", Gson().toJson(remoteMessage))
            })
            return
        }
        showNotification(
            context,
            title.getDefault(),
            message.getDefault(),
            channelId,
            smallIcon,
            PendingIntent.getActivity(
                context,
                Random().nextInt(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )
        )

        RxEvent.send(SystemEvent.PushNotification(remoteMessage.data.toString()))
    }

    private fun showNotification(
        context: Context,
        title: String,
        message: String,
        channelId: String,
        @DrawableRes smallIcon: Int,
        pendingIntent: PendingIntent?
    ) {

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(smallIcon)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(context)) {
            notify(NotificationID.id, builder.build())
        }
    }

    object NotificationID {
        private val c = AtomicInteger(0)
        val id: Int
            get() = c.incrementAndGet()
    }
}