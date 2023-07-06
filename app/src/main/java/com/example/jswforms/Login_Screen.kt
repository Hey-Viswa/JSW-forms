package com.example.jswforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.Motion
import com.example.jswforms.databinding.ActivityLoginScreenBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Screen : AppCompatActivity() {


    lateinit var password : EditText
    var passwordVisible: Boolean = false
    private lateinit var binding : ActivityLoginScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        password = findViewById(R.id.EtPassword)

        binding.btnLogin.setOnClickListener {
            val email = binding.EtEmail.text.toString()
            val password = binding.EtPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.LoginRegister.setOnClickListener {
            val signupIntent = Intent(this,Register_Activity::class.java)
            startActivity(signupIntent)
        }

        password.setOnTouchListener { v, event ->
            val Right = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX > password.right - password.compoundDrawables[Right].bounds.width()) {
                    val selection = password.selectionEnd
                    if (passwordVisible) {
                        password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_visibility_off_24, 0)
                        password.transformationMethod = PasswordTransformationMethod.getInstance()
                        passwordVisible = false
                    } else {
                        password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_remove_red_eye_24, 0)
                        password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                        passwordVisible = true
                    }
                    password.setSelection(selection)
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }





    }
}