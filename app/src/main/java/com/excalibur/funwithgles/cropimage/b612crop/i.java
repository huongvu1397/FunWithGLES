package com.excalibur.funwithgles.cropimage.b612crop;

import android.view.animation.Animation;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3971qI;

public final class i extends C3971qI {
    final /* synthetic */ Runnable lJc;

    i(Runnable runnable) {
        this.lJc = runnable;
    }

    public void onAnimationEnd(Animation animation) {
        this.lJc.run();
    }
}