package com.excalibur.funwithgles.catchpack;

public final class a {
    private static a q;

    /* renamed from: a  reason: collision with root package name */
    private final String f15818a = "touchscale";

    /* renamed from: b  reason: collision with root package name */
    private final String f15819b = "touchout";

    /* renamed from: c  reason: collision with root package name */
    private final String f15820c = "longtouchswap";

    /* renamed from: d  reason: collision with root package name */
    private final String f15821d = "longtouchmove";
    private final String e = "musicaddself";
    private final String f = "pictran";
    private final String g = "picfindmore";
    private final String h = "musicinfo";
    private int i = -1;
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = -1;

    private a() {
    }

    public static a a() {
        if (q == null) {
            q = new a();
        }
        return q;
    }

    public final boolean a(int i2) {
        int i3;
        String str = "touchscale";
        switch (i2) {
            case 0:
                i3 = this.i;
                str = "touchscale";
                break;
            case 1:
                i3 = this.j;
                str = "touchout";
                break;
            case 2:
                i3 = this.k;
                str = "longtouchswap";
                break;
            case 3:
                i3 = this.l;
                str = "longtouchmove";
                break;
            case 4:
                i3 = this.m;
                str = "musicinfo";
                break;
            case 5:
                i3 = this.n;
                str = "musicaddself";
                break;
            case 6:
                i3 = this.o;
                str = "pictran";
                break;
            case 7:
                i3 = this.p;
                str = "picfindmore";
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 == -1) {
            //i3 = p.f.getInt(str, 1);
        }
        return i3 == 1;
    }
}