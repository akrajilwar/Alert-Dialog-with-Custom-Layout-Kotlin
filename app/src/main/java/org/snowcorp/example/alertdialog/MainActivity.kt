package org.snowcorp.example.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

/**
 * Created by Akshay Raj on 23/8/19 at 18:39.
 * akshay@snowcorp.org
 * www.snowcorp.org
 */

class MainActivity : AppCompatActivity() {
    private var btnSimpleDialog: MaterialButton? = null
    private var btnCustomDialog: MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSimpleDialog = findViewById(R.id.button_simple_dialog)
        btnCustomDialog = findViewById(R.id.button_custom_dialog)

        init()
    }

    private fun init() {
        btnSimpleDialog!!.setOnClickListener { launchAlertDialog() }

        btnCustomDialog!!.setOnClickListener { launchCustomDialog() }
    }

    private fun launchAlertDialog() {
        val builder = AlertDialog.Builder(this@MainActivity)
                .setTitle("Alert Dialog")
                .setMessage("Are you sure?")
                .setPositiveButton("Ok") { dialogInterface, i ->
                    dialogInterface.dismiss()
                    Toast.makeText(this@MainActivity, "Request submit.", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialogInterface, i -> dialogInterface.cancel() }
        builder.show()
    }

    private fun launchCustomDialog() {
        val customLayout = LayoutInflater.from(this@MainActivity).inflate(R.layout.custom_dialog, null)

        val editMessage: TextInputLayout = customLayout.findViewById(R.id.edit_message)

        val builder = AlertDialog.Builder(this@MainActivity)
                .setView(customLayout)
                .setPositiveButton("Submit") { dialogInterface, _ ->
                    val message = editMessage.editText!!.text.toString()

                    // Dismiss Dialog
                    dialogInterface.dismiss()

                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialogInterface, _ -> dialogInterface.cancel() }
        builder.show()
    }
}
