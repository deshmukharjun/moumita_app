package com.example.moumita

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class FeedsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feeds)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_feeds

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    overridePendingTransition(0,0)
                    true
                }
                R.id.nav_feeds -> true // already here
                else -> false
            }
        }

        val supportBtn = findViewById<ImageView>(R.id.support_button)
        supportBtn.setOnClickListener {
            val intent = Intent(this, SupportActivity::class.java)
            startActivity(intent)
        }

        // Find the Follow button by its ID
        val followButton = findViewById<TextView>(R.id.followbtn)

        // Set the click listener for the button
        followButton.setOnClickListener {
            // Check the current text of the button
            if (followButton.text == "Follow") {
                // Change to "Following" state
                followButton.text = "Following"
                followButton.setBackgroundResource(R.drawable.gray_bg)
                followButton.setTextColor(ContextCompat.getColor(this, android.R.color.black))
            } else {
                // Change back to "Follow" state
                followButton.text = "Follow"
                followButton.setBackgroundResource(R.drawable.follow_bg)
                followButton.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            }
        }
    }
}