package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

/* renamed from: Gka  reason: default package */
public final class Gka extends Hka {
    public static /* synthetic */ int jb(float f) {
        if (!Float.isNaN(f)) {
            return Math.round(f);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static /* synthetic */ long kb(float f) {
        double d = (double) f;
        if (!Double.isNaN(d)) {
            return Math.round(d);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}