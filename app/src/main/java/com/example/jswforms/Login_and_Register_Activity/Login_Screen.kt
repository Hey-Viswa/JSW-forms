package com.example.jswforms.Login_and_Register_Activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.jswforms.Homepage.category

import com.example.jswforms.MainActivity.MainActivity
import com.example.jswforms.R
import com.example.jswforms.databinding.ActivityLoginScreenBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class Login_Screen : AppCompatActivity() {


    lateinit var password : EditText
    lateinit var LoginWithGoogle : SignInButton

    var passwordVisible: Boolean = false
    private lateinit var binding : ActivityLoginScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

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
        LoginWithGoogle = findViewById(R.id.LoginWithGoogle)
        firebaseAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)

        LoginWithGoogle.setOnClickListener{
            signInGoogle()
        }

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
    private fun signInGoogle(){
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResult(task)
        }
    }

    private fun handleResult(task: Task<GoogleSignInAccount>) {
       if (task.isSuccessful){
           val account : GoogleSignInAccount? = task.result
           if (account != null){
               updateUi(account)
           }
       }else{
           Toast.makeText(this,task.exception.toString(),Toast.LENGTH_SHORT).show()
       }
    }

    private fun updateUi(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
            if(it.isSuccessful){
                val intent : Intent = Intent(this@Login_Screen,category::class.java )
            }else{
                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }
}