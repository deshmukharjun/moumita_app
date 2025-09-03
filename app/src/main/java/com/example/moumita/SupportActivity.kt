package com.example.moumita

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SupportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_support)

        val backBtn = findViewById<ImageView>(R.id.btnBack)
        val userMessageContainer = findViewById<LinearLayout>(R.id.userMessageContainer)
        val botMessage2Container = findViewById<LinearLayout>(R.id.botMessage2Container)
        val sendButton = findViewById<ImageButton>(R.id.sendButton)
        val messageEditText = findViewById<EditText>(R.id.messageEditText)

        // Back button logic
        backBtn.setOnClickListener {
            finish()
        }

        // Initially hide the user's and bot's second message
        userMessageContainer.visibility = View.GONE
        botMessage2Container.visibility = View.GONE

        // Set up the send button click listener
        sendButton.setOnClickListener {
            // Check if the user's message is already sent to prevent multiple sends
            if (userMessageContainer.visibility == View.GONE) {

                // Clear the message from the EditText
                messageEditText.text.clear()

                // Show the user's message
                userMessageContainer.visibility = View.VISIBLE

                // Create a handler for the delayed bot reply
                val handler = Handler(Looper.getMainLooper())

                // Delay the bot's reply by 1 second
                handler.postDelayed({
                    // Show the bot's message
                    botMessage2Container.visibility = View.VISIBLE
                    // Load the slide-in animation
                    val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in)
                    // Start the animation on the bot's message container
                    botMessage2Container.startAnimation(slideInAnimation)
                }, 500) // 1000ms delay
            }
        }
    }
}