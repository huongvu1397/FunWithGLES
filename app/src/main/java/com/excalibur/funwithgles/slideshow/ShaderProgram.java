package com.excalibur.funwithgles.slideshow;

import android.opengl.GLES20;
import android.util.Log;

public class ShaderProgram {
    private String fragmentShader;
    private int fragmentShaderHandle;
    private int programHandle;
    private String vertexShader;
    private int vertexShaderHandle;

    public ShaderProgram(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("vertex shader must not be null");
        } else if (str2 != null) {
            this.vertexShader = str;
            this.fragmentShader = str2;
            this.vertexShaderHandle = loadShader(35633, str);
            this.fragmentShaderHandle = loadShader(35632, str2);
            this.programHandle = linkProgram(this.vertexShaderHandle, this.fragmentShaderHandle);
        } else {
            throw new IllegalArgumentException("fragment shader must not be null");
        }
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return -1;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
        Log.e("Chinh", "" + glGetShaderInfoLog);
        GLES20.glDeleteShader(glCreateShader);
        return -1;
    }

    private int linkProgram(int i, int i2) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            return -1;
        }
        GLES20.glAttachShader(glCreateProgram, i);
        GLES20.glAttachShader(glCreateProgram, i2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateProgram;
        }
        String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
        Log.e("Chinh", "" + glGetProgramInfoLog);
        GLES20.glDeleteProgram(glCreateProgram);
        return -1;
    }

    public int getUniformi(String str) {
        return GLES20.glGetUniformLocation(this.programHandle, str);
    }

    public int getAttribLocationByName(String str) {
        return GLES20.glGetAttribLocation(this.programHandle, str);
    }

    public void begin() {
        GLES20.glUseProgram(this.programHandle);
    }
}