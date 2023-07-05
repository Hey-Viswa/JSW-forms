package com.example.jswforms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jswforms.databinding.ActivityLoginScreenBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Screen : AppCompatActivity() {

    private lateinit var binding : ActivityLoginScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val email = binding.EtEmail.text.toString()
            val password = binding.EtPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                 if (it.isSuccessful){
                     val intent = Intent(this,MainActivity::class.java)
                     startActivity(intent)
                 } else {
                     Toast.
                 }
                }
            }
        }
    }
}