package com.example.jswforms.Forgot_Password

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.jswforms.Login_and_Register_Activity.Login_Screen
import com.example.jswforms.R
import com.google.firebase.auth.FirebaseAuth

class Forgot_Password : AppCompatActivity() {

    private lateinit var backToLogin : TextView
    private lateinit var EtForgotPasswordEmail : EditText
    private lateinit var btnForgetPassword : Button
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        backToLogin = findViewById(R.id.backToLogin)
        EtForgotPasswordEmail = findViewById(R.id.EtForgotPasswordEmail)
        btnForgetPassword = findViewById(R.id.btnForgetPassword)

        firebaseAuth = FirebaseAuth.getInstance()

        backToLogin.setOnClickListener {
            val intent = Intent(this@Forgot_Password, Login_Screen::class.java)
            startActivity(intent)
        }

        btnForgetPassword.setOnClickListener {
            val sPassword = EtForgotPasswordEmail.text.toString()
            firebaseAuth.sendPasswordResetEmail(sPassword)
                .addOnSuccessListener {
                    Toast.makeText(this, "Please check your email", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                }
        }



    }
}