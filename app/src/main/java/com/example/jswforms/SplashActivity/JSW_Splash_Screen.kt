package com.example.jswforms.SplashActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.example.jswforms.Login_and_Register_Activity.Login_Screen
import com.example.jswforms.R

@Suppress("DEPRECATION")
class JSW_Splash_Screen : AppCompatActivity() {

    lateinit var JswSplash: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jsw_splash_screen)

        JswSplash = findViewById(R.id.ivJswLogoSplash)


        Handler().postDelayed({
            val intent = Intent(this@JSW_Splash_Screen, Login_Screen::class.java)
            startActivity(intent)
            finish()
        }, 2000)


    }


}