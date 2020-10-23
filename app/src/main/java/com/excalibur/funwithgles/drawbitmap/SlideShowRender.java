package com.excalibur.funwithgles.drawbitmap;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SlideShowRender implements GLSurfaceView.Renderer {

    private Bitmap bmp;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {


    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.e("HVV1312","SlideShowRender : "+width + " and "+ height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }
}
