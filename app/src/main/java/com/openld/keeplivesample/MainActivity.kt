package com.openld.keeplivesample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.openld.keeplivesample.keeplive.KeepLiveActivity
import com.openld.keeplivesample.keeplive.KeepLiveService

/**
 * author: lllddd
 * created on: 2022/12/23 16:16
 * description:主Activity
 */
class MainActivity : AppCompatActivity() {
    private lateinit var mBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 此处启动服务
        startService(Intent(this, KeepLiveService::class.java))

        mBtn = findViewById(R.id.btn)
        mBtn.setOnClickListener {
            startActivity(Intent(this, KeepLiveActivity::class.java))
            finish()
        }

        Toast.makeText(this, "MainActivity onCreate", Toast.LENGTH_SHORT).show()
    }
}