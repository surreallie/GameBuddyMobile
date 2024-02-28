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
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.tabs.TabLayout
import com.mita.gamebuddymobile.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var adapter: PageAdapter
    private lateinit var startmatching:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val startmatching: Button = findViewById(R.id.btn_StartMatching)

        startmatching.setOnClickListener {

            Toast.makeText(this, "Confirm", Toast.LENGTH_LONG)
            showStartMatchingDialog()
            true

        }


        adapter = PageAdapter(supportFragmentManager, lifecycle)
        binding.ViewPager2.adapter = adapter
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.ViewPager2.currentItem = tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        binding.ViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })




        val drawerLayout :DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
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


