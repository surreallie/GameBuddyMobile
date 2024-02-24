package com.mita.gamebuddymobile

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class SavedMessages : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_messages)


        val UserChat1 : TextView = findViewById(R.id.User1)
        val UserChat2 : TextView = findViewById(R.id.User2)
        val UserChat3 : TextView = findViewById(R.id.User3)

        UserChat1.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        UserChat2.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        UserChat3.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }


        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_StartMatching -> {
                    showStartMatchingDialog()
                    true
                }
                R.id.nav_chats -> {
                    true
                }
                R.id.Users -> {
                    val intent = Intent(this, Users::class.java)
                    startActivity(intent)
                    true
                }
                R.id.Accsettings -> {
                    val intent = Intent(this, AccounSettings::class.java)
                    startActivity(intent)
                    true
                }
                R.id.LogOut -> {
                    val intent = Intent(this, LogInPage::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){

            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showStartMatchingDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.start_matching_dialog) // Moved this line up

        val btnStartMatching: Button = dialog.findViewById(R.id.confirmdialog)
        val btnCancel: Button = dialog.findViewById(R.id.canceldialog)

        // Set dialog properties
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setLayout(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT)
        dialog.window?.setGravity(Gravity.CENTER)

        // Show the dialog
        btnStartMatching.setOnClickListener {
            Toast.makeText(this, "Confirm", Toast.LENGTH_LONG).show() // You forgot to call show()
            dialog.dismiss()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}