package com.mita.gamebuddymobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LogInPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_page)

        val logInButton : Button = findViewById(R.id.LogInbutton)
        logInButton.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        val SignUpRed : TextView = findViewById(R.id.SignupRed)

        SignUpRed.setOnClickListener {
            // Create intent to start home
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
        }
    }
}