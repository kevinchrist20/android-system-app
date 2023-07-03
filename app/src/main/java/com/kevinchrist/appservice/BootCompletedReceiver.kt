package com.kevinchrist.appservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootCompletedReceiver : BroadcastReceiver() {
    companion object {
        const val TAG = "BootReceiver"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.v(TAG, "BootReceiver.onReceive()")

        if (intent?.action == Intent.ACTION_BOOT_COMPLETED || intent?.action == Intent.ACTION_USER_PRESENT) {
            println("Boot completed [Clicked!]")
            context?.startService(Intent(context, AppService::class.java))
        }
    }
}