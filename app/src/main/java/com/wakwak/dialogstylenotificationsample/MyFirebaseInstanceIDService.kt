package com.wakwak.dialogstylenotificationsample

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by Ryo on 2016/11/08.
 */
class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {

    companion object {
        private val TAG = MyFirebaseInstanceIDService::class.java.simpleName
    }

    override fun onTokenRefresh() {
        super.onTokenRefresh()
        val token = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Token is $token")
    }
}
