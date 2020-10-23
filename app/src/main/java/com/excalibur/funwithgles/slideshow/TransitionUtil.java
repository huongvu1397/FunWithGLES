package com.excalibur.funwithgles.slideshow;

public class TransitionUtil {
    private static final float TOTAL_TRANSLATE = 3.0f;

    public static float getSubtract(int i) {
        return TOTAL_TRANSLATE / ((float) (i * 1875));
    }

    public static float getTotalTranslate() {
        return TOTAL_TRANSLATE;
    }
}