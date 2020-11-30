package com.excalibur.funwithgles.opengl_slide_show.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.opengl_slide_show.adapter.InfoPathAdapter
import com.excalibur.funwithgles.opengl_slide_show.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_edit.*

class EditFragment : BaseFragment() {

    private lateinit var infoPathAdapter : InfoPathAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLinkAdapter()
    }

    private fun initLinkAdapter(){
        infoPathAdapter = InfoPathAdapter()
        rcvList.adapter = infoPathAdapter
        infoPathAdapter.submitList(mainViewModel.listPath.value)
    }

}