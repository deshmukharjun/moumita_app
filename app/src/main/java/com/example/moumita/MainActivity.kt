package com.example.moumita

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val balanceTextView = findViewById<TextView>(R.id.animated_balance_text)

        // Find the CardViews and set click listeners
        val monthlyBudgetCard = findViewById<CardView>(R.id.monthly_budget_card)
        monthlyBudgetCard.setOnClickListener {
            showMonthlyBudgetModal()
        }
        val cashCard = findViewById<CardView>(R.id.cash_card)
        cashCard.setOnClickListener {
            showCashCardModal()
        }
        val creditCard = findViewById<CardView>(R.id.credit_card)
        creditCard.setOnClickListener {
            showCreditCardModal()
        }
        val investmentsCard = findViewById<CardView>(R.id.investments_card)
        investmentsCard.setOnClickListener {
            showInvestmentModal()
        }

        val finalValue = 41900
        val animator = ValueAnimator.ofInt(0, finalValue)
        animator.duration = 2000

        animator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Int
            balanceTextView.text = "$${animatedValue}"
        }

        animator.start()

        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_feeds -> {
                    startActivity(Intent(this, FeedsActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }

    private fun showMonthlyBudgetModal() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.modal_monthly_budget)

        val closeButton = dialog.findViewById<ImageView>(R.id.close_button)
        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun showCashCardModal() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.modal_cash_card)
        val closeButton = dialog.findViewById<ImageView>(R.id.close_button)
        closeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun showCreditCardModal() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.modal_credit_card)
        val closeButton = dialog.findViewById<ImageView>(R.id.close_button)
        closeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun showInvestmentModal() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.modal_investment_card)
        val closeButton = dialog.findViewById<ImageView>(R.id.close_button)
        closeButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }
}