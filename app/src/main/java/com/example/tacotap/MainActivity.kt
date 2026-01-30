package com.example.tacotap

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main = findViewById<View>(R.id.main)
        main.setBackgroundColor(getColor(R.color.tacoBackground))

        val button = findViewById<ImageButton>(R.id.imageButton)
        val Button = findViewById<Button>(R.id.Button)
        val textView = findViewById<TextView>(R.id.textView)

        var tacoCount = 0.0
        var tacosPerClick = 1.0
        var upgradeCost = 100.0
        var upgradeMultiplier = 1.1

        button.setOnClickListener {
            tacoCount += tacosPerClick
            textView.text = String.format("%.0f", tacoCount)

            if (tacoCount >= upgradeCost) {
                Button.visibility = View.VISIBLE
            }
        }

        Button.setOnClickListener {
            if (tacoCount >= upgradeCost) {
                tacoCount -= upgradeCost
                tacosPerClick *= upgradeMultiplier
                upgradeCost *= 1.5
                upgradeMultiplier += 0.05
                textView.text = String.format("%,.0f", tacoCount)
                Button.text = "Upgrade (+${String.format("%.2f", tacosPerClick)} / click)\nCost: ${String.format("%,.0f", upgradeCost)}"
                Button.visibility = View.INVISIBLE
            }
        }
    }
}