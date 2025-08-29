// STEP 1: Add this debugging code to ONE of your activities (like SOSActivity)
// to test what's actually happening when you click packages

package com.example.labtest2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SOSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sosactivity)

        // Log to confirm we're in SOS
        Log.d("DEBUG_NAV", "SOSActivity opened")

        // Find navigation elements with null checks
        val navHome = findViewById<LinearLayout>(R.id.navHome)
        val navProfile = findViewById<LinearLayout>(R.id.navProfile)
        val navNotifications = findViewById<LinearLayout>(R.id.navNotifications)
        val navPackages = findViewById<LinearLayout>(R.id.navPackages)
        val navSOS = findViewById<LinearLayout>(R.id.navSOS)

        // Check if navigation elements were found
        Log.d("DEBUG_NAV", "navHome found: ${navHome != null}")
        Log.d("DEBUG_NAV", "navProfile found: ${navProfile != null}")
        Log.d("DEBUG_NAV", "navNotifications found: ${navNotifications != null}")
        Log.d("DEBUG_NAV", "navPackages found: ${navPackages != null}")
        Log.d("DEBUG_NAV", "navSOS found: ${navSOS != null}")

        if (navPackages == null) {
            Log.e("DEBUG_NAV", "navPackages is NULL! Check your layout file!")
            Toast.makeText(this, "navPackages not found in layout!", Toast.LENGTH_LONG).show()
            return
        }

        // Regular navigation
        navHome.setOnClickListener {
            Log.d("DEBUG_NAV", "HOME clicked from SOS")
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        navProfile.setOnClickListener {
            Log.d("DEBUG_NAV", "PROFILE clicked from SOS")
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        navNotifications.setOnClickListener {
            Log.d("DEBUG_NAV", "NOTIFICATIONS clicked from SOS")
            startActivity(Intent(this, NotificationActivity::class.java))
            finish()
        }

        // PACKAGES - WITH EXTENSIVE DEBUGGING
        navPackages.setOnClickListener {
            Log.d("DEBUG_NAV", "=== PACKAGES CLICKED FROM SOS ===")

            // Show toast to user
            Toast.makeText(this, "Packages clicked - should go to PackageActivity", Toast.LENGTH_LONG).show()

            try {
                // Create intent
                val intent = Intent(this, PackageActivity::class.java)
                Log.d("DEBUG_NAV", "Intent created for: ${intent.component?.className}")

                // Start activity
                Log.d("DEBUG_NAV", "About to start PackageActivity...")
                startActivity(intent)
                Log.d("DEBUG_NAV", "startActivity called successfully")
                finish()

            } catch (e: Exception) {
                Log.e("DEBUG_NAV", "ERROR starting PackageActivity: ${e.message}")
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        navSOS.setOnClickListener {
            Log.d("DEBUG_NAV", "SOS clicked (already in SOS)")
        }
    }
}

