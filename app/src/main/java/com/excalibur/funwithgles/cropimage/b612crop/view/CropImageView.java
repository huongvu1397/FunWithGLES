package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C1936XE;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C4222vY;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.Dja;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.Ff;

import java.io.IOException;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
    private final RectF _H;
    private final Matrix aI;
    private b bI;
    private final RectF cI;
    private float maxScale;
    private float minScale;

    public interface a {
    }

    private final class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        private final float[] B = new float[9];
        private final float[] C = new float[9];
        private final Matrix matrix = new Matrix();
        final /* synthetic */ CropImageView this$0;
        private final float[] u = new float[9];

        public b(CropImageView cropImageView, Matrix matrix2, Matrix matrix3) {
            C3905oka.e(matrix2, "startMatrix");
            C3905oka.e(matrix3, "endMatrix");
            this.this$0 = cropImageView;
            setFloatValues(new float[]{0.0f, 1.0f});
            setDuration(200);
            addUpdateListener(this);
            addListener(this);
            matrix2.getValues(this.u);
            matrix3.getValues(this.B);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.matrix.setValues(this.C);
            this.this$0.setImageMatrix(this.matrix);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                for (int i = 0; i <= 8; i++) {
                    float[] fArr = this.C;
                    float[] fArr2 = this.u;
                    fArr[i] = Ff.e(this.B[i], fArr2[i], floatValue, fArr2[i]);
                }
                this.matrix.setValues(this.C);
                this.this$0.setImageMatrix(this.matrix);
                return;
            }
            throw new Dja("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public CropImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private final void a(Matrix matrix, Matrix matrix2) {
        isa();
        this.bI = new b(this, matrix, matrix2);
        b bVar = this.bI;
        if (bVar != null) {
            bVar.start();
        } else {
            C3905oka.ema();
            throw null;
        }
    }

    private final void isa() {
        b bVar = this.bI;
        if (bVar != null && bVar.isRunning()) {
            bVar.cancel();
        }
    }

    public final Bitmap M(String str) {
        String str2 = str;
        C3905oka.e(str2, "targetPath");
        float Pj = Pj() + ((float) (C4222vY.qe(str) % 360));
        Matrix matrix = new Matrix(Sj());
        matrix.setRotate(-Pj, this._H.centerX(), this._H.centerY());
        float[] Rj = Rj();
        float[] copyOf = Arrays.copyOf(Rj, Rj.length);
        C3905oka.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        float[] j = C1936XE.j(this._H);
        matrix.mapPoints(copyOf);
        matrix.mapPoints(j);
        RectF d = C1936XE.d(copyOf);
        RectF d2 = C1936XE.d(j);
        float f = this._H.left - d2.left;
        float width = d2.width();
        float f2 = d2.right;
        RectF rectF = this._H;
        float f3 = width - (f2 - rectF.right);
        float f4 = f3 - f;
        float height = (d2.height() - (d2.bottom - this._H.bottom)) - (rectF.top - d2.top);
        float width2 = (d2.left - d.left) / d.width();
        float height2 = (d2.top - d.top) / d.height();
        float width3 = (d.width() - (d.right - d2.right)) / d.width();
        float height3 = (d.height() - (d.bottom - d2.bottom)) / d.height();
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str2, options);
        float f5 = (float) options.outWidth;
        float f6 = (float) options.outHeight;
        Rect rect = new Rect((int) (width2 * f5), (int) (height2 * f6), (int) (f5 * width3), (int) (f6 * height3));
        while (Math.max(rect.width(), rect.height()) / i >2160) {
            i *= 2;
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        Bitmap decodeRegion = null;
        try {
            decodeRegion = BitmapRegionDecoder.newInstance(str2, false).decodeRegion(rect, options);
        } catch (IOException e) {
            Log.e("HVV1312","decodeRegion null");
            e.printStackTrace();
        }
        C3905oka.d(decodeRegion, "bitmap");
        float width4 = (f4 * ((float) decodeRegion.getWidth())) / d2.width();
        float height4 = (height * ((float) decodeRegion.getHeight())) / d2.height();
        Matrix matrix2 = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) decodeRegion.getWidth(), (float) decodeRegion.getHeight());
        matrix2.postRotate(Pj, ((float) decodeRegion.getWidth()) / 2.0f, ((float) decodeRegion.getHeight()) / 2.0f);
        matrix2.mapRect(rectF2);
        Bitmap createBitmap = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix2, true);
        C3905oka.d(createBitmap, "resultBitmap");
        if (width4 > ((float) createBitmap.getWidth())) {
            width4 = (float) createBitmap.getWidth();
        }
        if (height4 > ((float) createBitmap.getHeight())) {
            height4 = (float) createBitmap.getHeight();
        }
        float f7 = (float) 2;
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, (int) ((((float) createBitmap.getWidth()) - width4) / f7), (int) ((((float) createBitmap.getHeight()) - height4) / f7), (int) width4, (int) height4);
        C3905oka.d(createBitmap2, "Bitmap.createBitmap(resu…nt(), cropHeight.toInt())");
        return createBitmap2;
    }

    public final void Va(int i) {
        postRotate((-Pj()) + ((float) i), this._H.centerX(), this._H.centerY());
    }

    public final RectF Vj() {
        if (getDrawable() == null) {
            return new RectF();
        }
        Drawable drawable = getDrawable();
        C3905oka.d(drawable, "drawable");
        Drawable drawable2 = getDrawable();
        C3905oka.d(drawable2, "drawable");
        RectF rectF = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable2.getIntrinsicHeight());
        Sj().mapRect(rectF);
        return rectF;
    }

    public final boolean isModified() {
        Drawable drawable = getDrawable();
        C3905oka.d(drawable, "drawable");
        Drawable drawable2 = getDrawable();
        C3905oka.d(drawable2, "drawable");
        RectF rectF = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable2.getIntrinsicHeight());
        Sj().mapRect(rectF);
        boolean z = Math.abs(this._H.width() - rectF.width()) < 1.0f;
        boolean z2 = Math.abs(this._H.height() - rectF.height()) < 1.0f;
        if (!z || !z2 || Pj() != 0.0f) {
            return true;
        }
        return false;
    }

    public final void setCropRect(RectF rectF) {
        C3905oka.e(rectF, "overlayRect");
        this._H.set(rectF);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        Uj();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0198, code lost:
        if (r2 < r3) goto L_0x0192;
     */
    public final void setImageToWrapCropBounds(boolean z) {
        float f;
        isa();
        float f2 = Qj()[0];
        float f3 = Qj()[1];
        float Bg = Bg();
        float centerX = this._H.centerX() - f2;
        float centerY = this._H.centerY() - f3;
        this.aI.reset();
        this.aI.setTranslate(centerX, centerY);
        float[] Rj = Rj();
        float[] copyOf = Arrays.copyOf(Rj, Rj.length);
        C3905oka.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        this.aI.mapPoints(copyOf);
        this.aI.reset();
        this.aI.setRotate(-Pj());
        float[] copyOf2 = Arrays.copyOf(copyOf, copyOf.length);
        C3905oka.d(copyOf2, "java.util.Arrays.copyOf(this, size)");
        this.aI.mapPoints(copyOf2);
        float[] j = C1936XE.j(this._H);
        this.aI.mapPoints(j);
        if (C1936XE.d(copyOf2).contains(C1936XE.d(j))) {
            this.aI.reset();
            this.aI.setRotate(-Pj());
            float[] Rj2 = Rj();
            float[] copyOf3 = Arrays.copyOf(Rj2, Rj2.length);
            C3905oka.d(copyOf3, "java.util.Arrays.copyOf(this, size)");
            float[] j2 = C1936XE.j(this._H);
            this.aI.mapPoints(copyOf3);
            this.aI.mapPoints(j2);
            RectF d = C1936XE.d(copyOf3);
            RectF d2 = C1936XE.d(j2);
            float f4 = d.left - d2.left;
            float f5 = d.top - d2.top;
            float f6 = d.right - d2.right;
            float f7 = d.bottom - d2.bottom;
            float[] fArr = new float[4];
            float f8 = (float) 0;
            if (f4 <= f8) {
                f4 = 0.0f;
            }
            fArr[0] = f4;
            if (f5 <= f8) {
                f5 = 0.0f;
            }
            fArr[1] = f5;
            if (f6 >= f8) {
                f6 = 0.0f;
            }
            fArr[2] = f6;
            if (f7 >= f8) {
                f7 = 0.0f;
            }
            fArr[3] = f7;
            this.aI.reset();
            this.aI.setRotate(Pj());
            this.aI.mapPoints(fArr);
            centerX = -(fArr[0] + fArr[2]);
            centerY = -(fArr[1] + fArr[3]);
            f = this.maxScale;
            if (Bg <= f) {
                f = this.minScale;
                if (Bg >= f) {
                    f = Bg;
                }
            }
        } else {
            RectF rectF = new RectF(this._H);
            this.aI.reset();
            this.aI.setRotate(Pj());
            this.aI.mapRect(rectF);
            float[] Rj3 = Rj();
            float[] fArr2 = {(float) Math.sqrt(Math.pow((double) (Rj3[1] - Rj3[3]), 2.0d) + Math.pow((double) (Rj3[0] - Rj3[2]), 2.0d)), (float) Math.sqrt(Math.pow((double) (Rj3[3] - Rj3[5]), 2.0d) + Math.pow((double) (Rj3[2] - Rj3[4]), 2.0d))};
            f = ((Math.max(rectF.width() / fArr2[0], rectF.height() / fArr2[1]) * Bg) - Bg) + Bg;
            float f9 = this.maxScale;
            if (f <= f9) {
                f9 = this.minScale;
            }
            f = f9;
        }
        if (z) {
            Matrix matrix = new Matrix(Sj());
            matrix.postTranslate(centerX, centerY);
            float f10 = f / Bg;
            matrix.postScale(f10, f10, this._H.centerX(), this._H.centerY());
            a(Sj(), matrix);
            return;
        }
        postTranslate(centerX, centerY);
        postScale(f / Bg, this._H.centerX(), this._H.centerY());
    }

    public final void setInitialCropOriginalTypeRectBoundary() {
        if (getDrawable() != null) {
            this.cI.set(this._H);
            Drawable drawable = getDrawable();
            C3905oka.d(drawable, "drawable");
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            Drawable drawable2 = getDrawable();
            C3905oka.d(drawable2, "drawable");
            float intrinsicHeight = (float) drawable2.getIntrinsicHeight();
            float max = Math.max(this._H.width() / intrinsicWidth, this._H.height() / intrinsicHeight);
            Matrix matrix = new Matrix();
            float f = 0.0f;
            RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            float f2 = (float) 2;
            matrix.postScale(max, max, intrinsicWidth / f2, intrinsicHeight / f2);
            matrix.mapRect(rectF);
            float f3 = rectF.left;
            float width = ((((float) getWidth()) - rectF.width()) / f2) + (f3 != 0.0f ? (f3 * ((float) -1)) + 0.0f : 0.0f);
            float f4 = rectF.top;
            if (f4 != 0.0f) {
                f = 0.0f + (f4 * ((float) -1));
            }
            matrix.postTranslate(width, ((((float) getHeight()) - rectF.height()) / f2) + f);
            this.minScale = max;
            this.maxScale = this.minScale * 10.0f;
            setImageMatrix(matrix);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._H = new RectF();
        this.aI = new Matrix();
        this.cI = new RectF();
    }

    public final void a(int i, RectF rectF) {
        C3905oka.e(rectF, "overlayRect");
        isa();
        float Pj = Pj();
        this.aI.set(Sj());
        this.aI.postRotate((-Pj) + ((float) i), this._H.centerX(), this._H.centerY());
        float[] Rj = Rj();
        float[] copyOf = Arrays.copyOf(Rj, Rj.length);
        C3905oka.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        this.aI.mapPoints(copyOf, Tj());
        float width = rectF.width() / this._H.height();
        float height = rectF.height() / this._H.width();
        this.aI.postScale(width, height, this._H.centerX(), this._H.centerY());
        this._H.set(rectF);
        this.minScale = Math.max(width, height) * this.minScale;
        this.maxScale = this.minScale * 10.0f;
        setImageMatrix(this.aI);
    }

    public final void a(com.excalibur.funwithgles.cropimage.b612crop.b bVar) {
        C3905oka.e(bVar, "cropType");
        RectF Vj = Vj();
        if (Vj().width() / Vj().height() > this._H.width() / this._H.height()) {
            this.minScale = (bVar == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE ? this.cI : this._H).height() / (Vj.height() / Bg());
            this.maxScale = this.minScale * 10.0f;
            return;
        }
        this.minScale = (bVar == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE ? this.cI : this._H).width() / (Vj.width() / Bg());
        this.maxScale = this.minScale * 10.0f;
    }

    public final void a(float f, float f2, float f3, PointF pointF) {
        float f4;
        C3905oka.e(pointF, "transPoint");
        float Bg = Bg();
        float f5 = Bg * f;
        float f6 = this.maxScale;
        if (f5 <= f6) {
            f6 = this.minScale;
            if (f5 >= f6) {
                f4 = f < 1.0f ? 1.0f : f;
                if (f4 == 1.0f || pointF.x != 0.0f || pointF.y != 0.0f) {
                    Matrix matrix = new Matrix(Sj());
                    matrix.postScale(f4, f4, f2, f3);
                    matrix.postTranslate(pointF.x, pointF.y);
                    a(Sj(), matrix);
                }
                return;
            }
        }
        f4 = f6 / Bg;
        if (f4 == 1.0f) {
        }
        Matrix matrix2 = new Matrix(Sj());
        matrix2.postScale(f4, f4, f2, f3);
        matrix2.postTranslate(pointF.x, pointF.y);
        a(Sj(), matrix2);
    }
}