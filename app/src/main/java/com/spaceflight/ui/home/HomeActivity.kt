package com.spaceflight.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.spaceflight.R
import com.spaceflight.databinding.ActivityHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), HomeListener {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        initViewModel()

    }

    private fun initViewModel() {
        binding.viemodel = viewModel
        viewModel.listener = this
        viewModel.getNews()

    }

    override fun apiSuccess() {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()
    }

    override fun apiError(message: String) {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}