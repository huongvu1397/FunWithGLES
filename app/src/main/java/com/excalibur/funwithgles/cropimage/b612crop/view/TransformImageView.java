package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C1936XE;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;

public class TransformImageView extends androidx.appcompat.widget.AppCompatImageView {
    private final float[] TH;
    private float[] UH;
    private float[] VH;
    private final Matrix WH;
    private float[] XH;
    private float[] YH;
    public a ZH;

    public interface a {
    }

    public TransformImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public final float Bg() {
        Matrix matrix = this.WH;
        matrix.getValues(this.TH);
        double pow = Math.pow((double) this.TH[0], 2.0d);
        matrix.getValues(this.TH);
        return (float) Math.sqrt(Math.pow((double) this.TH[3], 2.0d) + pow);
    }

    public final float Pj() {
        Matrix matrix = this.WH;
        matrix.getValues(this.TH);
        float[] fArr = this.TH;
        matrix.getValues(fArr);
        return (float) (-(Math.atan2((double) fArr[1], (double) this.TH[0]) * 57.29577951308232d));
    }

    /* access modifiers changed from: protected */
    public final float[] Qj() {
        return this.YH;
    }

    public final float[] Rj() {
        return this.XH;
    }

    /* access modifiers changed from: protected */
    public final Matrix Sj() {
        return this.WH;
    }

    /* access modifiers changed from: protected */
    public final float[] Tj() {
        return this.UH;
    }

    /* access modifiers changed from: protected */
    public final void Uj() {
        if (getDrawable() != null) {
            Drawable drawable = getDrawable();
            C3905oka.d(drawable, "drawable");
            Drawable drawable2 = getDrawable();
            C3905oka.d(drawable2, "drawable");
            RectF rectF = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable2.getIntrinsicHeight());
            float[] j = C1936XE.j(rectF);
            C3905oka.d(j, "RectUtils.getCornersFromRect(drawableRect)");
            this.UH = j;
            float[] fArr = {rectF.centerX(), rectF.centerY()};
            C3905oka.d(fArr, "RectUtils.getCenterFromRect(drawableRect)");
            this.VH = fArr;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Uj();
        }
    }

    /* access modifiers changed from: protected */
    public final void postRotate(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.WH.postRotate(f, f2, f3);
            setImageMatrix(this.WH);
        }
    }

    /* access modifiers changed from: protected */
    public void postScale(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.WH.postScale(f, f, f2, f3);
            setImageMatrix(this.WH);
        }
    }

    /* access modifiers changed from: protected */
    public final void postTranslate(float f, float f2) {
        if (f != 0.0f || f2 != 0.0f) {
            this.WH.postTranslate(f, f2);
            setImageMatrix(this.WH);
        }
    }

    public final void setCurrentImageCorners(float[] fArr) {
        C3905oka.e(fArr, "<set-?>");
        this.XH = fArr;
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.WH.set(matrix);
        this.WH.mapPoints(this.XH, this.UH);
        this.WH.mapPoints(this.YH, this.VH);
        a aVar = this.ZH;
        if (aVar != null) {
            f fVar = (f) aVar;
            fVar.this$0.Vs.d(fVar.this$0.Us.Vj());
            return;
        }
        C3905oka.Pf("imageMatrixCallback");
        throw null;
    }

    public final void setImageMatrixCallback(a aVar) {
        C3905oka.e(aVar, "<set-?>");
        this.ZH = aVar;
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TH = new float[9];
        this.UH = new float[8];
        this.VH = new float[2];
        this.WH = new Matrix();
        this.XH = new float[8];
        this.YH = new float[2];
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}