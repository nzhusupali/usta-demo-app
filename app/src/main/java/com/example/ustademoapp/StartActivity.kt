package com.example.ustademoapp

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ustademoapp.databinding.ActivityStartBinding
import java.util.*

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private lateinit var locale: Locale

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()


        with(binding) {
            btnKazActivityStart.setOnClickListener {
                setLocale("kk")
                startActivity(Intent(applicationContext, OnBoardActivity::class.java))
            }
            btnRuActivityStart.setOnClickListener {
                setLocale("ru")
                startActivity(
                    Intent(
                        applicationContext,
                        OnBoardActivity::class.java
                    )
                )
            }
        }
    }

    private fun setLocale(languageName: String) {
        locale = Locale(languageName)

        val resources = resources
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

    }
}