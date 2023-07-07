package com.example.jswforms.Login_and_Register_Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jswforms.Homepage.category

import com.example.jswforms.MainActivity.MainActivity
import com.example.jswforms.R
import com.example.jswforms.databinding.ActivityLoginScreenBinding
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth


class Login_Screen : AppCompatActivity() {


    lateinit var password : EditText
    var passwordVisible: Boolean = false
    private lateinit var binding : ActivityLoginScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth

    // Configure sign-in to request the user's ID, email address, and basic
    // profile. ID and basic profile are included in DEFAULT_SIGN_IN.


    // Build a GoogleSignInClient with the options specified by gso.
    // Build a GoogleSignInClient with the options specified by gso.



    @SuppressLint("ClickableViewAccessibility")
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
                        val intent = Intent(this, category::class.java)
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
            val signupIntent = Intent(this, Register_Activity::class.java)
            startActivity(signupIntent)
        }

        password.setOnTouchListener { v, event ->
            val Right = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX > password.right - password.compoundDrawables[Right].bounds.width()) {
                    val selection = password.selectionEnd
                    if (passwordVisible) {
                        password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,
                            R.drawable.baseline_visibility_off_24, 0)
                        password.transformationMethod = PasswordTransformationMethod.getInstance()
                        passwordVisible = false
                    } else {
                        password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0,
                            R.drawable.baseline_remove_red_eye_24, 0)
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