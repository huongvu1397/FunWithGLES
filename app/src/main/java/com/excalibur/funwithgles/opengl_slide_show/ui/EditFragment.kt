package com.excalibur.funwithgles.opengl_slide_show.ui

import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Surface
import android.view.TextureView.SurfaceTextureListener
import android.view.View
import android.view.ViewGroup
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.opengl_slide_show.adapter.InfoPathAdapter
import com.excalibur.funwithgles.opengl_slide_show.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_edit.*


class EditFragment : BaseFragment() {

    private lateinit var infoPathAdapter : InfoPathAdapter
    private var l : Surface ? = null


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
        initTextureView()
        //updateSizeTexture()

    }

    private fun initLinkAdapter(){
        infoPathAdapter = InfoPathAdapter()
        rcvList.adapter = infoPathAdapter
        infoPathAdapter.submitList(mainViewModel.listPath.value)
    }

    //https://stackoverflow.com/questions/29009210/texture-view-video-and-bitmap-display
    private fun initTextureView(){
        surfaceView.surfaceTextureListener = surfaceTextureListener
    }

    private fun updateSizeTexture(){
        surfaceView.layoutParams.width = 720
        surfaceView.layoutParams.height = 720
    }

    private fun showImage(){

    }

    private val surfaceTextureListener = object : SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(surfaceTexture: SurfaceTexture?, width: Int, height: Int) {
            l = Surface(surfaceTexture)
            val bm = BitmapFactory.decodeFile(mainViewModel.listPath.value!![0])
            val canvas = l?.lockCanvas(Rect(0,0,width,height))
            canvas?.drawBitmap(bm,(width/2)-(bm.width /2).toFloat(), (height/2)-(bm.height /2).toFloat(), null )
            l?.unlockCanvasAndPost(canvas)
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureAvailable $width - $height")
        }

        override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture?, p1: Int, p2: Int) {
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureSizeChanged $p1 - $p2")
        }

        override fun onSurfaceTextureDestroyed(p0: SurfaceTexture?): Boolean {
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureDestroyed")
            return false
        }

        override fun onSurfaceTextureUpdated(p0: SurfaceTexture?) {
            Log.e("HVV1312", "surfaceTextureListener onSurfaceTextureUpdated")
        }

    }

}