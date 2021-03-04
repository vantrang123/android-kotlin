package com.tom.baseandroid.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by vantrang on 8/16/20.
 */
class NetworkUtil {
    companion object {
        @SuppressLint("MissingPermission")
        fun isConnected(context: Context): Boolean {
            val cm: ConnectivityManager? = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo?
            activeNetwork = cm?.activeNetworkInfo
            return null != activeNetwork && activeNetwork.isConnected
        }
    }
}