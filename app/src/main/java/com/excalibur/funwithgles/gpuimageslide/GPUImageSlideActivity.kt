package com.excalibur.funwithgles.gpuimageslide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.excalibur.funwithgles.R
import jp.co.cyberagent.android.gpuimage.GPUImage
import kotlinx.android.synthetic.main.activity_g_p_u_image_slide.*
import java.io.File

class GPUImageSlideActivity : AppCompatActivity() {

    private var mGPUImage:GPUImage ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_g_p_u_image_slide)
        init()
    }

    private fun init(){
        mGPUImage = GPUImage(this)
        mGPUImage?.setGLSurfaceView(glView)
        mGPUImage?.setScaleType(GPUImage.ScaleType.CENTER_INSIDE)
        mGPUImage?.setImage(File("/storage/self/primary/DCIM/Camera/IMG_20200608_202443.jpg"))
    }
}