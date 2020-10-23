package com.excalibur.funwithgles.slideshow

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.excalibur.funwithgles.R


class SlideActivity : AppCompatActivity() {

    private var oglView : OGLView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)
        oglView = findViewById(R.id.ogl_view)
    }

    override fun onResume() {
        super.onResume()
        oglView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        oglView?.onPause()
    }

    fun isStoragePermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT < 23) {
            true
        } else if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED) {
            true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf("android.permission.WRITE_EXTERNAL_STORAGE"),
                1
            )
            false
        }
    }


}