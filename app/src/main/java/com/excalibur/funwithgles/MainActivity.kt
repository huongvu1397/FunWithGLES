package com.excalibur.funwithgles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.excalibur.funwithgles.chp1.GettingStarted
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGettingStarted.setOnClickListener {
            startActivity(Intent(this, GettingStarted::class.java))
        }
    }
}