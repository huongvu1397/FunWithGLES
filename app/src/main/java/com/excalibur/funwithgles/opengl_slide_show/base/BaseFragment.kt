package com.excalibur.funwithgles.opengl_slide_show.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.excalibur.funwithgles.App
import com.excalibur.funwithgles.opengl_slide_show.viewmodels.ActivityViewModel

abstract class BaseFragment : Fragment() {

    val mainViewModel by activityViewModels<ActivityViewModel> {
        ViewModelProvider.AndroidViewModelFactory.getInstance(App.self())
    }

}