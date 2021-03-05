package com.tom.baseandroid.ui

import android.content.Intent
import android.os.Bundle
import com.tom.baseandroid.Application
import com.tom.baseandroid.ui.splash.SplashActivity
import dagger.android.support.DaggerAppCompatActivity

/**
 *Created by VanTrang on 8/22/2019.
 */
class OutAppNotificationActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.getStringExtra(OUT_APP_NOTIFICATION_DATA)
        val type = intent.getStringExtra(OUT_APP_NOTIFICATION_TYPE)

        when {
            Application.isAppVisibility() -> {
                onVisible(true, type = type, data = data)
            }
            else -> {
                onVisible(false)
            }
        }
        finish()
    }

    private fun onVisible(isAppVisibility: Boolean, type: String? = null, data: String? = null) {
        when {
            isAppVisibility -> {
                notifyDirector(this, type, data)
            }
            else -> {
                startActivity(Intent(this, SplashActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                })
            }
        }
    }

    companion object {
        const val OUT_APP_NOTIFICATION_TYPE = "out_app_notification_type"
        const val OUT_APP_NOTIFICATION_DATA = "out_app_notification_data"

        fun notifyDirector(outAppNotificationActivity: OutAppNotificationActivity, type: String?, data: String?) {
            when (type) {
                else -> {
                }
            }
        }
    }
}