package com.mita.gamebuddymobile

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class SignUpPage : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var email : EditText
    private lateinit var password : TextInputEditText
    private lateinit var confirmpassword : TextInputEditText
    private lateinit var signupbutton : Button
    private lateinit var checkbox : CheckBox



    //    private lateinit var textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        confirmpassword = findViewById(R.id.confirmpassword)
        signupbutton = findViewById(R.id.signupbutton)
        checkbox = findViewById(R.id.checkBox)



        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showCustomDialogBox()
            }
        }
        val LogInRed : TextView = findViewById(R.id.AlreadyHaveAccLogIn)

        LogInRed.setOnClickListener {
            // Create intent to start home
            val intent = Intent(this, LogInPage::class.java)
            startActivity(intent)
        }

    }

    //custom Dialog Box
    private fun showCustomDialogBox(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_custom_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        val btnConfirm : Button = dialog.findViewById(R.id.confirmdialog)
        val btnCancel : Button = dialog.findViewById(R.id.canceldialog)

        btnConfirm.setOnClickListener {
            checkbox.isChecked = true
            Toast.makeText(this, "Confirm", Toast.LENGTH_LONG)
            dialog.dismiss()

        }

        btnCancel.setOnClickListener {
            checkbox.isChecked = false
            dialog.dismiss()
        }

        dialog.show()

        signupbutton.setOnClickListener {
            // Create intent to start home
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

    }




}