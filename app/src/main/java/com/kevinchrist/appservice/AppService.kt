package com.kevinchrist.appservice

import android.app.DownloadManager
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import android.util.Log
import androidx.core.net.toUri


class AppService : Service() {
    companion object {
        const val TAG = "AppService"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(TAG, "AppService.onStartCommand()")

        // Start the APK download process here
        val apkUrl = "https://github.com/kevinchrist20/android-system-app/raw/main/memer.apk"
        download(apkUrl)

        return START_STICKY
    }

    private fun download(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("*/*")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("Hubtel Store Download")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "hubtel-store.apk")
        val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        return downloadManager.enqueue(request)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}