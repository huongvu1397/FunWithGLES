package com.excalibur.funwithgles.slideshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.renderscript.Matrix4f;

import com.excalibur.funwithgles.R;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OGLRenderer implements GLSurfaceView.Renderer {
    private static long ML_SECOND_NEXT_EFFECT = 500;
    private Context context;
    private int currentItem;
    private int effectId;
    private String fragmentShader;
    private boolean isCanStart;
    private boolean isStartDraw;
    private boolean isVideoStarted;
    private int numberImage= 2;
    private int positionImagePause;
    private RendererListener rendererListener;
    private int seconds;
    private int secondsDisplay;
    private float subtract;
    private ArrayList<Texture> textureArrayList = new ArrayList<>();
    private long timeDurationToMilliseconds;
    private long timeLine;
    private long timeRunned;
    private long timeStart;
    private long totalTimeToMilliseconds;
    private String vertexShader;

    OGLRenderer(Context context2, RendererListener rendererListener2) {
        this.context = context2;
        this.rendererListener = rendererListener2;
        this.positionImagePause = 0;
        this.timeRunned = 0;
        this.secondsDisplay = 0;
    }

    /* access modifiers changed from: package-private */
    public void addBitmap(Bitmap bitmap, float f) {
        if (this.vertexShader == null) {
            this.vertexShader = "uniform highp mat4 transition_matrix;\n\nattribute vec4 color;\nattribute vec4 position;\nattribute vec2 texture_coordinate;\n\nvarying lowp vec4 frag_color;\nvarying lowp vec2 frag_coordinate;\n\nvoid main(void) {\n    frag_color = color;\n    frag_coordinate = texture_coordinate;\n    gl_Position = transition_matrix * position;\n}\n";
        }
        if (this.fragmentShader == null) {
            this.fragmentShader = "precision mediump float;\n\nuniform sampler2D texture;\nvarying lowp vec2 frag_coordinate;\nvarying lowp vec4 frag_color;\n\nvoid main() {\n//    gl_FragColor = frag_color;\n//    gl_FragColor = frag_color * texture2D(texture, frag_coordinate);\n    gl_FragColor = texture2D(texture, frag_coordinate);\n}\n";
        }
        Texture texture = new Texture(new ShaderProgram(this.vertexShader, this.fragmentShader), f);
        texture.setTotalTranslate(TransitionUtil.getTotalTranslate());
        texture.setBitmap(bitmap);
        texture.setEffectId(0);
        this.textureArrayList.add(texture);
    }

    public void setCanStart(boolean z) {
        this.isCanStart = z;
    }

    /* access modifiers changed from: package-private */
    public void setEffectId(int i) {
        this.effectId = i;
        reset();
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.isVideoStarted = false;
        this.timeRunned = 0;
        this.secondsDisplay = 0;
        this.positionImagePause = 0;
        this.isStartDraw = false;
        for (int i = 0; i < this.numberImage; i++) {
            Texture texture = this.textureArrayList.get(i);
            texture.setMatrix4f(new Matrix4f());
            texture.setTotalTranslate(TransitionUtil.getTotalTranslate());
        }
    }

    /* access modifiers changed from: package-private */
    public void setSeconds(int i) {
        this.seconds = i;
        this.totalTimeToMilliseconds = (long) ((i * 1000) + 200);
    }

    /* access modifiers changed from: package-private */
    public void setNumberImage(int i) {
        this.numberImage = i;
    }

    private void updateSubtract(int i) {
        this.subtract = TransitionUtil.getSubtract(i);
    }

    /* access modifiers changed from: package-private */
    public void init() {
        int i = this.seconds / this.numberImage;
        this.timeDurationToMilliseconds = (long) (i * 1000);
        updateSubtract(i);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.vertexShader = ShaderUtils.readShaderFileFromRawResource(this.context, R.raw.simple_vertex_shader);
        this.fragmentShader = ShaderUtils.readShaderFileFromRawResource(this.context, R.raw.simple_fragment_shader);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.isCanStart) {
            int i = this.effectId;
            if (i == 1) {
                drawNoneEffect();
            } else if (i == 0) {
                drawRandom();
            } else if (i != 6) {
                draw();
            } else {
                drawZoom();
            }
            if (!this.isVideoStarted) {
                this.rendererListener.dismissDialog();
                this.isVideoStarted = true;
            }
        }
        GLES20.glEnable(3089);
        GLES20.glDisable(3089);
    }

    private void drawRandom() {
        if (!this.isStartDraw) {
            this.timeStart = System.currentTimeMillis();
            this.timeLine = this.timeStart;
            this.isStartDraw = true;
            this.currentItem = 0;
        }
        int i = this.numberImage;
        if (i == 0 || this.currentItem >= i) {
            this.rendererListener.previewComplete();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.timeStart < this.totalTimeToMilliseconds) {
            long j = currentTimeMillis - this.timeLine;
            int i2 = this.currentItem;
            if (i2 < this.numberImage) {
                Texture texture = this.textureArrayList.get(i2);
                texture.setEffectId(this.effectId);
                long j2 = this.timeDurationToMilliseconds;
                if (j < j2 - ML_SECOND_NEXT_EFFECT) {
                    texture.draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                } else {
                    int i3 = this.currentItem;
                    if (i3 == this.numberImage - 1) {
                        this.textureArrayList.get(i3).draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                    } else if (j >= j2) {
                        this.timeLine = currentTimeMillis - (j - j2);
                    }
                    if (this.currentItem + 1 < this.textureArrayList.size()) {
                        float totalTranslate = texture.getTotalTranslate();
                        this.textureArrayList.get(this.currentItem + 1).draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                        texture.draw(Float.valueOf(totalTranslate), this.subtract, this.currentItem);
                        texture.setTotalTranslate(totalTranslate - this.subtract);
                    }
                }
                this.currentItem = (int) ((currentTimeMillis - this.timeStart) / this.timeDurationToMilliseconds);
            }
            int currentTimeMillis2 = ((int) (System.currentTimeMillis() - this.timeStart)) / 1000;
            if (currentTimeMillis2 <= this.seconds && this.secondsDisplay < currentTimeMillis2) {
                this.secondsDisplay = currentTimeMillis2;
                this.rendererListener.updateSeekBarTime(this.secondsDisplay);
            }
        }
    }

    private void drawNoneEffect() {
        int i;
        if (!this.isStartDraw) {
            this.timeStart = System.currentTimeMillis();
            this.timeLine = this.timeStart;
            this.isStartDraw = true;
            this.currentItem = 0;
        }
        int i2 = this.numberImage;
        if (i2 == 0 || this.currentItem >= i2) {
            this.rendererListener.previewComplete();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.timeStart < this.totalTimeToMilliseconds && (i = this.currentItem) < this.numberImage) {
            Texture texture = this.textureArrayList.get(i);
            texture.setEffectId(this.effectId);
            texture.draw(Float.valueOf(10.2f), this.subtract, this.currentItem);
            this.currentItem = (int) ((currentTimeMillis - this.timeStart) / this.timeDurationToMilliseconds);
            int currentTimeMillis2 = ((int) (System.currentTimeMillis() - this.timeStart)) / 1000;
            if (currentTimeMillis2 <= this.seconds && this.secondsDisplay < currentTimeMillis2) {
                this.secondsDisplay = currentTimeMillis2;
                this.rendererListener.updateSeekBarTime(this.secondsDisplay);
            }
        }
    }

    private void draw() {
        if (!this.isStartDraw) {
            this.timeStart = System.currentTimeMillis();
            this.timeLine = this.timeStart;
            this.isStartDraw = true;
            this.currentItem = 0;
        }
        int i = this.numberImage;
        if (i == 0 || this.currentItem >= i) {
            this.rendererListener.previewComplete();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.timeStart < this.totalTimeToMilliseconds) {
            long j = currentTimeMillis - this.timeLine;
            int i2 = this.currentItem;
            if (i2 < this.numberImage) {
                Texture texture = this.textureArrayList.get(i2);
                texture.setEffectId(this.effectId);
                long j2 = this.timeDurationToMilliseconds;
                if (j < j2 - ML_SECOND_NEXT_EFFECT) {
                    texture.draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                } else {
                    int i3 = this.currentItem;
                    if (i3 == this.numberImage - 1) {
                        this.textureArrayList.get(i3).draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                    } else if (j >= j2) {
                        this.timeLine = currentTimeMillis - (j - j2);
                    }
                    if (this.currentItem + 1 < this.textureArrayList.size()) {
                        float totalTranslate = texture.getTotalTranslate();
                        this.textureArrayList.get(this.currentItem + 1).draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                        texture.draw(Float.valueOf(totalTranslate), this.subtract, this.currentItem);
                        texture.setTotalTranslate(totalTranslate - this.subtract);
                    }
                }
                this.currentItem = (int) ((currentTimeMillis - this.timeStart) / this.timeDurationToMilliseconds);
            }
            int currentTimeMillis2 = ((int) (System.currentTimeMillis() - this.timeStart)) / 1000;
            if (currentTimeMillis2 <= this.seconds && this.secondsDisplay < currentTimeMillis2) {
                this.secondsDisplay = currentTimeMillis2;
                this.rendererListener.updateSeekBarTime(this.secondsDisplay);
            }
        }
    }

    private void drawZoom() {
        int i;
        if (!this.isStartDraw) {
            this.timeStart = System.currentTimeMillis();
            this.timeLine = this.timeStart;
            this.isStartDraw = true;
            this.currentItem = 0;
        }
        int i2 = this.numberImage;
        if (i2 == 0 || this.currentItem >= i2) {
            this.rendererListener.previewComplete();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.timeStart;
        if (currentTimeMillis - j < this.totalTimeToMilliseconds && (i = this.currentItem) < this.numberImage) {
            long j2 = currentTimeMillis - j;
            Texture texture = this.textureArrayList.get(i);
            texture.setEffectId(this.effectId);
            int i3 = this.currentItem;
            long j3 = this.timeDurationToMilliseconds;
            if (((long) i3) * j3 > j2 || j2 >= (((long) i3) * j3) + 600) {
                texture.draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                this.currentItem = (int) ((currentTimeMillis - this.timeStart) / this.timeDurationToMilliseconds);
            } else {
                if (i3 > 0) {
                    this.textureArrayList.get(i3 - 1).draw(Float.valueOf(-10.2f), this.subtract, this.currentItem);
                }
                float totalTranslate = texture.getTotalTranslate();
                texture.draw(Float.valueOf(totalTranslate), this.subtract, this.currentItem);
                texture.setTotalTranslate(totalTranslate - this.subtract);
            }
            int currentTimeMillis2 = ((int) (System.currentTimeMillis() - this.timeStart)) / 1000;
            if (currentTimeMillis2 <= this.seconds && this.secondsDisplay < currentTimeMillis2) {
                this.secondsDisplay = currentTimeMillis2;
                this.rendererListener.updateSeekBarTime(this.secondsDisplay);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        this.positionImagePause = this.currentItem;
        this.timeRunned = System.currentTimeMillis() - this.timeStart;
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        this.timeStart = System.currentTimeMillis() - this.timeRunned;
        this.timeLine = this.timeStart + (((long) this.positionImagePause) * this.timeDurationToMilliseconds);
    }

    /* access modifiers changed from: package-private */
    public void updateDuration(int i) {
        this.timeDurationToMilliseconds = (long) (i * 1000);
        updateSubtract(i);
        setSeconds(i * this.numberImage);
    }
}