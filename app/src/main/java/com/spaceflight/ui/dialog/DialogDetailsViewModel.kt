package com.spaceflight.ui.dialog

import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.spaceflight.repository.NewsRepository

class DialogDetailsViewModel(private val repository: NewsRepository): ViewModel() {
    fun getClick(){
        repository.getClick()
    }
}