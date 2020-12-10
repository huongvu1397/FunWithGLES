package com.excalibur.funwithgles.sdmaidpro.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

import com.excalibur.funwithgles.sdmaidpro.c0.n.a.a.b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SDMFAB extends FloatingActionButton {
    public static final Interpolator x = new b();
    public boolean v = false;
    public boolean w = false;

    public SDMFAB(Context context) {
        super(context);
    }

    public SDMFAB(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SDMFAB(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setExtraHidden(boolean z) {
        this.v = z;
        setVisibility(z ? View.INVISIBLE : View.VISIBLE);
    }
}