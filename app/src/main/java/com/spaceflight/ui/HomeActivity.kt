package com.spaceflight.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.spaceflight.R
import com.spaceflight.databinding.ActivityHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    private fun initViewModel
}