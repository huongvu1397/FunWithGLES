package com.excalibur.funwithgles.opengl_slide_show.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    val listPath = MutableLiveData<List<String>>(arrayListOf())

}