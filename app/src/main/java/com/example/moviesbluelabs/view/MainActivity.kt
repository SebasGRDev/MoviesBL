package com.example.moviesbluelabs.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.moviesbluelabs.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread.sleep(3000)
        splashScreen.setKeepOnScreenCondition { true }

        val intent = Intent(this, ActivityMovie::class.java )
        startActivity(intent)
        finish()
    }
}