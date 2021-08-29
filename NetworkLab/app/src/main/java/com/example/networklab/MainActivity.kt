package com.example.networklab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class Data {
            private var data1 = ""
            fun getData(function: (data3: String) -> Unit) {
                val myUrl = URL("https://users.metropolia.fi/~jarkkov/koe.txt")
                val myConn = myUrl.openConnection()
                val iStream = myConn.getInputStream()
                val allText = iStream.bufferedReader().use { it.readText() }
                val result = StringBuilder()
                result.append(allText)
                val str = result.toString()
                data1 = str
                Log.d("te", data1)
                function
            }
        }
        val summon = Data ()
        thread() {
            summon.getData {

            }
        }
    }

    fun antoherfun (data: Boolean) {

    }
}