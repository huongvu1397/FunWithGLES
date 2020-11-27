package com.excalibur.funwithgles

import android.app.Application

class App : Application() {

    companion object {
        private lateinit var app: App
        @JvmStatic
        fun self() = app
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }


}