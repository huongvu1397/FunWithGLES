package com.excalibur.funwithgles.drawbitmap;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class SlideShowView extends GLSurfaceView {

    private final boolean supportsEs2;
    private SlideShowRender slideShowRender;

    public SlideShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.supportsEs2 = ((ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE)).getDeviceConfigurationInfo().reqGlEsVersion >= 0x20000;
    }

    private SlideShowRender createOGLRenderer() {
        if (slideShowRender == null) {
            slideShowRender = new SlideShowRender();
        }
        return slideShowRender;
    }

    public void init() {
        if (this.supportsEs2) {
            setEGLContextClientVersion(2);
            setPreserveEGLContextOnPause(true);
            setRenderer(createOGLRenderer());
        }
    }

    public void pause() {
        if (slideShowRender != null) {
            //slideShowRender.pause();
        }
        onPause();
    }

    public void resume() {
        if (slideShowRender != null) {
            //slideShowRender.resume();
        }
        onResume();
    }

}
