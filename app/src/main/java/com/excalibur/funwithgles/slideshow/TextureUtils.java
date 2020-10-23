package com.excalibur.funwithgles.slideshow;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.opengl.GLUtils;

import java.io.IOException;

public class TextureUtils {
    public static Bitmap loadBitmap(String str) {
        Bitmap decodeSampledBitmapFromResource = decodeSampledBitmapFromResource(str, 1080, 1080);
        int rotateBitMap = getRotateBitMap(str);
        if (rotateBitMap == 90) {
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);
            return Bitmap.createBitmap(decodeSampledBitmapFromResource, 0, 0, decodeSampledBitmapFromResource.getWidth(), decodeSampledBitmapFromResource.getHeight(), matrix, true);
        } else if (rotateBitMap == 270) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(270.0f);
            return Bitmap.createBitmap(decodeSampledBitmapFromResource, 0, 0, decodeSampledBitmapFromResource.getWidth(), decodeSampledBitmapFromResource.getHeight(), matrix2, true);
        } else if (rotateBitMap != 180) {
            return decodeSampledBitmapFromResource;
        } else {
            Matrix matrix3 = new Matrix();
            matrix3.postRotate(180.0f);
            return Bitmap.createBitmap(decodeSampledBitmapFromResource, 0, 0, decodeSampledBitmapFromResource.getWidth(), decodeSampledBitmapFromResource.getHeight(), matrix3, true);
        }
    }

    public static int getRotateBitMap(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int loadTexture(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(5);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        bitmap.recycle();
        return iArr[0];
    }

    public static int loadTextureInteger(Bitmap bitmap) {
        return bindBitmap(bitmap);
    }

    public static int bindBitmap(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    public static Bitmap decodeSampledBitmapFromResource(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }
}