package com.excalibur.funwithgles.catchpack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class CanTouchView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f15962a;

    public interface a {
        boolean a();
    }

    public CanTouchView(Context context) {
        super(context);
    }

    public CanTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CanTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCanclick(a aVar) {
        this.f15962a = aVar;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f15962a != null && this.f15962a.a()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}