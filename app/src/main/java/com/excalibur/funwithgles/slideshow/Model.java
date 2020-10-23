package com.excalibur.funwithgles.slideshow;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.renderscript.Matrix4f;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

public class Model {
    private static final int COLORS_PER_VERTEX = 4;
    private static final int COORDS_PER_VERTEX = 3;
    public static final int EFFECT_DOWN = 4;
    public static final int EFFECT_LEFT = 2;
    public static final int EFFECT_NONE = 1;
    public static final int EFFECT_RANDOM = 0;
    public static final int EFFECT_RIGHT = 3;
    public static final int EFFECT_UP = 5;
    public static final int EFFECT_ZOOM_IN = 7;
    public static final int EFFECT_ZOOM_OUT = 6;
    private static final int SIZE_OF_FLOAT = 4;
    private static final int SIZE_OF_SHORT = 2;
    private static final int TEXCOORDS_PER_VERTEX = 2;
    static final short[] arrIndices = {0, 1, 2, 0, 2, 3};
    private int effectId;
    private ShortBuffer indexBuffer;
    private int indexBufferId;
    private short[] indices;
    private boolean isRandom;
    protected Matrix4f matrix4f;
    float scale;
    private ShaderProgram shaderProgram;
    final float[] squareCoordZoom = {-0.25f, 0.25f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -0.25f, -0.25f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.25f, -0.25f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.25f, 0.25f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    final float[] squareCoordinates = {-1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
    private int texture;
    private float totalTranslate;
    private FloatBuffer vertexBuffer;
    private int vertexBufferId;
    private int vertexCount;
    private int vertexStride;
    private float[] vertices;

    public Model(ShaderProgram shaderProgram2, float f) {
        this.shaderProgram = shaderProgram2;
        float[] fArr = this.squareCoordinates;
        this.vertices = Arrays.copyOfRange(fArr, 0, fArr.length);
        short[] sArr = arrIndices;
        this.indices = Arrays.copyOfRange(sArr, 0, sArr.length);
        this.matrix4f = new Matrix4f();
        this.scale = f;
        scaleImage();
    }

    public void setMatrix4f(Matrix4f matrix4f2) {
        this.matrix4f = matrix4f2;
        scaleImage();
    }

    public void init() {
        setupVertexBuffer();
        setupIndexBuffer();
    }

    private void scaleImage() {
        if (this.scale < 1.0f) {
            Matrix.scaleM(this.matrix4f.getArray(), 0, this.scale, 1.0f, 1.0f);
        } else {
            Matrix.scaleM(this.matrix4f.getArray(), 0, 1.0f, 1.0f / this.scale, 1.0f);
        }
    }

    private void setupIndexBuffer() {
        this.indexBuffer = BufferUtil.newShortBuffer(this.indices.length);
        this.indexBuffer.put(this.indices);
        this.indexBuffer.position(0);
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGenBuffers(1, allocate);
        this.indexBufferId = allocate.get(0);
        GLES20.glBindBuffer(34963, this.indexBufferId);
        GLES20.glBufferData(34963, this.indices.length * 2, this.indexBuffer, 35044);
    }

    private void setupVertexBuffer() {
        this.vertexBuffer = BufferUtil.newFloatBuffer(this.vertices.length);
        this.vertexBuffer.put(this.vertices);
        this.vertexBuffer.position(0);
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGenBuffers(1, allocate);
        this.vertexBufferId = allocate.get(0);
        GLES20.glBindBuffer(34962, this.vertexBufferId);
        GLES20.glBufferData(34962, this.vertices.length * 4, this.vertexBuffer, 35044);
        this.vertexCount = (this.vertices.length / 3) + 4;
        this.vertexStride = 36;
    }

    public void setBitmap(Bitmap bitmap) {
        this.texture = TextureUtils.loadTexture(bitmap);
    }

    public void setTotalTranslate(float f) {
        this.totalTranslate = f;
    }

    public float getTotalTranslate() {
        return this.totalTranslate;
    }

    public void setEffectId(int i) {
        this.effectId = i;
        if (i != 0) {
            this.isRandom = false;
            if (i == 6) {
                float[] fArr = this.squareCoordZoom;
                this.vertices = Arrays.copyOfRange(fArr, 0, fArr.length);
            } else {
                float[] fArr2 = this.squareCoordinates;
                this.vertices = Arrays.copyOfRange(fArr2, 0, fArr2.length);
            }
        } else {
            this.isRandom = true;
            float[] fArr3 = this.squareCoordinates;
            this.vertices = Arrays.copyOfRange(fArr3, 0, fArr3.length);
        }
        init();
    }

    public void draw(Float f, float f2, int i) {
        float f3 = f2;
        this.shaderProgram.begin();
        int uniformi = this.shaderProgram.getUniformi("transition_matrix");
        int attribLocationByName = this.shaderProgram.getAttribLocationByName("position");
        int attribLocationByName2 = this.shaderProgram.getAttribLocationByName("color");
        int attribLocationByName3 = this.shaderProgram.getAttribLocationByName("texture_coordinate");
        int uniformi2 = this.shaderProgram.getUniformi("texture");
        GLES20.glUniformMatrix4fv(uniformi, 1, false, this.matrix4f.getArray(), 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.texture);
        GLES20.glUniform1i(uniformi2, 1);
        GLES20.glEnableVertexAttribArray(attribLocationByName);
        GLES20.glVertexAttribPointer(attribLocationByName, 3, 5126, false, this.vertexStride, 0);
        GLES20.glEnableVertexAttribArray(attribLocationByName2);
        GLES20.glVertexAttribPointer(attribLocationByName2, 4, 5126, false, this.vertexStride, 12);
        GLES20.glEnableVertexAttribArray(attribLocationByName3);
        GLES20.glVertexAttribPointer(attribLocationByName3, 2, 5126, false, this.vertexStride, 28);
        GLES20.glDrawElements(4, this.indices.length, 5123, 0);
        Float valueOf = Float.valueOf(f.floatValue() - f3);
        if (!this.isRandom) {
            customMatrix(valueOf, f3);
        } else {
            customMatrixRandom(valueOf, f3, i);
        }
        GLES20.glDisableVertexAttribArray(attribLocationByName3);
        GLES20.glDisableVertexAttribArray(attribLocationByName2);
        GLES20.glDisableVertexAttribArray(attribLocationByName);
        GLES20.glUseProgram(0);
    }

    private void customMatrixRandom(Float f, float f2, int i) {
        if (((double) f.floatValue()) >= -0.1d) {
            int i2 = i % 7;
            if (i2 == 0) {
                Matrix.scaleM(this.matrix4f.getArray(), 0, 0.94f, 0.94f, 0.0f);
            } else if (i2 == 1) {
                Matrix.translateM(this.matrix4f.getArray(), 0, 0.068f, 0.0f, 0.0f);
            } else if (i2 == 2) {
                Matrix.scaleM(this.matrix4f.getArray(), 0, 1.042f, 1.042f, 0.0f);
            } else if (i2 == 3) {
                Matrix.translateM(this.matrix4f.getArray(), 0, 0.0f, 0.068f, 0.0f);
            } else if (i2 == 4) {
                Matrix.scaleM(this.matrix4f.getArray(), 0, 0.94f, 0.94f, 0.0f);
            } else if (i2 == 5) {
                Matrix.translateM(this.matrix4f.getArray(), 0, -0.068f, 0.0f, 0.0f);
            } else if (i2 == 6) {
                Matrix.translateM(this.matrix4f.getArray(), 0, 0.0f, -0.068f, 0.0f);
            }
        } else if (f.floatValue() <= -10.0f) {
            float f3 = f2 + 1.0f;
            Matrix.scaleM(this.matrix4f.getArray(), 0, f3, f3, 0.0f);
        } else {
            float f4 = f2 + 1.0f;
            Matrix.scaleM(this.matrix4f.getArray(), 0, f4, f4, 0.0f);
        }
    }

    private void customMatrix(Float f, float f2) {
        if (((double) f.floatValue()) >= -0.1d) {
            switch (this.effectId) {
                case 1:
                    Matrix.translateM(this.matrix4f.getArray(), 0, 0.0f, 0.0f, 0.0f);
                    return;
                case 2:
                    Matrix.translateM(this.matrix4f.getArray(), 0, 0.068f, 0.0f, 0.0f);
                    return;
                case 3:
                    Matrix.translateM(this.matrix4f.getArray(), 0, -0.068f, 0.0f, 0.0f);
                    return;
                case 4:
                    Matrix.translateM(this.matrix4f.getArray(), 0, 0.0f, -0.068f, 0.0f);
                    return;
                case 5:
                    Matrix.translateM(this.matrix4f.getArray(), 0, 0.0f, 0.068f, 0.0f);
                    return;
                case 6:
                    Matrix.scaleM(this.matrix4f.getArray(), 0, 1.042f, 1.042f, 0.0f);
                    return;
                case 7:
                    Matrix.scaleM(this.matrix4f.getArray(), 0, 0.94f, 0.94f, 0.0f);
                    return;
                default:
                    return;
            }
        } else if (f.floatValue() <= -10.0f) {
            float f3 = f2 + 1.0f;
            Matrix.scaleM(this.matrix4f.getArray(), 0, f3, f3, 0.0f);
        } else {
            float f4 = f2 + 1.0f;
            Matrix.scaleM(this.matrix4f.getArray(), 0, f4, f4, 0.0f);
        }
    }
}