package com.example.jswforms.Login_and_Register_Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.jswforms.R
import com.example.jswforms.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var ivRegBackbtn: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ivRegBackbtn = findViewById(R.id.ivRegBackbtn)
        ivRegBackbtn.setImageResource(R.drawable.baseline_arrow_back_24)

        ivRegBackbtn.setOnClickListener {
            onBackPressed() // Redirect to the previous page
        }

        firebaseAuth = FirebaseAuth.getInstance()


        binding.btnRegister.setOnClickListener {
            val email = binding.EtRegEmail.text.toString()
            val password = binding.EtRegPassword.text.toString()
            val confirmPassword = binding.EtRegConfirmPassword.text.toString()


            if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if(password == confirmPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, Login_Screen::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this,"Password does not match",Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,"Fields cannot be empty",Toast.LENGTH_SHORT).show()
            }
        }
        binding.LoginRegister.setOnClickListener {
            val loginIntent = Intent(this, Login_Screen::class.java)
            startActivity(loginIntent)
        }



    }
}