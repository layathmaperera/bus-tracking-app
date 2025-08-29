package com.example.labtest2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.labtest2.DashboardActivity
import com.example.labtest2.R
import com.example.labtest2.WelcomeActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // === Buttons ===
        val btnSave: Button = findViewById(R.id.btnSave)
        val btnLogout: Button = findViewById(R.id.btnLogout)

        // ✅ Save Changes → go to Dashboard
        btnSave.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Logout → go to Welcome
        btnLogout.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        //  Back to Home → also go to Dashboard
//        tvBackHome.setOnClickListener {
//            val intent = Intent(this, DashboardActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
    }
}
