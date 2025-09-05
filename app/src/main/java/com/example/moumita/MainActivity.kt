package com.example.moumita

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Find the TextView for the animation
        val balanceTextView = findViewById<TextView>(R.id.animated_balance_text)

        // Animate the balance from 0 to 42069
        val finalValue = 41900
        val animator = ValueAnimator.ofInt(0, finalValue)
        animator.duration = 2000 // 2-second animation

        animator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Int
            balanceTextView.text = "$${animatedValue}"
        }

        animator.start()

        // Set Home as default selected
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Already in Home, do nothing
                    true
                }
                R.id.nav_feeds -> {
                    startActivity(Intent(this, FeedsActivity::class.java))
                    overridePendingTransition(0, 0) // remove animation
                    true
                }
                else -> false
            }
        }
    }
}