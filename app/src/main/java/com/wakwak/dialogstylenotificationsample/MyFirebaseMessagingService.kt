package com.wakwak.dialogstylenotificationsample

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by Ryo on 2016/11/08.
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        val message = remoteMessage?.notification?.body
        startActivity(NotificationActivity.createIntent(applicationContext, "タイトル", message ?: "メッセージ"))
    }
}
