package com.wahidabd.latihanbajp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahidabd.latihanbajp.databinding.ActivityMainBinding
import com.wahidabd.latihanbajp.proyek.ui.home.HomeActivity
import com.wahidabd.latihanbajp.testing.TestingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.instrumentationTesting.setOnClickListener {
            startActivity(Intent(this, TestingActivity::class.java))
        }

        binding.proyek.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}