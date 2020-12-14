package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.animation.Animator;
import android.view.View;

/* renamed from: qU  reason: default package and case insensitive filesystem */
final class C3983qU implements Animator.AnimatorListener {
    final /* synthetic */ int Pmd;
    final /* synthetic */ View ZEc;

    C3983qU(View view, int i) {
        this.ZEc = view;
        this.Pmd = i;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.ZEc.setVisibility(this.Pmd);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}