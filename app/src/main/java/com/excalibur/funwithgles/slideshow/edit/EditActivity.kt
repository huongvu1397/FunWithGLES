package com.excalibur.funwithgles.slideshow.edit

import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.util.Log
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.slideshow.OGLView
import com.excalibur.funwithgles.slideshow.RendererListener


class EditActivity : AppCompatActivity(), RendererListener {
    private var audioPath = ""
    var durationFrame = 2

    var images: ArrayList<Image> = ArrayList()

    var oglView: OGLView? = null
    var numberImage = 0
    private val listImagePath: ArrayList<String> = ArrayList()

    var layoutPreview: RelativeLayout? = null
    var layoutContainOGLView: RelativeLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        images.add(Image("Name1","/storage/self/primary/DCIM/Camera/20201023_151950.jpg"))
        images.add(Image("Name2","/storage/self/primary/DCIM/Camera/20201023_151952.jpg"))
        images.add(Image("Name3","/storage/self/primary/DCIM/Camera/20201023_151954.jpg"))
        images.add(Image("Name4","/storage/self/primary/DCIM/Camera/20201023_151956.jpg"))
        images.add(Image("Name5","/storage/self/primary/DCIM/Camera/20201023_151949.jpg"))
        images.add(Image("Name6","/storage/self/primary/DCIM/Camera/20201023_151947.jpg"))
        images.add(Image("Name7","/storage/self/primary/DCIM/Camera/20201023_151946.jpg"))
        images.add(Image("Name8","/storage/self/primary/DCIM/Camera/20201023_151944.jpg"))
        images.add(Image("Name9","/storage/self/primary/DCIM/Camera/20201023_151950.jpg"))
        images.add(Image("Name10","/storage/self/primary/DCIM/Camera/20201023_151950.jpg"))
        numberImage = images.size
        attachView()
        initPreview()
    }

    override fun previewComplete() {
        runOnUiThread { this@EditActivity.resetPreviewAndMusic() }
    }

    override fun updateSeekBarTime(i: Int) {
        Log.e("HVV1312","updateSeekBarTime : $i")
    }

    override fun loadingImage(i: Int) {
        Log.e("HVV1312","loadingImage : $i")
    }

    override fun dismissDialog() {
        Log.e("HVV1312","dismissDialog")
    }

    override fun loadedAllImage() {
        Log.e("HVV1312","loadedAllImage")
    }

    override fun onPause() {
        super.onPause()
        oglView?.pause()
    }

    override fun onResume() {
        super.onResume()
        oglView?.resume()
    }

    private fun initPreview() {
        oglView = findViewById(R.id.ogl_view)
        val i: Int = this.numberImage * durationFrame
        var i2 = 0
        while (true) {
            if (i2 < numberImage) {
                images?.get(i2)?.let { this.listImagePath.add(it.path) }
                i2++
            } else {
                oglView?.setNumberImage(numberImage)
                oglView?.setSeconds(i)
                oglView?.setListImages(this.listImagePath)
                oglView?.setRendererListener(this)
                oglView?.init()
                //this.timeBar.setMax(i)
                //this.txtMaxTime.setText(ViewUtil.convertTime(i.toLong()))
                //this.processDialog.show()
                Handler().postDelayed({ oglView?.update() }, 150)
                return
            }
        }
    }

    private fun resetPreviewAndMusic() {
        oglView?.onPause()
        oglView?.reset()
        oglView?.onResume()
    }

    private fun customSizeOglView() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val i = displayMetrics.heightPixels * 2 / 5
        val layoutParams = RelativeLayout.LayoutParams(i, i)
        val layoutParams2 = RelativeLayout.LayoutParams(-1, -1)
        layoutParams.addRule(13,-1)
        this.layoutPreview?.layoutParams = layoutParams
        oglView?.layoutParams = layoutParams2
        this.layoutContainOGLView?.layoutParams = layoutParams2
    }

    private fun attachView(){
        layoutPreview = findViewById(R.id.layout_preview)
        layoutContainOGLView = findViewById(R.id.relative)
        oglView = findViewById(R.id.ogl_view)
        customSizeOglView()
    }

}