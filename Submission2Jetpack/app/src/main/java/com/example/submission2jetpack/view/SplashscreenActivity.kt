package com.example.submission2jetpack.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.submission2jetpack.R

class SplashscreenActivity : AppCompatActivity() {

    private val duration: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashscreenActivity, HomeActivity::class.java))
            finish()
        }, duration)
    }
}