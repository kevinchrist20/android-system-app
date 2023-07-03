package com.kevinchrist.appservice

import android.app.Application
import android.content.pm.ApplicationInfo
import android.util.Log
import android.os.Process

class MyApp : Application() {
    companion object {
        const val TAG = "MyApp"
    }

    override fun onCreate() {
        val appInfo: ApplicationInfo = applicationInfo
        Log.v(TAG, "BootReceiver.onReceive()")
        Log.e(TAG, "{Application UID: ${appInfo.uid} SYSTEM_UID: ${Process.SYSTEM_UID}")
        super.onCreate()
    }
}