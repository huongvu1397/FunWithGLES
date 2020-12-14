package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;

public final class GestureCropImageView extends CropImageView {
    private final GestureDetector Ak;
    private final ScaleGestureDetector dI;
    /* access modifiers changed from: private */
    public final PointF eI;
    public c fI;

    private final class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.postTranslate(-f, -f2);
            return true;
        }
    }

    private final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public b() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector == null) {
                return false;
            }
            GestureCropImageView.this.postScale(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.eI.x, GestureCropImageView.this.eI.y);
            return true;
        }
    }

    public interface c {
    }

    public GestureCropImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C3905oka.e(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            c cVar = this.fI;
            if (cVar != null) {
                ((g) cVar).FP();
            } else {
                C3905oka.Pf("touchCallback");
                throw null;
            }
        }
        if (motionEvent.getPointerCount() > 1) {
            float x = motionEvent.getX(1) + motionEvent.getX(0);
            float f = (float) 2;
            float y = motionEvent.getY(0);
            this.eI.set(x / f, (motionEvent.getY(1) + y) / f);
        }
        this.Ak.onTouchEvent(motionEvent);
        this.dI.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            c cVar2 = this.fI;
            if (cVar2 != null) {
                ((g) cVar2).onTouchUp();
                setImageToWrapCropBounds(true);
            } else {
                C3905oka.Pf("touchCallback");
                throw null;
            }
        }
        return true;
    }

    public final void setTouchCallback(c cVar) {
        C3905oka.e(cVar, "<set-?>");
        this.fI = cVar;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eI = new PointF();
        this.Ak = new GestureDetector(context, new a());
        this.dI = new ScaleGestureDetector(context, new b());
    }
}