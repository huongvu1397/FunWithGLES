package com.excalibur.funwithgles.cropimage.b612crop.view;

public final class g implements GestureCropImageView.c {
    final /* synthetic */ CropView this$0;
    private boolean uj;

    g(CropView cropView) {
        this.this$0 = cropView;
    }

    public void FP() {
        this.uj = this.this$0.Vs.xk();
    }

    public void onTouchUp() {
        if (this.uj) {
            this.this$0.Vs.Ak();
        }
    }
}