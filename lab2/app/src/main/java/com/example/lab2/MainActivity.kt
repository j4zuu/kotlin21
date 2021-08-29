package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), Fragment1.Fragment1Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Fragment1>(R.id.fragmentContainerView)
        }
    }

    override fun onButtonClick(position: Int) {
        Log.d("USR", "MainActivity received $position")
    }

}