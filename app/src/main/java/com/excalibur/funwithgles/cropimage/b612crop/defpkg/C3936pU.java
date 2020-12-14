package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import com.excalibur.funwithgles.R;

/* renamed from: pU  reason: default package and case insensitive filesystem */
public class C3936pU {
    public static void a(View view, int i, boolean z, int i2) {
        if (view != null) {
            view.clearAnimation();
            if (!z) {
                view.setVisibility(i);
            } else if (view.getVisibility() != i) {
                float f = 1.0f;
                float f2 = i == 0 ? 0.0f : 1.0f;
                if (i != 0) {
                    f = 0.0f;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
                alphaAnimation.setDuration((long) i2);
                alphaAnimation.setAnimationListener(new C3889oU(view, i));
                view.startAnimation(alphaAnimation);
            }
        }
    }

    public static void c(View view, int i, boolean z) {
        int i2 = i == 0 ? 100 : 300;
        if (view.getVisibility() == View.VISIBLE || i == 0) {
            float f = i == 0 ? 1.0f : 0.0f;
            view.setVisibility(View.VISIBLE);
            Object tag = view.getTag(1312);
            if (tag instanceof Animator) {
                ((Animator) tag).cancel();
            }
            if (!z) {
                view.setAlpha(f);
                view.setVisibility(i);
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{f});
            ofFloat.setDuration((long) i2);
            ofFloat.setStartDelay((long) 0);
            ofFloat.addListener(new C3983qU(view, i));
            ofFloat.start();
            view.setTag(1312, ofFloat);
        }
    }

    public static void a(View view, int i, boolean z, C4218vU vUVar, Animation.AnimationListener animationListener) {
        a(view, i, z, vUVar, animationListener, 300);
    }

    public static void a(View view, int i, boolean z, C4218vU vUVar, Animation.AnimationListener animationListener, int i2) {
        TranslateAnimation translateAnimation;
        View view2 = view;
        C4218vU vUVar2 = vUVar;
        if (!z) {
            view.setVisibility(i);
            return;
        }
        if (vUVar2 == C4218vU.TO_UP) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, i == 0 ? 1.0f : 0.0f, 1, i == 0 ? 0.0f : -1.0f);
        } else if (vUVar2 == C4218vU.TO_DOWN) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, i == 0 ? -1.0f : 0.0f, 1, i == 0 ? 0.0f : 1.0f);
        } else if (vUVar2 == C4218vU.TO_LEFT) {
            translateAnimation = new TranslateAnimation(1, i == 0 ? 1.0f : 0.0f, 1, i == 0 ? 0.0f : -1.0f, 1, 0.0f, 1, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(1, i == 0 ? -1.0f : 0.0f, 1, i == 0 ? 0.0f : 1.0f, 1, 0.0f, 1, 0.0f);
        }
        view2.setVisibility(View.VISIBLE);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration((long) i2);
        animationSet.setAnimationListener(new C4171uU(animationListener));
        view2.startAnimation(animationSet);
        view.setVisibility(i);
    }
}