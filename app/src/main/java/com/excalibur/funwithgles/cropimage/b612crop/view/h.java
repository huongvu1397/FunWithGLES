package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.animation.Animator;

public final class h implements Animator.AnimatorListener {
    final /* synthetic */ i this$0;

    h(i iVar) {
        this.this$0 = iVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.this$0.this$0.Us.setCropRect(this.this$0.this$0.Vs.yk());
        this.this$0.this$0.Us.setImageToWrapCropBounds(true);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}