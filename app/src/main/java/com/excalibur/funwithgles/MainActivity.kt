package com.excalibur.funwithgles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.excalibur.funwithgles.chp1.GettingStarted
import com.excalibur.funwithgles.drawbitmap.SlideShowActivity
import com.excalibur.funwithgles.drawtriangle.DrawTriangleActivity
import com.excalibur.funwithgles.gpuimageslide.GPUImageSlideActivity
import com.excalibur.funwithgles.opengl_slide_show.HomeSlideActivity
import com.excalibur.funwithgles.opgl1_init.InitOpenGLActivity
import com.excalibur.funwithgles.slideshow.edit.EditActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGettingStarted.setOnClickListener {
            startActivity(Intent(this, GettingStarted::class.java))
        }
        btnGLESInit.setOnClickListener {
            startActivity(Intent(this, InitOpenGLActivity::class.java))
        }
        btnSlideShow.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
        btnSlideShow2.setOnClickListener {
            startActivity(Intent(this, SlideShowActivity::class.java))
        }
        btnSlideShow3.setOnClickListener {
            startActivity(Intent(this, GPUImageSlideActivity::class.java))
        }
        btnDrawTriangle.setOnClickListener {
            startActivity(Intent(this,DrawTriangleActivity::class.java))
        }
        btnSlide3.setOnClickListener {
            startActivity(Intent(this,HomeSlideActivity::class.java))
        }
    }
}