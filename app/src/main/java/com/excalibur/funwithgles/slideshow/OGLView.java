package com.excalibur.funwithgles.slideshow;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.LongDef;

import java.util.List;

public class OGLView extends GLSurfaceView {
    public static int INDEX_BITMAP_LOADED = 60;
    /* access modifiers changed from: private */
    public List<String> listImages;
    /* access modifiers changed from: private */
    public int numberImage = 2;
    /* access modifiers changed from: private */
    public OGLRenderer oglRenderer;
    /* access modifiers changed from: private */
    public RendererListener rendererListener;
    /* access modifiers changed from: private */
    public int seconds;
    private final boolean supportsEs2;

    public OGLView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.supportsEs2 = ((ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void setNumberImage(int i) {
        this.numberImage = i;
    }

    public void setSeconds(int i) {
        this.seconds = i;
    }

    public void setListImages(List<String> list) {
        this.listImages = list;
    }

    public void setRendererListener(RendererListener rendererListener2) {
        this.rendererListener = rendererListener2;
    }

    private OGLRenderer createOGLRenderer() {
        if (this.oglRenderer == null) {
            this.oglRenderer = new OGLRenderer(getContext(), this.rendererListener);
        }
        return this.oglRenderer;
    }

    public void init() {
        if (this.supportsEs2) {
            setEGLContextClientVersion(2);
            setPreserveEGLContextOnPause(true);
            setRenderer(createOGLRenderer());
        }
    }

    public void update() {
        INDEX_BITMAP_LOADED = 60;
        queueEvent(new Runnable() {
            public void run() {
                Log.e("HVV1312","numberImage "+numberImage);
                OGLView.this.oglRenderer.setNumberImage(OGLView.this.numberImage);
                OGLView.this.oglRenderer.setSeconds(OGLView.this.seconds);
                OGLView.this.oglRenderer.init();
                if (OGLView.this.numberImage < OGLView.INDEX_BITMAP_LOADED) {
                    OGLView.INDEX_BITMAP_LOADED = OGLView.this.numberImage;
                }
                int i = 0;
                for (int i2 = 0; i2 <= OGLView.INDEX_BITMAP_LOADED; i2++) {
                    if (i2 < OGLView.INDEX_BITMAP_LOADED) {
                        Bitmap loadBitmap = TextureUtils.loadBitmap(OGLView.this.listImages.get(i2));
                        if (loadBitmap != null) {
                            OGLView.this.oglRenderer.addBitmap(loadBitmap, ((float) loadBitmap.getWidth()) / ((float) loadBitmap.getHeight()));
                            OGLView.this.rendererListener.loadingImage(i2);
                            loadBitmap.recycle();
                        } else {
                            i++;
                            Log.e("HVV1312","numberImage "+(numberImage - i));
                            OGLView.this.oglRenderer.setNumberImage(OGLView.this.numberImage - i);
                            OGLView.this.oglRenderer.setSeconds(OGLView.this.seconds);
                            OGLView.this.oglRenderer.init();
                        }
                    }
                    if (i2 == OGLView.this.numberImage - 1) {
                        OGLView.this.rendererListener.loadedAllImage();
                        OGLView.this.oglRenderer.setCanStart(true);
                    }
                }
            }
        });
    }

    public void pause() {
        if (oglRenderer != null) {
            this.oglRenderer.pause();
            onPause();
        }
    }

    public void resume() {
        if (oglRenderer != null) {
            oglRenderer.resume();
            onResume();
        }
    }

    public void setEffectId(int i) {
        this.oglRenderer.setEffectId(i);
    }

    public void updateDuration(int i) {
        this.oglRenderer.updateDuration(i);
    }

    public void reset() {
        this.oglRenderer.reset();
    }
}