package com.spaceflight.ui.dialog

import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.spaceflight.repository.NewsRepository

class DialogDetailsViewModel(private val repository: NewsRepository): ViewModel() {
    var listener : DialogListener? = null
    fun getClick(){
        repository.getClick()
    }

    fun onClose(view:    View){
        listener!!.onClose()

    }
}