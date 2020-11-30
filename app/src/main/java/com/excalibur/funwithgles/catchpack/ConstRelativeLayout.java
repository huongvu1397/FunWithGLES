package com.excalibur.funwithgles.catchpack;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class ConstRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Handler f15970a = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f15971b = 0;

    public ConstRelativeLayout(Context context) {
        super(context);
    }

    public ConstRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ConstRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(final int i, int i2, int i3, int i4) {
        if (this.f15971b == 0) {
            this.f15971b = i2;
        }
        this.f15970a.post(new Runnable() {
            public final void run() {
                ConstRelativeLayout.this.setLayoutParams(new FrameLayout.LayoutParams(i, ConstRelativeLayout.this.f15971b));
            }
        });
    }

    public int getTopView() {
        return this.f15971b;
    }
}