package com.kevinchrist.appservice

import android.app.DownloadManager
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import android.util.Log


class AppService : Service() {
    companion object {
        const val TAG = "AppService"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(TAG, "AppService.onStartCommand()")

        // Start the APK download process here
        val apkUrl = "https://example.com/path/to/your/app.apk"
        startDownload(apkUrl)

        // Return START_STICKY to ensure the service is restarted if it's terminated by the system
        return START_STICKY
    }

    private fun startDownload(apkUrl: String) {
        // Create a download manager request
        val request = DownloadManager.Request(Uri.parse(apkUrl))
            .setTitle("App Download")
            .setDescription("Downloading app...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "hubtel-store.apk")

        // Get the download manager service and enqueue the download request
        val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = downloadManager.enqueue(request)

        // Optionally, you can listen for download completion or handle other download events
        // by querying the download manager using the download ID


        // Stop the service once the download is initiated
        stopSelf()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}