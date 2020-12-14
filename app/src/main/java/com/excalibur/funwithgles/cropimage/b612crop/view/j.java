package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.view.View;

public final class j implements View.OnLayoutChangeListener {
    final /* synthetic */ CropView this$0;

    j(CropView cropView) {
        this.this$0 = cropView;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.this$0.Vs.removeOnLayoutChangeListener(this);
        this.this$0.Xs = true;
    }
}