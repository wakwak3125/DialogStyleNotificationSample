package com.wakwak.dialogstylenotificationsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity

class NotificationActivity : AppCompatActivity() {

    private val title by lazy { intent.getStringExtra(TITLE) }
    private val message by lazy { intent.getStringExtra(MESSAGE) }

    companion object {
        val TITLE = "title"
        val MESSAGE = "message"

        fun createIntent(context: Context, title: String = "タイトル", message: String = "メッセージ"): Intent {
            return Intent(context, NotificationActivity::class.java).apply {
                // バックグランドからActivityを起動する際はこのフラグが必要。
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra(TITLE, title)
                putExtra(MESSAGE, message)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // 表示するダイアログが複雑な機能を要するならDialogFragmentにする必要があります。
        AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", { d, i ->
                    d.dismiss()
                    this@NotificationActivity.finish()
                })
                .setNegativeButton("CANCEL", { d, i ->
                    d.dismiss()
                    this@NotificationActivity.finish()
                })
                .show()
    }

    override fun finish() {
        super.finish()
        // 終了時にfade_outするようにしておくことでダサくなりません。
        // きちんとダイアログが消えると同時にActivityもfade_outしてくれます。
        overridePendingTransition(0, android.R.anim.fade_out);
    }
}
