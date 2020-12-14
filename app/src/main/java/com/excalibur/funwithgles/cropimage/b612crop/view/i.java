package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.graphics.PointF;
import android.graphics.RectF;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;

public final class i implements CropOverlayView.b {
    private final RectF mHc = new RectF();
    private boolean nHc = true;
    final /* synthetic */ CropView this$0;

    i(CropView cropView) {
        this.this$0 = cropView;
    }

    public void a(RectF rectF, PointF pointF) {
        C3905oka.e(rectF, "overlayRect");
        C3905oka.e(pointF, "scalePivot");
        this.nHc = true;
        float min = Math.min(this.mHc.width() / rectF.width(), this.mHc.height() / rectF.height());
        if (min < 1.0f) {
            min = 1.0f;
        }
        if (min > 1.0f) {
            this.this$0.Ws = true;
        }
        PointF a = this.this$0.Vs.a(min, pointF);
        this.this$0.Us.a(min, pointF.x, pointF.y, a);
        this.this$0.Vs.a(min, pointF, a, new h(this));
    }

    public void g(RectF rectF) {
        C3905oka.e(rectF, "overlayRect");
        if (this.nHc) {
            this.mHc.set(rectF);
        }
        this.nHc = false;
    }

    public void h(RectF rectF) {
        C3905oka.e(rectF, "overlayRect");
        this.this$0.Us.setCropRect(rectF);
    }
}