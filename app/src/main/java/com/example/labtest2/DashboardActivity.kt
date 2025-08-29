package com.example.labtest2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.view.View
import android.view.ViewGroup

class DashboardActivity : AppCompatActivity() {

    // UI Components
    private lateinit var btnSearch: LinearLayout
    private lateinit var btnSettings: ImageButton
    private lateinit var etCurrentLocation: EditText
    private lateinit var etDestination: EditText

    // Card Views
    private lateinit var cardNearbyBuses: CardView
    private lateinit var cardMyProfile: CardView
    private lateinit var cardNotifications: CardView
    private lateinit var cardSOS: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initializeViews()
        setupClickListeners()
    }

    private fun initializeViews() {
        // Initialize main components
        btnSearch = findViewById(R.id.btnSearch)
        btnSettings = findViewById(R.id.btnSettings)
        etCurrentLocation = findViewById(R.id.etCurrentLocation)
        etDestination = findViewById(R.id.etDestination)

        // Find all CardViews in the layout
        val allCards = mutableListOf<CardView>()
        findCardViews(findViewById(android.R.id.content), allCards)

        // Assign cards based on their order
        if (allCards.size >= 5) {
            cardNearbyBuses = allCards[1]
            cardMyProfile = allCards[2]
            cardNotifications = allCards[3]
            cardSOS = allCards[4]
        } else {
            // Fallback to prevent crashes
            val dummyCard = CardView(this)
            cardNearbyBuses = dummyCard
            cardMyProfile = dummyCard
            cardNotifications = dummyCard
            cardSOS = dummyCard
        }
    }

    private fun findCardViews(view: View, cardViews: MutableList<CardView>) {
        if (view is CardView) {
            cardViews.add(view)
        } else if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                findCardViews(view.getChildAt(i), cardViews)
            }
        }
    }

    private fun setupClickListeners() {
        // Search button - navigate to bus route
        btnSearch.setOnClickListener {
            navigateToBusRoute()
        }

        // Nearby Buses card
        cardNearbyBuses.setOnClickListener {
            navigateToBusRoute()
        }

        // My Profile card
        cardMyProfile.setOnClickListener {
            navigateToProfile()
        }

        // Notifications card
        cardNotifications.setOnClickListener {
            navigateToNotifications()
        }

        // SOS card
        cardSOS.setOnClickListener {
            navigateToSOS()
        }


    }

    private fun navigateToBusRoute() {
        val intent = Intent(this, BusRouteActivity::class.java)

        // Pass location data if needed
        val currentLocation = etCurrentLocation.text.toString()
        val destination = etDestination.text.toString()

        intent.putExtra("CURRENT_LOCATION", currentLocation)
        intent.putExtra("DESTINATION", destination)

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

    private fun navigateToSOS() {
        val intent = Intent(this, SOSActivity::class.java)
        startActivity(intent)
    }


}