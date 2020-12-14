package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.Dja;

final class d implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ CropOverlayView this$0;

    d(CropOverlayView cropOverlayView) {
        this.this$0 = cropOverlayView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Paint a = this.this$0.RO;
        C3905oka.d(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            a.setAlpha(((Integer) animatedValue).intValue());
            this.this$0.postInvalidate();
            return;
        }
        throw new Dja("null cannot be cast to non-null type kotlin.Int");
    }
}