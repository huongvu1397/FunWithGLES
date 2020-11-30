package com.excalibur.funwithgles.opengl_slide_show.glbase;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;

import java.io.IOException;

public class TextureVideoView extends TextureView implements TextureView.SurfaceTextureListener {

    private static final String f16003d = "TextureVideoView";

    public MediaPlayer f16004a;

    public boolean f16005b;

    public int f16006c;

    public float e;

    public float f;

    public boolean g;

    public boolean h;

    public boolean i;

    private b j;

    public a k;

    public interface a {
    }

    public enum b {
        CENTER_CROP,
        TOP,
        BOTTOM
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    public enum c {
        ;
        public static final int f16011a = 1;

        public static final int f16012b = 2;

        public static final int f16013c = 3;

        public static final int f16014d = 4;
        public static final int e = 5;

        private final int[] f;

        {
            this.f = new int[]{f16011a, f16012b, f16013c, f16014d, e};
        }
    }

    public TextureVideoView(Context context) {
        super(context);
        d();
    }

    public TextureVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        d();
    }

    public TextureVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        d();
    }

    public TextureVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        d();
    }

    private void d() {
        a();
        setScaleType(b.CENTER_CROP);
        setSurfaceTextureListener(this);
    }

    public void setScaleType(b bVar) {
        this.j = bVar;
    }

    public final void a() {
        if (this.f16004a == null) {
            this.f16004a = new MediaPlayer();
        } else {
            this.f16004a.reset();
        }
        this.h = false;
        this.i = false;
        this.f16006c = c.f16011a;
    }

    public void setDataSource(String str) {
        a();
        try {
            this.f16004a.setDataSource(str);
            this.f16005b = true;
            b();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        a();
        try {
            this.f16004a.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            this.f16005b = true;
            b();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        try {
            this.f16004a.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                    float unused = TextureVideoView.this.f = (float) i;
                    float unused2 = TextureVideoView.this.e = (float) i2;
                    TextureVideoView.a(TextureVideoView.this);
                }
            });
            this.f16004a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    int unused = TextureVideoView.this.f16006c = c.e;
                    TextureVideoView.a("Video has ended.");
                    if (TextureVideoView.this.k != null) {
                        a unused2 = TextureVideoView.this.k;
                    }
                }
            });
            this.f16004a.prepareAsync();
            this.f16004a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    boolean unused = TextureVideoView.this.h = true;
                    if (TextureVideoView.this.i && TextureVideoView.this.g) {
                        TextureVideoView.a("Player is prepared and play() was called.");
                        TextureVideoView.this.c();
                    }
                    if (TextureVideoView.this.k != null) {
                        a unused2 = TextureVideoView.this.k;
                    }
                }
            });
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
        }
    }

    public final void c() {
        if (!this.f16005b) {
            a("play() was called but data source was not set.");
            return;
        }
        this.i = true;
        if (!this.h) {
            a("play() was called but video is not prepared yet, waiting.");
        } else if (!this.g) {
            a("play() was called but view is not available yet, waiting.");
        } else if (this.f16006c == c.f16012b) {
            a("play() was called but video is already playing.");
        } else if (this.f16006c == c.f16014d) {
            a("play() was called but video is paused, resuming.");
            this.f16006c = c.f16012b;
            this.f16004a.start();
        } else if (this.f16006c == c.e || this.f16006c == c.f16013c) {
            a("play() was called but video already ended, starting over.");
            this.f16006c = c.f16012b;
            this.f16004a.seekTo(0);
            this.f16004a.start();
        } else {
            this.f16006c = c.f16012b;
            this.f16004a.start();
        }
    }

    public void setLooping(boolean z) {
        this.f16004a.setLooping(z);
    }

    public int getDuration() {
        return this.f16004a.getDuration();
    }

    public static void a(String str) {
        Log.d(f16003d, str);
    }

    public void setListener(a aVar) {
        this.k = aVar;
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.f16004a.setSurface(new Surface(surface));
        this.g = true;
        if (this.f16005b && this.i && this.h) {
            a("View is available and play() was called.");
            c();
        }
    }

    static void a(TextureVideoView textureVideoView) {
        float f2;
        int i2;
        float width = (float) textureVideoView.getWidth();
        float height = (float) textureVideoView.getHeight();
        Log.e("HVV1312"," textureVideoView f "+textureVideoView.f + " textureVideoView e "+ textureVideoView.e);
        Log.e("HVV1312"," width "+width + " height "+height);
        float f3 = width / height;
        float f4 = textureVideoView.f / textureVideoView.e;
        float f5 = 1.0f;
        if (f3 > f4) {
            f5 = f3 / f4;
            f2 = 1.0f;
        } else {
            f2 = f4 / f3;
        }
        int i3 = 0;
        switch (textureVideoView.j) {
            case TOP:
                i2 = 0;
                break;
            case BOTTOM:
                i3 = (int) width;
                i2 = (int) height;
                break;
            case CENTER_CROP:
                i3 = (int) (width / 2.0f);
                i2 = (int) (height / 2.0f);
                break;
            default:
                i3 = (int) (width / 2.0f);
                i2 = (int) (height / 2.0f);
                break;
        }
        Log.e("HVV1312",((Object) f2 + " " + f5));
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f5, (float) i3, (float) i2);
        textureVideoView.setTransform(matrix);
    }

}
