package com.example.jswforms.Homepage

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.jswforms.Login_and_Register_Activity.Login_Screen
import com.example.jswforms.R
import com.google.firebase.auth.FirebaseAuth

class category : AppCompatActivity() {
    private lateinit var OfficialCategory: CardView
    private lateinit var JobApplication: CardView
    private lateinit var EventCategory: CardView
    private lateinit var CostumerCategory: CardView
    private lateinit var VendorCategory: CardView
    private lateinit var LogoutibBtn: ImageView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var userEmail: String
    private lateinit var btnsharelinkofficial : Button
    private lateinit var btnsharelinkjob : Button
    private lateinit var btnsharelinkevent : Button
    private lateinit var btnsharelinkcostumer : Button
    private lateinit var btnsharelinkvendor : Button

    private val urlOfficial = "https://docs.google.com/forms/d/e/1FAIpQLSfRdx856GNoLnL8yoMOqdszFEhZmFM4cbWHorowzWuk5IZPGg/viewform"
    private val urlJob = "https://docs.google.com/forms/d/e/1FAIpQLSfI5uohnvJG5OeyhYYaHRt5SxMsQSDWrPl2F0-SrgiaafKtNg/viewform"
    private val urlEvent = "https://docs.google.com/forms/d/e/1FAIpQLSczGErrq6po4tOf7qkqlTR8H4QNjFasD1MkZAE_yfCNL98xRg/viewform"
    private val urlCustomer = "https://docs.google.com/forms/d/e/1FAIpQLSeVQQXAV4kdSwdzoOFWbCGzADXNHn3HbmdPGtuV_oGqplF2GQ/viewform"
    private val urlVendor = "https://docs.google.com/forms/d/e/1FAIpQLSf5kMXYbU64hJWDDKxT-Br4G-jzdt4D6_F95xsWvgn-ULXpzg/viewform"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        OfficialCategory = findViewById(R.id.Officialcat)
        JobApplication = findViewById(R.id.catJobApplication)
        EventCategory = findViewById(R.id.Eventcat)
        CostumerCategory = findViewById(R.id.clientcat)
        VendorCategory = findViewById(R.id.vendorcat)
        firebaseAuth = FirebaseAuth.getInstance()
        LogoutibBtn = findViewById(R.id.LogoutibBtn)
        sharedPreferences = getSharedPreferences("login_prefs", MODE_PRIVATE)
        userEmail = firebaseAuth.currentUser?.email ?: ""
        btnsharelinkofficial = findViewById(R.id.btnsharelinkofficial)
        btnsharelinkjob = findViewById(R.id.btnsharelinkjob)
        btnsharelinkevent = findViewById(R.id.btnsharelinkevent)
        btnsharelinkcostumer = findViewById(R.id.btnsharelinkcostumer)
        btnsharelinkvendor = findViewById(R.id.btnsharelinkvendor)



        btnsharelinkofficial = findViewById(R.id.btnsharelinkofficial)
        btnsharelinkjob = findViewById(R.id.btnsharelinkjob)
        btnsharelinkevent = findViewById(R.id.btnsharelinkevent)
        btnsharelinkcostumer = findViewById(R.id.btnsharelinkcostumer)
        btnsharelinkvendor = findViewById(R.id.btnsharelinkvendor)

        btnsharelinkofficial.setOnClickListener {
            shareURL(urlOfficial)
        }

        btnsharelinkjob.setOnClickListener {
            shareURL(urlJob)
        }

        btnsharelinkevent.setOnClickListener {
            shareURL(urlEvent)
        }

        btnsharelinkcostumer.setOnClickListener {
            shareURL(urlCustomer)
        }

        btnsharelinkvendor.setOnClickListener {
            shareURL(urlVendor)
        }


        LogoutibBtn.setOnClickListener {
            firebaseAuth.signOut()
            saveLoginStatus(false)
            startActivity(Intent(this@category, Login_Screen::class.java))
            finish()
        }

        OfficialCategory.setOnClickListener {
            val url = "https://docs.google.com/forms/d/e/1FAIpQLSfRdx856GNoLnL8yoMOqdszFEhZmFM4cbWHorowzWuk5IZPGg/viewform" +
                    "?entry.fieldName1=$userEmail"

            openGoogleForm(url)
        }

        JobApplication.setOnClickListener {
            val url = "https://docs.google.com/forms/d/e/1FAIpQLSfI5uohnvJG5OeyhYYaHRt5SxMsQSDWrPl2F0-SrgiaafKtNg/viewform" +
                    "?entry.fieldName1=$userEmail"

            openGoogleForm(url)
        }

        EventCategory.setOnClickListener {
            val url = "https://docs.google.com/forms/d/e/1FAIpQLSczGErrq6po4tOf7qkqlTR8H4QNjFasD1MkZAE_yfCNL98xRg/viewform" +
                    "?entry.fieldName1=$userEmail"

            openGoogleForm(url)
        }

        CostumerCategory.setOnClickListener {
            val url = "https://docs.google.com/forms/d/e/1FAIpQLSeVQQXAV4kdSwdzoOFWbCGzADXNHn3HbmdPGtuV_oGqplF2GQ/viewform" +
                    "?entry.fieldName1=$userEmail"

            openGoogleForm(url)
        }

        VendorCategory.setOnClickListener {
            val url = "https://docs.google.com/forms/d/e/1FAIpQLSf5kMXYbU64hJWDDKxT-Br4G-jzdt4D6_F95xsWvgn-ULXpzg/viewform" +
                    "?entry.fieldName1=$userEmail"

            openGoogleForm(url)
        }
    }

    private fun openGoogleForm(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun saveLoginStatus(isLoggedIn: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("is_logged_in", isLoggedIn)
        editor.apply()
    }

    private fun shareURL(url: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, url)
        startActivity(Intent.createChooser(intent, "Share URL"))
    }

}
