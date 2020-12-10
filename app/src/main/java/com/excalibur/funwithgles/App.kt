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

    fun a(vararg strArr: String?): String? {
        val sb = StringBuilder()
        for (i2 in strArr.indices) {
            sb.append(strArr[i2])
            if (i2 < strArr.size - 1) {
                sb.append(":")
            }
        }
        return sb.toString()
    }


}