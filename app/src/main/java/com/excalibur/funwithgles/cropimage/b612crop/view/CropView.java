package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;

public final class CropView extends FrameLayout {
    /* access modifiers changed from: private */
    public final GestureCropImageView Us;
    /* access modifiers changed from: private */
    public final CropOverlayView Vs;
    /* access modifiers changed from: private */
    public boolean Ws;
    /* access modifiers changed from: private */
    public boolean Xs;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CropView(Context context) {
        this(context, (AttributeSet) null);
        C3905oka.e(context, "context");
    }

    public final Bitmap M(String str) {
        C3905oka.e(str, "targetPath");
        this.Vs.xk();
        return this.Us.M(str);
    }

    public final boolean isModified() {
        return this.Us.isModified();
    }

    public final com.excalibur.funwithgles.cropimage.b612crop.b kh() {
        return this.Vs.kh();
    }

    public final boolean lh() {
        return this.Ws;
    }

    public final void reset() {
        if (this.Xs) {
            this.Vs.setCropType(com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_ORIGINAL);
            this.Us.setCropRect(this.Vs.yk());
            this.Us.setInitialCropOriginalTypeRectBoundary();
        } else {
            post(new l(this));
        }
        this.Ws = false;
    }

    public final void setCropType(com.excalibur.funwithgles.cropimage.b612crop.b bVar) {
        C3905oka.e(bVar, "cropType");
        this.Vs.setCropType(bVar);
        this.Us.setCropRect(this.Vs.yk());
        this.Us.a(bVar);
        this.Us.setImageToWrapCropBounds(false);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        C3905oka.e(bitmap, "bitmap");
        this.Vs.setTargetAspectRatio(((float) bitmap.getWidth()) / ((float) bitmap.getHeight()));
        this.Us.setImageBitmap(bitmap);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        C3905oka.e(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C3905oka.e(context, "context");
        this.Us = new GestureCropImageView(context, (AttributeSet) null, 0);
        this.Vs = new CropOverlayView(context, (AttributeSet) null, 0);
        this.Us.setImageMatrixCallback(new f(this));
        this.Us.setTouchCallback(new g(this));
        this.Vs.setTouchCallback(new i(this));
        this.Vs.addOnLayoutChangeListener(new j(this));
        this.Vs.setCropImageInfoListener(new k(this));
        addView(this.Us, -1, -1);
        addView(this.Vs, -1, -1);
    }

    public final void a(int i, boolean z, boolean z2) {
        this.Us.Va(i);
        this.Vs.setRotateHandle(z);
        this.Vs.postInvalidate();
        if (z2) {
            this.Us.setImageToWrapCropBounds(true);
        }
    }

    public final void a(int i, com.excalibur.funwithgles.cropimage.b612crop.b bVar) {
        C3905oka.e(bVar, "cropType");
        this.Vs.setCropType(bVar);
        this.Us.a(i, this.Vs.yk());
        this.Us.setImageToWrapCropBounds(false);
    }
}