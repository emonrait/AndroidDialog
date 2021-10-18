package com.example.androiddialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    //private var activityMainBinding: ActivityMainBinding? = null
    private lateinit var btnShowDefaultDialog: Button
    private lateinit var btnShowCustomDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        btnShowDefaultDialog = findViewById(R.id.btnShowDefaultDialog)
        btnShowCustomDialog = findViewById(R.id.btnShowCustomDialog)

        btnShowDefaultDialog?.setOnClickListener {
            showDefaultDialog()
        }

        btnShowCustomDialog?.setOnClickListener {
            showCustomDialog()
        }


    }

    private fun toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


    private fun showDefaultDialog() {
        val alertDialog = AlertDialog.Builder(this)

        alertDialog.apply {
            setIcon(R.drawable.ic_hello)
            setTitle("Hello")
            setMessage("I just wanted to greet you. I hope you are doing great!")
            setPositiveButton("Positive") { _, _ ->
                toast("clicked positive button")
            }
            setNegativeButton("Negative") { _, _ ->
                toast("clicked negative button")
            }
            setNeutralButton("Neutral") { _, _ ->
                toast("clicked neutral button")
            }
        }.create().show()
    }

    private fun showCustomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.lay_custom_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnOk = dialog.findViewById<Button>(R.id.btnOk)
        btnOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()


    }


}