package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;

import com.excalibur.funwithgles.App;

/* renamed from: sY  reason: default package and case insensitive filesystem */
public class C4081sY {
    private static float _qd = 25.0f;
    private static final Matrix ard = new Matrix();

    public static int Ya(float f) {
        return (int) ((f * App.self().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float Za(float f) {
        return f * App.self().getResources().getDisplayMetrics().density;
    }

    public static float _a(float f) {
        return Math.max(0.0f, Math.min(_qd, Za(f)));
    }

    public static float[] a(float f, float f2, float f3, float f4, float f5) {
        float[] fArr = new float[4];
        float h = (f5 / h(f, f2, f3, f4)) + 1.0f;
        ard.setScale(h, h);
        ard.mapPoints(fArr, new float[]{0.0f, 0.0f, f3 - f, f4 - f2});
        fArr[0] = fArr[0] + f;
        fArr[1] = fArr[1] + f2;
        fArr[2] = fArr[2] + f;
        fArr[3] = fArr[3] + f2;
        return new float[]{fArr[2], fArr[3]};
    }

    public static float b(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
    }

    public static float c(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f - f4;
        float f8 = f2 - f5;
        float f9 = f3 - f6;
        return (float) Math.sqrt((double) ((f9 * f9) + (f8 * f8) + (f7 * f7)));
    }

    public static float ek(int i) {
        return ((float) i) / App.self().getResources().getDisplayMetrics().density;
    }

    public static float h(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((double) ((f6 * f6) + (f5 * f5)));
    }

    public static int q(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }
}