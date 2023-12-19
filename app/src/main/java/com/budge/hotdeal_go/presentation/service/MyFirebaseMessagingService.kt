package com.budge.hotdeal_go.presentation.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.budge.hotdeal_go.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private const val NOTIFICATION_CHANNEL_ID = "com.budge.hotdeal_go"
        private const val NOTIFICATION_CHANNEL_NAME = "Notification"
        private const val NOTIFICATION_CHANNEL_DESCRIPTION = "notification channel"
    }

    // Refreshed Token 로그 확인 메서드
    override fun onNewToken(token: String) {
        Log.d("FCM Log", "Refreshed token: $token")
    }

    // FCM을 통해 디바이스에 메시지가 도착하면 동작하는 메서드
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.data.isNotEmpty()) {
            // 여기서는 메시지의 데이터 값 "content"를 꺼낸다.
            val content = remoteMessage.data["content"]
            showNotification(content)
        }
    }

    // 실질적으로 디바이스에 알림이 푸쉬될 수 있도록 하는 메서드
    private fun showNotification(content: String?) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }

        // 키워드 알림이기 때문에, 먼저 알림 테스트 후 수정 필요
        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(true)
            .setDefaults(Notification.DEFAULT_ALL)
            .setWhen(System.currentTimeMillis())
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("A new post you might be interested in.")
            .setContentText(content)
            .setContentInfo("Info")

        notificationManager.notify((0..Int.MAX_VALUE).random(), notificationBuilder.build())
    }

    private fun createNotificationChannel(manager: NotificationManager) {
        val notificationChannel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
        } else {
            null
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel?.description = NOTIFICATION_CHANNEL_DESCRIPTION
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            manager.createNotificationChannel(notificationChannel!!)
        }
    }
}