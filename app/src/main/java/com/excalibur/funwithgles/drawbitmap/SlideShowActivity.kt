package com.excalibur.funwithgles.drawbitmap

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.excalibur.funwithgles.R
import kotlinx.android.synthetic.main.activity_slide_show.*


class SlideShowActivity : AppCompatActivity() {
    private var mMediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_show)
        ssView?.init()
    }

    override fun onResume() {
        super.onResume()
        ssView?.resume()
    }

    override fun onPause() {
        super.onPause()
        ssView?.pause()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if(mMediaPlayer!=null){
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer= null
        }
    }
}