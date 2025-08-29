package com.example.labtest2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class PackageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package)

        // --- Bottom Navigation Views ---
        val navHome: LinearLayout = findViewById(R.id.navHome)
        val navProfile: LinearLayout = findViewById(R.id.navProfile)
        val navNotifications: LinearLayout = findViewById(R.id.navNotifications)
        val navPackages: LinearLayout = findViewById(R.id.navPackages)
        val navSOS: LinearLayout = findViewById(R.id.navSOS)

        // --- Purchase Button Views - FIXED TO USE ACTUAL BUTTONS ---
        val btnSinglePurchase: Button = findViewById(R.id.btnSinglePurchase)
        val btnDayPassPurchase: Button = findViewById(R.id.btnDayPassPurchase)
        val btnMonthlyPurchase: Button = findViewById(R.id.btnMonthlyPurchase)

        // --- Navigation Clicks ---
        navHome.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
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
            // Already on Packages → do nothing
        }

        navSOS.setOnClickListener {
            val intent = Intent(this, SOSActivity::class.java)
            startActivity(intent)
            finish()
        }

        // --- Purchase Button Clicks - NOW WORKS WITH ACTUAL BUTTONS ---
        btnSinglePurchase.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("PACKAGE_TYPE", "SINGLE_TICKET")
            intent.putExtra("PACKAGE_PRICE", "Rs.100")
            intent.putExtra("PACKAGE_NAME", "Single Ticket")
            startActivity(intent)
        }

        btnDayPassPurchase.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("PACKAGE_TYPE", "DAY_PASS")
            intent.putExtra("PACKAGE_PRICE", "Rs.300")
            intent.putExtra("PACKAGE_NAME", "Day Pass")
            startActivity(intent)
        }

        btnMonthlyPurchase.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("PACKAGE_TYPE", "MONTHLY_PASS")
            intent.putExtra("PACKAGE_PRICE", "Rs.1500")
            intent.putExtra("PACKAGE_NAME", "Monthly Pass")
            startActivity(intent)
        }
    }
}