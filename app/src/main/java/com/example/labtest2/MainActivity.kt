package com.example.labtest2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button by its ID
        val startButton = findViewById<Button>(R.id.button)

        // Set click listener for the "Let's Start" button
        startButton.setOnClickListener {
            // Create intent to navigate to WelcomeActivity
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)

            // Optional: Add transition animation
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}