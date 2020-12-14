package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.view.View;
import android.view.animation.Animation;

/* renamed from: oU  reason: default package and case insensitive filesystem */
final class C3889oU implements Animation.AnimationListener {
    final /* synthetic */ int Pmd;
    final /* synthetic */ View ZEc;

    C3889oU(View view, int i) {
        this.ZEc = view;
        this.Pmd = i;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.ZEc.getAnimation() == animation) {
            this.ZEc.setVisibility(this.Pmd);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        if (this.ZEc.getAnimation() == animation) {
            this.ZEc.setVisibility(View.VISIBLE);
        }
    }
}