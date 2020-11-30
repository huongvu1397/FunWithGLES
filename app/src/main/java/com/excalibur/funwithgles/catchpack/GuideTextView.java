package com.excalibur.funwithgles.catchpack;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class GuideTextView extends View {

    /* renamed from: a  reason: collision with root package name */
    int f15808a;

    /* renamed from: b  reason: collision with root package name */
    int f15809b;

    /* renamed from: c  reason: collision with root package name */
    String f15810c;

    /* renamed from: d  reason: collision with root package name */
    ValueAnimator f15811d;
    int e = 0;
    private Paint f;
    private int g;
    private float h = -1.0f;
    private int i = -256;

    public GuideTextView(Context context) {
        super(context);
        a();
    }

    public GuideTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GuideTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f = new Paint();
        this.f.setAntiAlias(true);
        this.f.setTypeface(p.f14731c);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setStrokeWidth(p.f14729a * 2.0f);
        this.f.setTextSize((float) p.a(14.0f));
        this.f.setTextAlign(Paint.Align.CENTER);
        this.g = p.a(2.0f);
        this.i = Color.parseColor("#F0CB1C");
        this.f15811d = new ValueAnimator();
        this.f15811d.setIntValues(new int[]{-40, 255});
        this.f15811d.setDuration(500);
        this.f15811d.setRepeatCount(0);
        this.f15811d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuideTextView.this.postInvalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.f15810c)) {
            if (this.f == null) {
                this.f = new Paint();
                this.f.setAntiAlias(true);
            }
            this.e = ((Integer) this.f15811d.getAnimatedValue()).intValue();
            this.e = Math.max(0, this.e);
            this.f.setColor(this.i);
            this.f.setAlpha(this.e);
            canvas.drawCircle((float) this.f15808a, (float) this.f15809b, (float) p.a(5.0f), this.f);
            float f2 = ((float) this.f15809b) - (p.f14729a * 80.0f);
            canvas.drawLine((float) this.f15808a, (float) this.f15809b, (float) this.f15808a, f2, this.f);
            float measureText = this.f.measureText(this.f15810c);
            RectF rectF = new RectF();
            float f3 = measureText / 2.0f;
            rectF.left = ((float) this.f15808a) - ((p.f14729a * 15.0f) + f3);
            rectF.right = ((float) this.f15808a) + f3 + (p.f14729a * 15.0f);
            rectF.top = f2 - (p.f14729a * 20.0f);
            rectF.bottom = (p.f14729a * 20.0f) + f2;
            canvas.drawRoundRect(rectF, (float) this.g, (float) this.g, this.f);
            this.f.setColor(-16777216);
            this.f.setAlpha(this.e);
            if (this.h == -1.0f) {
                Paint.FontMetrics fontMetrics = this.f.getFontMetrics();
                this.h = ((-fontMetrics.top) / 2.0f) - (fontMetrics.bottom / 2.0f);
            }
            canvas.drawText(this.f15810c, (float) this.f15808a, f2 + this.h, this.f);
        }
    }
}