package com.example.moumita

import android.annotation.SuppressLint
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
        val followButton1 = findViewById<TextView>(R.id.followbtn1)
        val followButton2 = findViewById<TextView>(R.id.followbtn2)

        // Set the click listeners for each button correctly
        setupFollowButton(followButton)
        setupFollowButton(followButton1)
        setupFollowButton(followButton2)
    }

    @SuppressLint("SetTextI18n")
    private fun setupFollowButton(button: TextView) {
        button.setOnClickListener {
            if (button.text == "Follow") {
                // Change to "Following" state
                button.text = "Following"
                button.setBackgroundResource(R.drawable.gray_bg)
                button.setTextColor(ContextCompat.getColor(this, android.R.color.black))
            } else {
                // Change back to "Follow" state
                button.text = "Follow"
                button.setBackgroundResource(R.drawable.follow_bg)
                button.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            }
        }
    }
}