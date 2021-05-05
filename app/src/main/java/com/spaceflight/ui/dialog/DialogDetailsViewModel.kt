package com.spaceflight.ui.dialog

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spaceflight.network.response.NewsResponse
import com.spaceflight.repository.NewsRepository

class DialogDetailsViewModel(private val repository: NewsRepository) : ViewModel() {

    var listener: DialogListener? = null

    private val _newsList = MutableLiveData<NewsResponse>()
    val newList: LiveData<NewsResponse>
        get() = _newsList

    fun initViewModel() {
        _newsList.postValue(repository.getClick())
    }

    fun onClose(view: View) {
        onClose()
    }

    fun onClose() {
        listener!!.onClose()
    }
}
