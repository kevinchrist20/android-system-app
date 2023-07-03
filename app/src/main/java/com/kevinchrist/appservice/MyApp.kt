package com.kevinchrist.appservice

import android.app.Application
import android.util.Log

class MyApp : Application() {
    companion object {
        const val TAG = "MyApp"
    }

    override fun onCreate() {
        Log.v(TAG, "BootReceiver.onReceive()")
        super.onCreate()
    }
}