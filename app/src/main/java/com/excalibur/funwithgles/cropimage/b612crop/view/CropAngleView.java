package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C4081sY;

public final class CropAngleView extends View {
    private static final int lO = C4081sY.Ya(1.0f);
    private static final int mO = 13;
    private static final int nO = C4081sY.Ya(15.0f);
    private static final int oO = C4081sY.Ya(8.0f);
    private static final float pO = 0f;
    private static final float qO = 0f;
    private static final int rO = C4081sY.Ya(35.0f);
    private static final int sO = C4081sY.Ya(23.0f);
    private boolean AO;
    private int BO;
    private int CO;
    private a listener;
    private float startX;
    private final Paint tO = new Paint(1);
    private final TextPaint textPaint = new TextPaint(1);
    private final Paint uO = new Paint(1);
    private final RectF[] vO;
    private int wO;
    private float xO;
    private int yO;
    private final Rect zO;

    public interface a {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropAngleView(Context context) {
        super(context);
        C3905oka.e(context, "context");
        RectF[] rectFArr = new RectF[13];
        int length = rectFArr.length;
        for (int i = 0; i < length; i++) {
            rectFArr[i] = new RectF();
        }
        this.vO = rectFArr;
        this.zO = new Rect();
        this.tO.setColor(-1);
        this.tO.setStyle(Paint.Style.FILL);
        this.uO.setColor(Color.parseColor("#333333"));
        this.uO.setStyle(Paint.Style.FILL);
        this.textPaint.setColor(-1);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setTextSize(C4081sY.Za(12.0f));
    }

    private final void Lsa() {
        int i = this.wO;
        if (i < 0) {
            this.wO = 0;
        } else if (i > Msa()) {
            this.wO = Msa();
        }
    }

    private final int Msa() {
        return (getMeasuredWidth() - rO) - sO;
    }

    private final int Pj() {
        float Msa = ((float) this.wO) / ((float) Msa());
        float f = qO;
        return (int) (f - ((f - pO) * Msa));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        C3905oka.e(canvas2, "canvas");
        super.onDraw(canvas);
        Canvas canvas3 = canvas;
        canvas3.drawRect((float) rO, (float) this.CO, ((float) getWidth()) - ((float) sO), ((float) lO) + ((float) this.CO), this.uO);
        RectF[] rectFArr = this.vO;
        int length = rectFArr.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            RectF rectF = rectFArr[i2];
            int i3 = i + 1;
            float f = rectF.right;
            int i4 = this.wO;
            if (f - ((float) i4) >= ((float) rO) && rectF.left - ((float) i4) <= ((float) getWidth()) - ((float) sO)) {
                if (i == ((int) (((float) this.vO.length) / 2.0f))) {
                    float f2 = rectF.left;
                    int i5 = this.wO;
                    canvas.drawRect(f2 - ((float) i5), rectF.top, rectF.right - ((float) i5), rectF.bottom, this.tO);
                    if (this.AO) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(Pj());
                        sb.append(730);
                        String sb2 = sb.toString();
                        this.textPaint.getTextBounds(sb2, 0, sb2.length(), this.zO);
                        canvas2.drawText(sb2, (rectF.left - ((float) this.wO)) - ((float) (this.zO.width() / 2)), ((rectF.top - ((float) this.zO.height())) - ((float) oO)) - ((float) this.zO.top), this.textPaint);
                    }
                } else {
                    float f3 = rectF.left;
                    int i6 = this.wO;
                    canvas.drawRect(f3 - ((float) i6), rectF.top, rectF.right - ((float) i6), rectF.bottom, this.uO);
                }
            }
            i2++;
            i = i3;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.wO = Msa() / 2;
        float Msa = ((float) ((Msa() * 2) - lO)) / ((float) 12);
        RectF[] rectFArr = this.vO;
        int length = rectFArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            float f = ((float) i4) * Msa;
            rectFArr[i3].set(((float) rO) + f, (float) (getMeasuredHeight() - nO), f + ((float) lO) + ((float) rO), (float) getMeasuredHeight());
            i3++;
            i4 = i5;
        }
        this.CO = getMeasuredHeight() - ((nO / 2) - Math.max(1, lO / 2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C3905oka.e(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.yO = this.wO;
            this.startX = motionEvent.getX();
            this.AO = true;
            invalidate();
            return true;
        } else if (action == 1) {
            this.xO = motionEvent.getX();
            this.wO = this.yO + ((int) (this.startX - this.xO));
            Lsa();
            this.startX = this.xO;
            this.AO = false;
            invalidate();
            int Pj = Pj();
            a aVar = this.listener;
            if (aVar != null) {
                ((com.excalibur.funwithgles.cropimage.b612crop.g) aVar).i(Pj, Pj - this.BO, false);
            }
            this.BO = Pj;
            return true;
        } else if (action != 2) {
            this.AO = false;
            return super.onTouchEvent(motionEvent);
        } else {
            this.xO = motionEvent.getX();
            this.wO = this.yO + ((int) (this.startX - this.xO));
            Lsa();
            invalidate();
            int Pj2 = Pj();
            a aVar2 = this.listener;
            if (aVar2 != null) {
                ((com.excalibur.funwithgles.cropimage.b612crop.g) aVar2).i(Pj2, Pj2 - this.BO, true);
            }
            this.BO = Pj2;
            return true;
        }
    }

    public final void reset() {
        this.BO = 0;
        this.wO = Msa() / 2;
        invalidate();
    }

    public final void setListener(a aVar) {
        this.listener = aVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropAngleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C3905oka.e(context, "context");
        C3905oka.e(attributeSet, "attrs");
        RectF[] rectFArr = new RectF[13];
        int length = rectFArr.length;
        for (int i = 0; i < length; i++) {
            rectFArr[i] = new RectF();
        }
        this.vO = rectFArr;
        this.zO = new Rect();
        this.tO.setColor(-1);
        this.tO.setStyle(Paint.Style.FILL);
        this.uO.setColor(Color.parseColor("#333333"));
        this.uO.setStyle(Paint.Style.FILL);
        this.textPaint.setColor(-1);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setTextSize(C4081sY.Za(12.0f));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropAngleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C3905oka.e(context, "context");
        C3905oka.e(attributeSet, "attrs");
        RectF[] rectFArr = new RectF[13];
        int length = rectFArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            rectFArr[i2] = new RectF();
        }
        this.vO = rectFArr;
        this.zO = new Rect();
        this.tO.setColor(-1);
        this.tO.setStyle(Paint.Style.FILL);
        this.uO.setColor(Color.parseColor("#333333"));
        this.uO.setStyle(Paint.Style.FILL);
        this.textPaint.setColor(-1);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setTextSize(C4081sY.Za(12.0f));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropAngleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        C3905oka.e(context, "context");
        C3905oka.e(attributeSet, "attrs");
        RectF[] rectFArr = new RectF[13];
        int length = rectFArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            rectFArr[i3] = new RectF();
        }
        this.vO = rectFArr;
        this.zO = new Rect();
        this.tO.setColor(-1);
        this.tO.setStyle(Paint.Style.FILL);
        this.uO.setColor(Color.parseColor("#333333"));
        this.uO.setStyle(Paint.Style.FILL);
        this.textPaint.setColor(-1);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setTextSize(C4081sY.Za(12.0f));
    }
}