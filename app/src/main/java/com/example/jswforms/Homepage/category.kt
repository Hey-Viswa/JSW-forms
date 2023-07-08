package com.example.jswforms.Homepage

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
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


        LogoutibBtn.setOnClickListener {
          firebaseAuth.signOut()
            startActivity(Intent(this@category,Login_Screen::class.java))

        }

        OfficialCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/e/1FAIpQLSfRdx856GNoLnL8yoMOqdszFEhZmFM4cbWHorowzWuk5IZPGg/viewform"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        JobApplication.setOnClickListener {
            val url =
               "https://docs.google.com/forms/d/e/1FAIpQLSfI5uohnvJG5OeyhYYaHRt5SxMsQSDWrPl2F0-SrgiaafKtNg/viewform"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        EventCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/e/1FAIpQLSczGErrq6po4tOf7qkqlTR8H4QNjFasD1MkZAE_yfCNL98xRg/viewform"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        CostumerCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/e/1FAIpQLSeVQQXAV4kdSwdzoOFWbCGzADXNHn3HbmdPGtuV_oGqplF2GQ/viewform"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        VendorCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/e/1FAIpQLSf5kMXYbU64hJWDDKxT-Br4G-jzdt4D6_F95xsWvgn-ULXpzg/viewform"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }


}
