package com.excalibur.funwithgles.sdmaidpro.ui;

import android.content.Context;
import android.util.AttributeSet;

import me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class SDMProgressBar extends MaterialProgressBar {
    public SDMProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SDMProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SDMProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onFinishInflate() {
        if (!isInEditMode()) {
            setIndeterminateDrawable(new IndeterminateCircularProgressDrawable(getContext()));
            setIndeterminate(true);
        }
        super.onFinishInflate();
    }
}