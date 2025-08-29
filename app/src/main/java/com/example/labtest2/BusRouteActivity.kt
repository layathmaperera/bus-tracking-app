package com.example.labtest2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class BusRouteActivity : AppCompatActivity() {

    // UI Components
    private lateinit var btnSettings: ImageButton
    private lateinit var trackButtons: MutableList<Button>

    // Bottom Navigation
    private lateinit var navHome: LinearLayout
    private lateinit var navProfile: LinearLayout
    private lateinit var navNotifications: LinearLayout
    private lateinit var navPackages: LinearLayout
    private lateinit var navSOS: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_route)

        // Initialize UI components
        initializeViews()

        // Set up click listeners
        setupClickListeners()

        // Handle intent data from previous activity
        handleIntentData()
    }

    private fun initializeViews() {
        // Initialize settings button
        btnSettings = findViewById(R.id.btnSettings)

        // Find all Track Bus buttons
        trackButtons = mutableListOf()
        findTrackButtons(findViewById(android.R.id.content), trackButtons)

        // Bottom Navigation
        navHome = findViewById(R.id.navHome)
        navProfile = findViewById(R.id.navProfile)
        navNotifications = findViewById(R.id.navNotifications)
        navPackages = findViewById(R.id.navPackages)
        navSOS = findViewById(R.id.navSOS)
    }

    // Helper method to find all Track Bus buttons recursively
    private fun findTrackButtons(view: android.view.View, buttons: MutableList<Button>) {
        if (view is Button && view.text.toString().equals("Track Bus", ignoreCase = true)) {
            buttons.add(view)
        } else if (view is android.view.ViewGroup) {
            for (i in 0 until view.childCount) {
                findTrackButtons(view.getChildAt(i), buttons)
            }
        }
    }

    private fun setupClickListeners() {
        // Settings button click listener
        btnSettings.setOnClickListener {
            // Navigate to settings activity if you have one
            // val intent = Intent(this, SettingsActivity::class.java)
            // startActivity(intent)
        }

        // Set click listeners for all Track Bus buttons
        trackButtons.forEach { button ->
            button.setOnClickListener {
                navigateToBusTracking(button)
            }
        }

        // Bottom Navigation click listeners
        navHome.setOnClickListener {
            navigateToHome()
        }

        navProfile.setOnClickListener {
            navigateToProfile()
        }

        navNotifications.setOnClickListener {
            navigateToNotifications()
        }

        navPackages.setOnClickListener {
            navigateToPackages()
        }

        navSOS.setOnClickListener {
            navigateToSOS()
        }
    }

    private fun handleIntentData() {
        // Handle data passed from DashboardActivity
        val currentLocation = intent.getStringExtra("CURRENT_LOCATION")
        val destination = intent.getStringExtra("DESTINATION")

        // You can use this data to filter or highlight relevant bus routes
        // For example, show only routes that match the search criteria
        if (!currentLocation.isNullOrEmpty() || !destination.isNullOrEmpty()) {
            // Process the search data here
            // Maybe filter the displayed routes or highlight matching ones
        }
    }

    // Navigation methods
    private fun navigateToBusTracking(clickedButton: Button) {
        val intent = Intent(this, BusTrackingActivity::class.java)

        // Find which route was selected by getting the parent card's information
        val routeInfo = getRouteInfoFromButton(clickedButton)
        intent.putExtra("ROUTE_NAME", routeInfo.first)
        intent.putExtra("ROUTE_DESCRIPTION", routeInfo.second)

        startActivity(intent)
    }

    private fun navigateToHome() {
        val intent = Intent(this, DashboardActivity::class.java)
        // Clear the activity stack to prevent building up a large back stack
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
    }

    private fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToNotifications() {
        val intent = Intent(this, NotificationActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToPackages() {
        val intent = Intent(this, PackageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSOS() {
        val intent = Intent(this, SOSActivity::class.java)
        startActivity(intent)
    }

    // Helper method to extract route information from the clicked button's parent card
    private fun getRouteInfoFromButton(button: Button): Pair<String, String> {
        var parent = button.parent

        // Navigate up the view hierarchy to find the card's LinearLayout
        while (parent != null && parent !is androidx.cardview.widget.CardView) {
            parent = parent.parent
        }

        if (parent is androidx.cardview.widget.CardView) {
            // Find the TextViews containing route information
            val cardLayout = parent.getChildAt(0) as? android.view.ViewGroup
            cardLayout?.let { layout ->
                val headerLayout = layout.getChildAt(0) as? android.view.ViewGroup
                headerLayout?.let { header ->
                    val infoLayout = header.getChildAt(1) as? android.view.ViewGroup
                    infoLayout?.let { info ->
                        val routeNameView = info.getChildAt(0) as? android.widget.TextView
                        val routeDescView = info.getChildAt(1) as? android.widget.TextView

                        val routeName = routeNameView?.text?.toString() ?: "Unknown Route"
                        val routeDesc = routeDescView?.text?.toString() ?: "Unknown Description"

                        return Pair(routeName, routeDesc)
                    }
                }
            }
        }

        // Fallback if we can't extract the information
        return Pair("Bus Route", "Route Information")
    }


    override fun onResume() {
        super.onResume()
        // Refresh route data if needed when returning to this activity
    }
}