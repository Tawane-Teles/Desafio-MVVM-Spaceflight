package com.spaceflight.ui

import androidx.lifecycle.ViewModel
import com.spaceflight.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(val repository: NewsRepository) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    fun getNews(){
        launch {
            try {
                val response = repository.getNews(15, 1)
                if (response.isSuccessful)

            }catch (e: Exception){

            }
        }
    }


}