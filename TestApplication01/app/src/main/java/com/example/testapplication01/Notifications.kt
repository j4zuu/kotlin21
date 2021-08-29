package com.example.testapplication01

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class Notifications : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    /**
     * Create a channel, so it can be used to show notifications
     */
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "Channel 1",
                NotificationManager.IMPORTANCE_LOW
            )
            channel1.description = "This is Channel 1"
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(channel1)
        }
    }

    companion object {
        const val CHANNEL_1_ID = "channel1"
    }
}