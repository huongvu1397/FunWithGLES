package com.excalibur.funwithgles.catchpack;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GuideView extends RelativeLayout {

    View f15813a;

    View f15814b;

    View f15815c;

    View f15816d;
    GuideTextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    int j = 1;
    private int k = -1;

    public GuideView(Context context) {
        super(context);
        a();
    }

    public GuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public final void a(int i2) {
        this.k = -1;
        boolean a2 = a.a().a(i2);
        setBackgroundColor(Color.parseColor("#aa000000"));
        if (a2) {
            this.k = i2;
            setVisibility(View.VISIBLE);
            if (i2 == 0) {
                this.f15813a.setVisibility(View.VISIBLE);
                this.f.setVisibility(View.VISIBLE);
            } else if (i2 == 1) {
                this.f15816d.setVisibility(View.VISIBLE);
                this.h.setVisibility(View.VISIBLE);
            } else if (i2 == 2) {
                this.f15814b.setVisibility(View.VISIBLE);
                this.g.setVisibility(View.VISIBLE);
            } else if (i2 == 3) {
                this.f15815c.setVisibility(View.VISIBLE);
                this.i.setVisibility(View.VISIBLE);
            }
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        this.k = -1;
        boolean a2 = a.a().a(i2);
        setBackgroundColor(0);
        if (a2) {
            this.k = i2;
            setVisibility(View.VISIBLE);
            GuideTextView guideTextView = this.e;
            String string = p.f14732d.getString(i5);
            //a.b();
            guideTextView.e = 0;
            guideTextView.setVisibility(View.VISIBLE);
            guideTextView.f15808a = i3;
            guideTextView.f15809b = i4;
            guideTextView.f15810c = string;
            guideTextView.f15811d.start();
            guideTextView.invalidate();
        }
    }

    public void setpicnum(int i2) {
        this.j = i2;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 8 && this.k != -1) {
            a.a();
            String str = "touchscale";
            switch (this.k) {
                case 0:
                    str = "touchscale";
                    break;
                case 1:
                    str = "touchout";
                    break;
                case 2:
                    str = "longtouchswap";
                    break;
                case 3:
                    str = "longtouchmove";
                    break;
                case 4:
                    str = "musicinfo";
                    break;
                case 5:
                    str = "musicaddself";
                    break;
                case 6:
                    str = "pictran";
                    break;
                case 7:
                    str = "picfindmore";
                    break;
            }
            //a.a((Object) str);
            //p.f.putInt(str, 0);
            if (this.k == 1) {
                this.f15816d.setVisibility(View.GONE);
                this.h.setVisibility(View.GONE);
                a(3);
            } else if (this.k != 7 || this.j <= 1) {
                if (this.k == 0) {
                    this.f15813a.setVisibility(View.GONE);
                    this.f.setVisibility(View.GONE);
                } else if (this.k == 2) {
                    this.f15814b.setVisibility(View.GONE);
                    this.g.setVisibility(View.GONE);
                } else if (this.k == 3) {
                    this.f15815c.setVisibility(View.GONE);
                    this.i.setVisibility(View.GONE);
                } else {
                    this.e.setVisibility(View.GONE);
                }
                this.k = -1;
            } else {
                //a(6, p.a(280.0f), p.a(430.0f), b.g.guideaddtran);
            }
        }
    }

    private void a() {
//        ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(b.f.layout_guide, this, true);
//        View findViewById = findViewById(b.e.countrl);
//        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
//        layoutParams.height = (int) ((float) p.a());
//        findViewById.setLayoutParams(layoutParams);
//        setOnClickListener(new View.OnClickListener() {
//            public final void onClick(View view) {
//                GuideView.this.setVisibility(View.GONE);
//            }
//        });
//        this.e = (GuideTextView) findViewById(b.e.guidetext);
//        this.f15813a = findViewById(b.e.touchscale);
//        this.f = (TextView) findViewById(b.e.touchscaletv);
//        this.f.setTypeface(p.f14730b);
//        this.f.setText(p.f14732d.getString(b.g.guidetouchscale));
//        this.f15814b = findViewById(b.e.longtouchswap);
//        this.g = (TextView) findViewById(b.e.longtouchswaptv);
//        this.g.setTypeface(p.f14730b);
//        this.g.setText(p.f14732d.getString(b.g.guidelongtouchswap));
//        this.f15816d = findViewById(b.e.touchout);
//        this.h = (TextView) findViewById(b.e.touchouttv);
//        this.h.setTypeface(p.f14730b);
//        this.h.setText(p.f14732d.getString(b.g.guidetouchout));
//        this.f15815c = findViewById(b.e.longtouchmove);
//        this.i = (TextView) findViewById(b.e.longtouchmovetv);
//        this.i.setTypeface(p.f14730b);
//        this.i.setText(p.f14732d.getString(b.g.guidelongtouchmove));
    }
}