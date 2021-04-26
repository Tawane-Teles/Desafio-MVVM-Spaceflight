package com.spaceflight

import android.app.Application
import android.content.Context

class DesafioAplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instace = applicationContext
    }

    companion object {
        lateinit var instace: Context
    }
}