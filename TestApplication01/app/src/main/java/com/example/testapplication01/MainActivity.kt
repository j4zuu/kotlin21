package com.example.testapplication01

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text1 = findViewById<TextView>(R.id.textView1)
        val button1 = findViewById<Button>(R.id.button1)
        val editText1 = findViewById<EditText>(R.id.personName)

        button1.setOnClickListener{
            when {
                editText1.text.isNotEmpty() -> {
                    text1.text = getString(R.string.name, editText1.text)
                    val intent = Intent(this, MainActivity2::class.java)
                    // startActivity(intent)


                    val snackBar = Snackbar.make(
                        it, "Button has been clicked",
                        Snackbar.LENGTH_LONG
                    ).setAction("Action", null)
                    snackBar.setActionTextColor(Color.BLUE)
                    val snackBarView = snackBar.view
                    snackBarView.setBackgroundColor(Color.CYAN)
                    val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                    textView.setTextColor(Color.BLUE)
                    snackBar.show()

                }
                text1.text == getString(R.string.name, editText1.text) -> {

                    text1.text = getString(R.string.goodbye)
                }
                else -> {
                    text1.text = getString(R.string.hello_world)

                }
            }
        }
    }
}