package com.rikai.baseandroid.notify

import com.github.nkzawa.emitter.Emitter
import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket
import com.rikai.baseandroid.data.model.BaseConfig
import com.rikai.baseandroid.preference.IConfigurationPrefs
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SocketManager @Inject constructor(
        private val baseConfig: BaseConfig,
        private val prefs: IConfigurationPrefs
) : Emitter.Listener {

    private var mSocket: Socket? = null
    private var channels = arrayListOf<String>()
    private var listener: ((String) -> Unit)? = null

    fun init() {
        prefs.apiToken?.let {
            val opts = IO.Options()
            opts.forceNew = true
            opts.query = "token=$it"
            opts.transports = arrayOf("websocket")
            mSocket = IO.socket(baseConfig.socketUrl, opts)
            Timber.d("Init here!")
        }
    }

    fun onChannels(channels: ArrayList<String>) {
        checkSocket()
        mSocket?.let { socket ->
            channels.forEach {
                if (!this.channels.contains(it)) {
                    this.channels.add(it)
                    socket.on(it, this@SocketManager)
                    Timber.d("On Channels here! $it")
                }
            }
        }
    }

    fun isRegisterSocketListener(): Boolean {
        return when {
            mSocket == null -> false
            mSocket?.connected() == false -> false
            channels.isEmpty() -> false
            else -> true
        }
    }

    fun sendData(key: String, data: Any) {

        checkSocket()

        mSocket?.emit(key, data)
    }

    private fun checkSocket() {
        if (mSocket == null) {
            init()
        }

        if (mSocket?.connected() != true) {
            connect()
        }
    }

    private fun removeChannels() {
        mSocket?.apply {
            channels.forEach {
                off(it)
            }
            Timber.d("Remove here!")
        }
    }

    private fun connect() {
        mSocket?.apply {
            connect()
            Timber.d("Connect here!")
        }
    }

    fun disconnect() {
        removeChannels()
        channels.clear()
        mSocket?.apply {
            disconnect()
            mSocket = null
            Timber.d("Disconnect here!")
        }
    }

    fun setListener(listener: (String) -> Unit) {
        this.listener = listener
    }

    override fun call(vararg args: Any?) {
        if (args.isNotEmpty()) {
            args[0]?.let { message ->
                Timber.d("Message--------------------- $message")
                this.listener?.let {
                    it(message.toString())
                }
            }
        }
    }
}