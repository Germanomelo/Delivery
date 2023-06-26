package com.gmsp.delivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmsp.delivery.R
import com.gmsp.delivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}