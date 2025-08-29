package com.example.labtest2

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class BusTrackingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_tracking)

        // Bottom Navigation Views
        val navHome: LinearLayout = findViewById(R.id.navHome)
        val navProfile: LinearLayout = findViewById(R.id.navProfile)
        val navNotifications: LinearLayout = findViewById(R.id.navNotifications)
        val navPackages: LinearLayout = findViewById(R.id.navPackages)
        val navSOS: LinearLayout = findViewById(R.id.navSOS)

        // --- Navigation Click Listeners ---
        navHome.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish() // close current activity so back button won't return here
        }

        navProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        navNotifications.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
            finish()
        }

        navPackages.setOnClickListener {
            val intent = Intent(this, PackageActivity::class.java)
            startActivity(intent)
            finish()
        }

        navSOS.setOnClickListener {
            val intent = Intent(this, SOSActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
