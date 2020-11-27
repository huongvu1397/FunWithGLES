package com.excalibur.funwithgles.opengl_slide_show.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.excalibur.funwithgles.App
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.models.MyMedia
import com.excalibur.funwithgles.opengl_slide_show.adapter.SelectAdapter
import com.excalibur.funwithgles.opengl_slide_show.base.BaseFragment
import com.excalibur.funwithgles.opengl_slide_show.viewmodels.ActivityViewModel
import com.excalibur.funwithgles.utils.MediaUtils
import com.excalibur.funwithgles.utils.PermissionUtils
import kotlinx.android.synthetic.main.fragment_select.*
import java.util.*
import kotlin.collections.ArrayList

class SelectFragment : BaseFragment() {

    private var mediaList = arrayListOf<MyMedia>()

    private lateinit var selectAdapter : SelectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectAdapter = SelectAdapter()
        if(PermissionUtils.checkPermission(PermissionUtils.WRITE_PERMISSIONS)){
            mediaList = (MediaUtils.getMediaItem().shuffled() as ArrayList<MyMedia>)
            selectAdapter.submitList(mediaList)
        }
        rcvSelect.adapter = selectAdapter
        btnNext.setOnClickListener {
            mainViewModel.listPath.value = selectAdapter.listSelect.values.toList()
            findNavController().navigate(R.id.action_selectFragment_to_editFragment)
        }
        btnBack.setOnClickListener {
            activity?.finish()
        }
    }


}