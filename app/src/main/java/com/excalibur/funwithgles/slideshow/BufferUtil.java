package com.excalibur.funwithgles.slideshow;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class BufferUtil {
    public static FloatBuffer newFloatBuffer(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asFloatBuffer();
    }

    public static ShortBuffer newShortBuffer(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asShortBuffer();
    }
}