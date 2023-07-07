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
    private lateinit var EducationCategory: CardView
    private lateinit var CostumerCategory: CardView
    private lateinit var VendorCategory: CardView
    private lateinit var LogoutibBtn: ImageView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        OfficialCategory = findViewById(R.id.Officialcat)
        JobApplication = findViewById(R.id.catJobApplication)
        EventCategory = findViewById(R.id.Eventcat)
        EducationCategory = findViewById(R.id.educat)
        CostumerCategory = findViewById(R.id.clientcat)
        VendorCategory = findViewById(R.id.vendorcat)


        OfficialCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/1-vuGC4Xwoi6Jc8NfubdGzVcbCmt21daGgrabqKFT1e8/edit"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        JobApplication.setOnClickListener {
            val url =
               "https://docs.google.com/forms/d/18JISq9GR6V2jOMCjeeQyOoq2RoKSWLlxMvSj3sbwdwE/edit"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        EventCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/u/0/d/1-Bs75BfRhy-uWs-B_Bs6Fwro5DSxzrIWys7Mwo5uk-A/edit?ntd=1&usp=forms_home&ths=true"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        EducationCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/1NI_DbnfLX_DPgV_4W2J53AUflvxO1M_HEz_JgeAQR_4/edit"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        CostumerCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/1zESTtHRalW47eTJPBCDJLMwS3iheQ1Tbkwe6RhYnYkY/edit"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        VendorCategory.setOnClickListener {
            val url =
                "https://docs.google.com/forms/d/1WIhzPXY0eWtcJdsOY6-_BV-Tr9ZN2DupF4pZwdKTIdo/edit"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }


}
