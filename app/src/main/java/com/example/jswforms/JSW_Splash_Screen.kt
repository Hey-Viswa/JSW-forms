package com.example.jswforms

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView

@Suppress("DEPRECATION")
class JSW_Splash_Screen : AppCompatActivity() {

    lateinit var JswSplash: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jsw_splash_screen)

        JswSplash = findViewById(R.id.ivJswLogoSplash)


        Handler().postDelayed({
            val intent = Intent(this@JSW_Splash_Screen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)


    }


}