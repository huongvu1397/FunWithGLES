package com.excalibur.funwithgles.cropimage.b612crop.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.excalibur.funwithgles.R;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C1936XE;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3717kka;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C4081sY;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C4374yja;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.Ff;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.Gka;

import java.util.HashMap;
import java.util.Map;

public final class CropOverlayView extends View {
    private static final int EO = C4081sY.Ya(15.0f);
    private static final int FO = EO;
    private static final int GO = C4081sY.Ya(15.0f);
    private static final int HO = GO;
    private static final float IO = C4081sY.Za(6.0f);
    private static final int JO = C1936XE.getColor(R.color.amber);
    private float KO;
    private com.excalibur.funwithgles.cropimage.b612crop.b LO;
    private com.excalibur.funwithgles.cropimage.b612crop.b MO;
    private final RectF OO;
    private final Paint PO;
    private final Paint QO;
    /* access modifiers changed from: private */
    public final Paint RO;
    private final RectF SO;
    private final RectF TO;
    private final HashMap<a, RectF> UO;
    private boolean VO;
    private float WO;
    private float XO;
    private float YO;
    private float ZO;
    private final PointF _O;
    private boolean aP;
    private boolean bP;
    private a cP;
    private final Paint clearPaint;
    private int dP;
    private final PointF eP;
    public b fI;
    private boolean fP;
    private ValueAnimator gP;
    /* access modifiers changed from: private */
    public c hP;

    public enum a {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT;

        public static C0031a Companion = null;

        /* renamed from: com.linecorp.b612.android.activity.edit.feature.crop.view.CropOverlayView$a$a  reason: collision with other inner class name */
        public static final class C0031a {
            public /* synthetic */ C0031a(C3717kka kka) {
            }

            public final a a(a aVar) {
                C3905oka.e(aVar, "overlayMarkerType");
                int i = com.excalibur.funwithgles.cropimage.b612crop.view.a.$EnumSwitchMapping$0[aVar.ordinal()];
                if (i == 1) {
                    return a.BOTTOM_RIGHT;
                }
                if (i == 2) {
                    return a.BOTTOM_LEFT;
                }
                if (i == 3) {
                    return a.TOP_RIGHT;
                }
                if (i == 4) {
                    return a.TOP_LEFT;
                }
                throw new C4374yja();
            }
        }

        static {
            Companion = new C0031a((C3717kka) null);
        }
    }

    public interface b {
    }

    private final class c implements Runnable {
        private final RectF OO;
        private final PointF dHc;
        final /* synthetic */ CropOverlayView this$0;

        public c(CropOverlayView cropOverlayView, RectF rectF, PointF pointF) {
            C3905oka.e(rectF, "overlayRect");
            C3905oka.e(pointF, "scalePivot");
            this.this$0 = cropOverlayView;
            this.OO = rectF;
            this.dHc = pointF;
        }

        public void run() {
            ((i) this.this$0.zk()).a(this.OO, this.dHc);
            this.this$0.Psa();
            this.this$0.hP = null;
        }
    }

    public CropOverlayView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private final a J(float f, float f2) {
        for (Map.Entry next : this.UO.entrySet()) {
            if (((RectF) next.getValue()).contains(f, f2)) {
                return (a) next.getKey();
            }
        }
        return null;
    }

    private final float Nsa() {
        float width;
        float height;
        com.excalibur.funwithgles.cropimage.b612crop.b bVar = this.MO;
        if (bVar == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_ORIGINAL) {
            return this.KO;
        }
        if (bVar == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE || bVar == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE_REVERSE) {
            if (this.LO == this.MO.Lia()) {
                width = (float) 1;
                height = this.OO.width() / this.OO.height();
            } else {
                width = this.OO.width();
                height = this.OO.height();
            }
        } else if (bVar != com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_ORIGINAL_REVERSE) {
            return bVar.getRatio();
        } else {
            width = (float) 1;
            height = this.KO;
        }
        return width / height;
    }

    private final void Osa() {
        int i;
        int i2;
        if (getWidth() == 0 || getHeight() == 0) {
            this.VO = false;
            return;
        }
        float Nsa = Nsa();
        if (((float) getWidth()) / ((float) getHeight()) < Nsa) {
            int width = (getWidth() - EO) - FO;
            int i3 = width;
            i = (int) (((float) width) / Nsa);
            i2 = i3;
        } else {
            i = (getHeight() - GO) - HO;
            i2 = (int) (((float) i) * Nsa);
        }
        this.OO.left = ((float) (getWidth() - i2)) / 2.0f;
        RectF rectF = this.OO;
        rectF.right = rectF.left + ((float) i2);
        rectF.top = ((float) (getHeight() - i)) / 2.0f;
        RectF rectF2 = this.OO;
        rectF2.bottom = rectF2.top + ((float) i);
        com.excalibur.funwithgles.cropimage.b612crop.b bVar = this.MO;
        if (bVar == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE || bVar == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE_REVERSE) {
            this.WO = (float) ((getWidth() - EO) - FO);
            int height = getHeight();
            int i4 = GO;
            this.XO = (float) ((height - i4) - HO);
            float f = this.WO;
            this.YO = f / 5.0f;
            float f2 = this.XO;
            this.ZO = f2 / 5.0f;
            RectF rectF3 = this.SO;
            rectF3.left = (float) EO;
            rectF3.right = rectF3.left + f;
            rectF3.top = (float) i4;
            rectF3.bottom = rectF3.top + f2;
            return;
        }
        this.WO = rectF2.width();
        this.XO = this.OO.height();
        this.YO = this.WO / 5.0f;
        this.ZO = this.XO / 5.0f;
        this.SO.set(this.OO);
    }

    /* access modifiers changed from: private */
    public final void Psa() {
        ValueAnimator valueAnimator = this.gP;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.gP = ValueAnimator.ofInt(new int[]{this.RO.getAlpha(), 0});
        ValueAnimator valueAnimator2 = this.gP;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(Gka.kb((((float) this.RO.getAlpha()) / ((float) 102)) * ((float) 200)));
            ValueAnimator valueAnimator3 = this.gP;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(new d(this));
                ValueAnimator valueAnimator4 = this.gP;
                if (valueAnimator4 != null) {
                    valueAnimator4.start();
                } else {
                    C3905oka.ema();
                    throw null;
                }
            } else {
                C3905oka.ema();
                throw null;
            }
        } else {
            C3905oka.ema();
            throw null;
        }
    }

    private final void Qsa() {
        ValueAnimator valueAnimator = this.gP;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.gP = ValueAnimator.ofInt(new int[]{this.RO.getAlpha(), 102});
        ValueAnimator valueAnimator2 = this.gP;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(Gka.kb((((float) 1) - (((float) this.RO.getAlpha()) / ((float) 102))) * ((float) 200)));
            ValueAnimator valueAnimator3 = this.gP;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(new e(this));
                ValueAnimator valueAnimator4 = this.gP;
                if (valueAnimator4 != null) {
                    valueAnimator4.start();
                } else {
                    C3905oka.ema();
                    throw null;
                }
            } else {
                C3905oka.ema();
                throw null;
            }
        } else {
            C3905oka.ema();
            throw null;
        }
    }

    public final void Ak() {
        this.hP = new c(this, this.OO, this.eP);
        postDelayed(this.hP, 1000);
    }

    public final void d(RectF rectF) {
        C3905oka.e(rectF, "imageRect");
        this.TO.set(rectF);
    }

    public final com.excalibur.funwithgles.cropimage.b612crop.b kh() {
        return this.MO;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C3905oka.e(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawColor(JO);
        canvas.drawRect(this.OO, this.clearPaint);
        canvas.drawRect(this.OO, this.PO);
        RectF rectF = this.OO;
        this.UO.clear();
        float f = IO;
        float f2 = 3.0f * f;
        float f3 = rectF.left;
        float f4 = rectF.top;
        canvas.drawCircle(f3, f4, f, this.QO);
        this.UO.put(a.TOP_LEFT, new RectF(f3 - f2, f4 - f2, f3 + f2, f4 + f2));
        float f5 = rectF.right;
        float f6 = rectF.top;
        canvas.drawCircle(f5, f6, IO, this.QO);
        this.UO.put(a.TOP_RIGHT, new RectF(f5 - f2, f6 - f2, f5 + f2, f6 + f2));
        float f7 = rectF.left;
        float f8 = rectF.bottom;
        canvas.drawCircle(f7, f8, IO, this.QO);
        this.UO.put(a.BOTTOM_LEFT, new RectF(f7 - f2, f8 - f2, f7 + f2, f8 + f2));
        float f9 = rectF.right;
        float f10 = rectF.bottom;
        canvas.drawCircle(f9, f10, IO, this.QO);
        this.UO.put(a.BOTTOM_RIGHT, new RectF(f9 - f2, f10 - f2, f9 + f2, f10 + f2));
        if (this.RO.getAlpha() > 0) {
            float height = this.OO.height() / ((float) this.dP);
            for (int i = 1; i < this.dP; i++) {
                float f11 = ((float) i) * height;
                float f12 = (float) 2;
                float strokeWidth = (this.OO.top + f11) - (this.RO.getStrokeWidth() / f12);
                float strokeWidth2 = (this.RO.getStrokeWidth() / f12) + this.OO.top + f11;
                RectF rectF2 = this.OO;
                canvas.drawLine(rectF2.left, strokeWidth, rectF2.right, strokeWidth2, this.RO);
            }
            float width = this.OO.width() / ((float) this.dP);
            for (int i2 = 1; i2 < this.dP; i2++) {
                float f13 = ((float) i2) * width;
                float f14 = (float) 2;
                float strokeWidth3 = (this.OO.left + f13) - (this.RO.getStrokeWidth() / f14);
                float strokeWidth4 = (this.RO.getStrokeWidth() / f14) + this.OO.left + f13;
                RectF rectF3 = this.OO;
                canvas.drawLine(strokeWidth3, rectF3.top, strokeWidth4, rectF3.bottom, this.RO);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.VO) {
            Osa();
            this.VO = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PointF pointF;
        C3905oka.e(motionEvent, "event");
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked == 0) {
            this.fP = false;
            this.cP = J(motionEvent.getX(), motionEvent.getY());
            if (this.cP != null) {
                z = true;
            }
            this.aP = z;
            this._O.set(motionEvent.getX(), motionEvent.getY());
            if (this.aP) {
                c cVar = this.hP;
                if (cVar != null) {
                    removeCallbacks(cVar);
                }
                b bVar = this.fI;
                if (bVar != null) {
                    ((i) bVar).g(this.OO);
                    Qsa();
                    this.dP = 3;
                } else {
                    C3905oka.Pf("touchCallback");
                    throw null;
                }
            }
            return this.aP;
        } else if (actionMasked == 1) {
            boolean z2 = this.aP;
            a aVar = this.cP;
            if (aVar != null) {
                int i = com.excalibur.funwithgles.cropimage.b612crop.view.b.$EnumSwitchMapping$0[aVar.ordinal()];
                if (i == 1) {
                    PointF pointF2 = this.eP;
                    RectF rectF = this.OO;
                    pointF2.set(rectF.right, rectF.bottom);
                } else if (i == 2) {
                    PointF pointF3 = this.eP;
                    RectF rectF2 = this.OO;
                    pointF3.set(rectF2.left, rectF2.bottom);
                } else if (i == 3) {
                    PointF pointF4 = this.eP;
                    RectF rectF3 = this.OO;
                    pointF4.set(rectF3.right, rectF3.top);
                } else if (i == 4) {
                    PointF pointF5 = this.eP;
                    RectF rectF4 = this.OO;
                    pointF5.set(rectF4.left, rectF4.top);
                }
            }
            this.hP = new c(this, this.OO, this.eP);
            postDelayed(this.hP, 1000);
            this.cP = null;
            this.aP = false;
            return z2;
        } else if (actionMasked == 2) {
            if (!this.fP) {
                float x = motionEvent.getX() - this._O.x;
                float y = motionEvent.getY() - this._O.y;
                int i2 = com.excalibur.funwithgles.cropimage.b612crop.view.b.fHc[this.MO.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    pointF = new PointF(x, y);
                } else {
                    if (Math.abs(x) > Math.abs(y)) {
                        a aVar2 = this.cP;
                        y = ((aVar2 == a.TOP_RIGHT || aVar2 == a.BOTTOM_LEFT) ? ((float) -1) * x : x) / Nsa();
                    } else {
                        a aVar3 = this.cP;
                        x = ((aVar3 == a.TOP_RIGHT || aVar3 == a.BOTTOM_LEFT) ? ((float) -1) * y : y) * Nsa();
                    }
                    pointF = new PointF(x, y);
                }
                RectF rectF5 = this.OO;
                RectF rectF6 = new RectF(rectF5);
                a aVar4 = this.cP;
                if (aVar4 != null) {
                    int i3 = com.excalibur.funwithgles.cropimage.b612crop.view.b.gHc[aVar4.ordinal()];
                    if (i3 == 1) {
                        float f = rectF6.left + pointF.x;
                        float f2 = rectF6.top + pointF.y;
                        float f3 = rectF6.right - f;
                        float f4 = rectF6.bottom - f2;
                        com.excalibur.funwithgles.cropimage.b612crop.b bVar2 = this.MO;
                        if (bVar2 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE || bVar2 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE_REVERSE) {
                            float f5 = this.TO.left;
                            float f6 = this.SO.left;
                            if (f5 <= f6) {
                                f5 = f6;
                            }
                            float f7 = this.TO.top;
                            float f8 = this.SO.top;
                            if (f7 <= f8) {
                                f7 = f8;
                            }
                            if (f <= f5) {
                                pointF.x = f5 - rectF6.left;
                            } else {
                                float f9 = this.YO;
                                if (f3 <= f9) {
                                    pointF.x = (rectF6.right - rectF6.left) - f9;
                                }
                            }
                            if (f2 <= f7) {
                                pointF.y = f7 - rectF6.top;
                            } else {
                                float f10 = this.ZO;
                                if (f4 <= f10) {
                                    pointF.y = (rectF6.bottom - rectF6.top) - f10;
                                }
                            }
                        } else {
                            float Nsa = Nsa();
                            RectF rectF7 = this.TO;
                            float f11 = rectF7.left;
                            if (f <= f11) {
                                pointF.x = f11 - rectF6.left;
                                pointF.y = pointF.x / Nsa;
                            } else {
                                RectF rectF8 = this.SO;
                                float f12 = rectF8.left;
                                if (f <= f12) {
                                    pointF.x = f12 - rectF6.left;
                                    pointF.y = pointF.x / Nsa;
                                } else {
                                    float f13 = this.YO;
                                    if (f3 <= f13) {
                                        pointF.x = (rectF6.right - rectF6.left) - f13;
                                        pointF.y = pointF.x / Nsa;
                                    } else {
                                        float f14 = this.WO;
                                        if (f3 >= f14) {
                                            pointF.x = (rectF6.right - rectF6.left) - f14;
                                            pointF.y = pointF.x / Nsa;
                                        } else {
                                            float f15 = rectF7.top;
                                            if (f2 <= f15) {
                                                pointF.y = f15 - rectF6.top;
                                                pointF.x = pointF.y * Nsa;
                                            } else {
                                                float f16 = rectF8.top;
                                                if (f2 <= f16) {
                                                    pointF.y = f16 - rectF6.top;
                                                    pointF.x = pointF.y * Nsa;
                                                } else {
                                                    float f17 = this.ZO;
                                                    if (f4 <= f17) {
                                                        pointF.y = (rectF6.bottom - rectF6.top) - f17;
                                                        pointF.x = pointF.y * Nsa;
                                                    } else {
                                                        float f18 = this.XO;
                                                        if (f4 >= f18) {
                                                            pointF.y = (rectF6.bottom - rectF6.top) - f18;
                                                            pointF.x = pointF.y * Nsa;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        rectF6.left += pointF.x;
                        rectF6.top += pointF.y;
                    } else if (i3 == 2) {
                        float f19 = rectF6.right + pointF.x;
                        float f20 = rectF6.top + pointF.y;
                        float f21 = f19 - rectF6.left;
                        float f22 = rectF6.bottom - f20;
                        com.excalibur.funwithgles.cropimage.b612crop.b bVar3 = this.MO;
                        if (bVar3 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE || bVar3 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE_REVERSE) {
                            float f23 = this.TO.right;
                            float f24 = this.SO.right;
                            if (f23 >= f24) {
                                f23 = f24;
                            }
                            float f25 = this.TO.top;
                            float f26 = this.SO.top;
                            if (f25 <= f26) {
                                f25 = f26;
                            }
                            if (f19 >= f23) {
                                pointF.x = f23 - rectF6.right;
                            } else {
                                float f27 = this.YO;
                                if (f21 <= f27) {
                                    pointF.x = f27 - (rectF6.right - rectF6.left);
                                }
                            }
                            if (f20 <= f25) {
                                pointF.y = f25 - rectF6.top;
                            } else {
                                float f28 = this.ZO;
                                if (f22 <= f28) {
                                    pointF.y = (rectF6.bottom - rectF6.top) - f28;
                                }
                            }
                        } else {
                            float Nsa2 = Nsa();
                            RectF rectF9 = this.TO;
                            float f29 = rectF9.right;
                            if (f19 >= f29) {
                                pointF.x = f29 - rectF6.right;
                                pointF.y = (Math.abs(pointF.x) / Nsa2) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                            } else {
                                RectF rectF10 = this.SO;
                                float f30 = rectF10.right;
                                if (f19 >= f30) {
                                    pointF.x = f30 - rectF6.right;
                                    pointF.y = (Math.abs(pointF.x) / Nsa2) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                } else {
                                    float f31 = this.YO;
                                    if (f21 <= f31) {
                                        pointF.x = f31 - (rectF6.right - rectF6.left);
                                        pointF.y = (Math.abs(pointF.x) / Nsa2) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                    } else {
                                        float f32 = this.WO;
                                        if (f21 >= f32) {
                                            pointF.x = f32 - (rectF6.right - rectF6.left);
                                            pointF.y = (Math.abs(pointF.x) / Nsa2) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                        } else {
                                            float f33 = rectF9.top;
                                            if (f20 <= f33) {
                                                pointF.y = f33 - rectF6.top;
                                                pointF.x = Math.abs(pointF.y) * Nsa2 * (pointF.x < ((float) 0) ? -1.0f : 1.0f);
                                            } else {
                                                float f34 = rectF10.top;
                                                if (f20 <= f34) {
                                                    pointF.y = f34 - rectF6.top;
                                                    pointF.x = Math.abs(pointF.y) * Nsa2 * (pointF.x < ((float) 0) ? -1.0f : 1.0f);
                                                } else {
                                                    float f35 = this.ZO;
                                                    if (f22 <= f35) {
                                                        pointF.y = (rectF6.bottom - rectF6.top) - f35;
                                                        pointF.x = Math.abs(pointF.y) * Nsa2 * (pointF.x < ((float) 0) ? -1.0f : 1.0f);
                                                    } else {
                                                        float f36 = this.XO;
                                                        if (f22 >= f36) {
                                                            pointF.y = (rectF6.bottom - rectF6.top) - f36;
                                                            pointF.x = Math.abs(pointF.y) * Nsa2 * (pointF.x < ((float) 0) ? -1.0f : 1.0f);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        rectF6.right += pointF.x;
                        rectF6.top += pointF.y;
                    } else if (i3 == 3) {
                        float f37 = rectF6.left + pointF.x;
                        float f38 = rectF6.bottom + pointF.y;
                        float f39 = rectF6.right - f37;
                        float f40 = f38 - rectF6.top;
                        com.excalibur.funwithgles.cropimage.b612crop.b bVar4 = this.MO;
                        if (bVar4 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE || bVar4 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE_REVERSE) {
                            float f41 = this.TO.left;
                            float f42 = this.SO.left;
                            if (f41 <= f42) {
                                f41 = f42;
                            }
                            float f43 = this.TO.bottom;
                            float f44 = this.SO.bottom;
                            if (f43 >= f44) {
                                f43 = f44;
                            }
                            if (f37 <= f41) {
                                pointF.x = f41 - rectF6.left;
                            } else {
                                float f45 = this.YO;
                                if (f39 <= f45) {
                                    pointF.x = (rectF6.right - rectF6.left) - f45;
                                }
                            }
                            if (f38 >= f43) {
                                pointF.y = f43 - rectF6.bottom;
                            } else {
                                float f46 = this.ZO;
                                if (f40 <= f46) {
                                    pointF.y = f46 - (rectF6.bottom - rectF6.top);
                                }
                            }
                        } else {
                            float Nsa3 = Nsa();
                            RectF rectF11 = this.TO;
                            float f47 = rectF11.left;
                            if (f37 <= f47) {
                                pointF.x = f47 - rectF6.left;
                                pointF.y = (Math.abs(pointF.x) / Nsa3) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                            } else {
                                RectF rectF12 = this.SO;
                                float f48 = rectF12.left;
                                if (f37 <= f48) {
                                    pointF.x = f48 - rectF6.left;
                                    pointF.y = (Math.abs(pointF.x) / Nsa3) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                } else {
                                    float f49 = this.YO;
                                    if (f39 <= f49) {
                                        pointF.x = (rectF6.right - rectF6.left) - f49;
                                        pointF.y = (Math.abs(pointF.x) / Nsa3) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                    } else {
                                        float f50 = this.WO;
                                        if (f39 >= f50) {
                                            pointF.x = (rectF6.right - rectF6.left) - f50;
                                            pointF.y = (Math.abs(pointF.x) / Nsa3) * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                        } else {
                                            float f51 = rectF11.bottom;
                                            if (f38 >= f51) {
                                                pointF.y = f51 - rectF6.bottom;
                                                pointF.x = Math.abs(pointF.y) * Nsa3 * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                            } else {
                                                float f52 = rectF12.bottom;
                                                if (f38 >= f52) {
                                                    pointF.y = f52 - rectF6.bottom;
                                                    pointF.x = Math.abs(pointF.y) * Nsa3 * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                                } else {
                                                    float f53 = this.ZO;
                                                    if (f40 <= f53) {
                                                        pointF.y = f53 - (rectF6.bottom - rectF6.top);
                                                        pointF.x = Math.abs(pointF.y) * Nsa3 * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                                    } else {
                                                        float f54 = this.XO;
                                                        if (f40 >= f54) {
                                                            pointF.y = f54 - (rectF6.bottom - rectF6.top);
                                                            pointF.x = Math.abs(pointF.y) * Nsa3 * (pointF.y < ((float) 0) ? -1.0f : 1.0f);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        rectF6.left += pointF.x;
                        rectF6.bottom += pointF.y;
                    } else if (i3 == 4) {
                        float f55 = rectF6.right + pointF.x;
                        float f56 = rectF6.bottom + pointF.y;
                        float f57 = f55 - rectF6.left;
                        float f58 = f56 - rectF6.top;
                        com.excalibur.funwithgles.cropimage.b612crop.b bVar5 = this.MO;
                        if (bVar5 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE || bVar5 == com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_FREE_REVERSE) {
                            float f59 = this.TO.right;
                            float f60 = this.SO.right;
                            if (f59 >= f60) {
                                f59 = f60;
                            }
                            float f61 = this.TO.bottom;
                            float f62 = this.SO.bottom;
                            if (f61 >= f62) {
                                f61 = f62;
                            }
                            if (f55 >= f59) {
                                pointF.x = f59 - rectF6.right;
                            } else {
                                float f63 = this.YO;
                                if (f57 <= f63) {
                                    pointF.x = f63 - (rectF6.right - rectF6.left);
                                }
                            }
                            if (f56 >= f61) {
                                pointF.y = f61 - rectF6.bottom;
                            } else {
                                float f64 = this.ZO;
                                if (f58 <= f64) {
                                    pointF.y = f64 - (rectF6.bottom - rectF6.top);
                                }
                            }
                        } else {
                            float Nsa4 = Nsa();
                            RectF rectF13 = this.TO;
                            float f65 = rectF13.right;
                            if (f55 >= f65) {
                                pointF.x = f65 - rectF6.right;
                                pointF.y = pointF.x / Nsa4;
                            } else {
                                RectF rectF14 = this.SO;
                                float f66 = rectF14.right;
                                if (f55 >= f66) {
                                    pointF.x = f66 - rectF6.right;
                                    pointF.y = pointF.x / Nsa4;
                                } else {
                                    float f67 = this.YO;
                                    if (f57 <= f67) {
                                        pointF.x = f67 - (rectF6.right - rectF6.left);
                                        pointF.y = pointF.x / Nsa4;
                                    } else {
                                        float f68 = this.WO;
                                        if (f57 >= f68) {
                                            pointF.x = f68 - (rectF6.right - rectF6.left);
                                            pointF.y = pointF.x / Nsa4;
                                        } else {
                                            float f69 = rectF13.bottom;
                                            if (f56 >= f69) {
                                                pointF.y = f69 - rectF6.bottom;
                                                pointF.x = pointF.y * Nsa4;
                                            } else {
                                                float f70 = rectF14.bottom;
                                                if (f56 >= f70) {
                                                    pointF.y = f70 - rectF6.bottom;
                                                    pointF.x = pointF.y * Nsa4;
                                                } else {
                                                    float f71 = this.ZO;
                                                    if (f58 <= f71) {
                                                        pointF.y = f71 - (rectF6.bottom - rectF6.top);
                                                        pointF.x = pointF.y * Nsa4;
                                                    } else {
                                                        float f72 = this.XO;
                                                        if (f58 >= f72) {
                                                            pointF.y = f72 - (rectF6.bottom - rectF6.top);
                                                            pointF.x = pointF.y * Nsa4;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        rectF6.right += pointF.x;
                        rectF6.bottom += pointF.y;
                    }
                }
                rectF5.set(rectF6);
                b bVar6 = this.fI;
                if (bVar6 != null) {
                    ((i) bVar6).h(this.OO);
                    this._O.set(motionEvent.getX(), motionEvent.getY());
                    invalidate();
                } else {
                    C3905oka.Pf("touchCallback");
                    throw null;
                }
            }
            return this.aP;
        } else if (actionMasked != 5) {
            return false;
        } else {
            this.fP = true;
            return true;
        }
    }

    public final void setCropImageInfoListener(CropImageView.a aVar) {
        C3905oka.e(aVar, "<set-?>");
    }

    public final void setCropType(com.excalibur.funwithgles.cropimage.b612crop.b bVar) {
        C3905oka.e(bVar, "value");
        this.LO = this.MO;
        this.MO = bVar;
        c cVar = this.hP;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
        this.RO.setAlpha(0);
        Osa();
        postInvalidate();
    }

    public final void setRotateHandle(boolean z) {
        if (this.bP != z) {
            this.bP = z;
            if (this.bP) {
                this.dP = 6;
                Qsa();
                return;
            }
            Psa();
        }
    }

    public final void setTargetAspectRatio(float f) {
        this.KO = f;
    }

    public final void setTouchCallback(b bVar) {
        C3905oka.e(bVar, "<set-?>");
        this.fI = bVar;
    }

    public final boolean xk() {
        c cVar = this.hP;
        if (cVar != null) {
            removeCallbacks(cVar);
        }
        return this.hP != null;
    }

    public final RectF yk() {
        return this.OO;
    }

    public final b zk() {
        b bVar = this.fI;
        if (bVar != null) {
            return bVar;
        }
        C3905oka.Pf("touchCallback");
        throw null;
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint("WrongConstant")
    public CropOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.excalibur.funwithgles.cropimage.b612crop.b bVar = com.excalibur.funwithgles.cropimage.b612crop.b.TYPE_ORIGINAL;
        this.LO = bVar;
        this.MO = bVar;
        this.OO = new RectF();
        this.PO = new Paint(1);
        this.QO = new Paint(1);
        this.clearPaint = new Paint(1);
        this.RO = new Paint(1);
        this.SO = new RectF();
        this.TO = new RectF();
        this.UO = new HashMap<>();
        this._O = new PointF();
        this.dP = 6;
        this.eP = new PointF();
        new Matrix();
        float[] fArr = new float[4];
        this.PO.setStyle(Paint.Style.STROKE);
        this.PO.setColor(-1);
        this.PO.setStrokeWidth(C4081sY.Za(2.0f));
        this.QO.setStyle(Paint.Style.FILL);
        this.QO.setColor(-1);
        this.clearPaint.setStyle(Paint.Style.FILL);
        this.clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayerType(2, (Paint) null);
        this.RO.setStyle(Paint.Style.STROKE);
        this.RO.setStrokeWidth(C4081sY.Za(1.0f));
        this.RO.setColor(Color.parseColor("#66FFFFFF"));
        this.RO.setAlpha(0);
    }

    public final void a(float f, PointF pointF, PointF pointF2, Animator.AnimatorListener animatorListener) {
        Ff.a((Object) pointF, "pivot", (Object) pointF2, "translatePoint", (Object) animatorListener, "listener");
        a J = J(pointF.x, pointF.y);
        if (J != null) {
            a a2 = a.Companion.a(J);
            RectF rectF = new RectF(this.OO);
            float width = (rectF.width() * f) - rectF.width();
            float height = (rectF.height() * f) - rectF.height();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            C3905oka.d(ofFloat, "animation");
            ofFloat.setDuration(200);
            ofFloat.addUpdateListener(new com.excalibur.funwithgles.cropimage.b612crop.view.c(width, height, a2, rectF, this, f, pointF2, animatorListener));
            ofFloat.addListener(animatorListener);
            ofFloat.start();
        }
    }

    public final PointF a(float f, PointF pointF) {
        C3905oka.e(pointF, "pivot");
        RectF rectF = new RectF(this.OO);
        PointF pointF2 = new PointF();
        a J = J(pointF.x, pointF.y);
        if (J != null) {
            a a2 = a.Companion.a(J);
            RectF rectF2 = new RectF(this.OO);
            float width = (rectF2.width() * f) - rectF2.width();
            float height = (rectF2.height() * f) - rectF2.height();
            int i = com.excalibur.funwithgles.cropimage.b612crop.view.b.eHc[a2.ordinal()];
            if (i == 1) {
                rectF.left = rectF2.left - width;
                rectF.top = rectF2.top - height;
            } else if (i == 2) {
                rectF.right = rectF2.right + width;
                rectF.top = rectF2.top - height;
            } else if (i == 3) {
                rectF.left = rectF2.left - width;
                rectF.bottom = rectF2.bottom + height;
            } else if (i == 4) {
                rectF.right = rectF2.right + width;
                rectF.bottom = rectF2.bottom + height;
            }
            float f2 = (float) 2;
            pointF2.set(((((float) getWidth()) - rectF.width()) / f2) - rectF.left, ((((float) getHeight()) - rectF.height()) / f2) - rectF.top);
        }
        return pointF2;
    }
}