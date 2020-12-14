package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.view.animation.Animation;

/* renamed from: uU  reason: default package and case insensitive filesystem */
final class C4171uU implements Animation.AnimationListener {
    final /* synthetic */ Animation.AnimationListener val$listener;

    C4171uU(Animation.AnimationListener animationListener) {
        this.val$listener = animationListener;
    }

    public void onAnimationEnd(Animation animation) {
        Animation.AnimationListener animationListener = this.val$listener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}