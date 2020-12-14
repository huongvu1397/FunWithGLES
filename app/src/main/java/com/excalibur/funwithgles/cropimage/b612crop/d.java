package com.excalibur.funwithgles.cropimage.b612crop;

import android.view.View;
import android.view.animation.Animation;

import com.excalibur.funwithgles.cropimage.UCropActivity;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3971qI;

public final class d extends C3971qI {
    final /* synthetic */ Runnable Ck;
    final /* synthetic */ UCropActivity this$0;

    public d(UCropActivity editFeatureCropFragment, Runnable runnable) {
        this.this$0 = editFeatureCropFragment;
        this.Ck = runnable;
    }

    public void onAnimationEnd(Animation animation) {
        this.Ck.run();
        UCropActivity.Companion.d(this.this$0);
        this.this$0.Dp().setVisibility(View.INVISIBLE);
    }
}