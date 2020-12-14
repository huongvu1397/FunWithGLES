package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.RectF;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.Dja;

final class c implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ float hHc;
    final /* synthetic */ float iHc;
    final /* synthetic */ CropOverlayView.a jHc;
    final /* synthetic */ RectF kHc;
    final /* synthetic */ PointF lHc;
    final /* synthetic */ CropOverlayView this$0;

    public c(float f, float f2, CropOverlayView.a aVar, RectF rectF, CropOverlayView cropOverlayView, float f3, PointF pointF, Animator.AnimatorListener animatorListener) {
        this.hHc = f;
        this.iHc = f2;
        this.jHc = aVar;
        this.kHc = rectF;
        this.this$0 = cropOverlayView;
        this.lHc = pointF;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        C3905oka.d(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            float f = this.hHc * floatValue;
            float f2 = this.iHc * floatValue;
            PointF pointF = this.lHc;
            float f3 = pointF.x * floatValue;
            float f4 = pointF.y * floatValue;
            int i = b.$EnumSwitchMapping$1[this.jHc.ordinal()];
            if (i == 1) {
                this.this$0.yk().left = (this.kHc.left - f) + f3;
                this.this$0.yk().right = this.kHc.right + f3;
                this.this$0.yk().top = (this.kHc.top - f2) + f4;
                this.this$0.yk().bottom = this.kHc.bottom + f4;
            } else if (i == 2) {
                this.this$0.yk().left = this.kHc.left + f3;
                this.this$0.yk().right = this.kHc.right + f + f3;
                this.this$0.yk().top = (this.kHc.top - f2) + f4;
                this.this$0.yk().bottom = this.kHc.bottom + f4;
            } else if (i == 3) {
                this.this$0.yk().left = (this.kHc.left - f) + f3;
                this.this$0.yk().right = this.kHc.right + f3;
                this.this$0.yk().top = this.kHc.top + f4;
                this.this$0.yk().bottom = this.kHc.bottom + f2 + f4;
            } else if (i == 4) {
                this.this$0.yk().left = this.kHc.left + f3;
                this.this$0.yk().right = this.kHc.right + f + f3;
                this.this$0.yk().top = this.kHc.top + f4;
                this.this$0.yk().bottom = this.kHc.bottom + f2 + f4;
            }
            this.this$0.postInvalidate();
            return;
        }
        throw new Dja("null cannot be cast to non-null type kotlin.Float");
    }
}