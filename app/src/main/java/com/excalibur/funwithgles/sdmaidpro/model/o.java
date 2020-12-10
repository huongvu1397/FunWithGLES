package com.excalibur.funwithgles.sdmaidpro.model;

import android.content.Context;

public class o {
    public final int a;
    public final int b;
    public final String c;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public final bEnum f671e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public static class a {
        public final Context a;
        public boolean b = false;
        public int c = 0;
        public int d = 0;

        /* renamed from: e  reason: collision with root package name */
        public String f672e = null;
        public String f = null;
        public bEnum g = bEnum.NONE;
        public boolean h = true;
        public boolean i = true;

        public a(Context context) {
            this.a = context;
        }

        public a a(int i2) {
            this.c = i2;
            a(bEnum.DETERMINATE);
            return this;
        }

        public a a(int i2, int i3) {
            if (i3 == 0) {
                a(bEnum.DETERMINATE);
                return this;
            }
            a((int) Math.ceil((double) ((((float) i2) / ((float) i3)) * 100.0f)));
            b(100);
            return this;
        }

        public a a(bEnum bVar) {
            if (bVar == bEnum.INDETERMINATE) {
                this.c = 0;
                this.d = 0;
            }
            this.g = bVar;
            return this;
        }

        public a b(int i2) {
            this.d = i2;
            a(bEnum.DETERMINATE);
            return this;
        }

        public a c(int i2) {
            this.f672e = this.a.getString(i2);
            return this;
        }
    }

    public enum bEnum {
        NONE,
        INDETERMINATE,
        DETERMINATE
    }

    public o(a aVar) {
        this.g = aVar.b;
        this.a = aVar.c;
        this.b = aVar.d;
        this.c = aVar.f672e;
        this.d = aVar.f;
        this.f671e = aVar.g;
        this.f = aVar.h;
        this.h = aVar.i;
    }

    public String toString() {
        StringBuilder a2 = com.excalibur.funwithgles.sdmaidpro.e0.b.b.a.a.a("WorkerStatus(isWorking=");
        a2.append(this.g);
        a2.append(", primary='");
        a2.append(this.c);
        a2.append("', secondary='");
        a2.append(this.d);
        a2.append("', progress=[");
        a2.append(this.a);
        a2.append("/");
        a2.append(this.b);
        a2.append("], isCancelable=");
        a2.append(this.f);
        a2.append(", progressType=");
        a2.append(this.f671e);
        a2.append(", isNewWorker=");
        a2.append(this.h);
        a2.append(")");
        return a2.toString();
    }
}