package com.excalibur.funwithgles.cropimage.b612crop.view;

final class l implements Runnable {
    final /* synthetic */ CropView this$0;

    l(CropView cropView) {
        this.this$0 = cropView;
    }

    public final void run() {
        this.this$0.Vs.setCropType(com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_ORIGINAL);
        this.this$0.Us.setCropRect(this.this$0.Vs.yk());
        this.this$0.Us.setInitialCropOriginalTypeRectBoundary();
    }
}