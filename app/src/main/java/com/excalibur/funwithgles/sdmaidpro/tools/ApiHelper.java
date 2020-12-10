package com.excalibur.funwithgles.sdmaidpro.tools;

import android.os.Build;

/* compiled from: ApiHelper */
public final class ApiHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f3537a = Build.VERSION.SDK_INT;

    public static boolean a() {
        return f3537a >= 17;
    }

    public static boolean b() {
        return f3537a >= 18;
    }

    public static boolean c() {
        return f3537a == 19;
    }

    public static boolean d() {
        return f3537a >= 19;
    }

    public static boolean e() {
        return f3537a >= 21;
    }

    public static boolean f() {
        return f3537a >= 22;
    }

    public static boolean g() {
        return f3537a >= 23;
    }

    public static boolean h() {
        return f3537a >= 24 || "N".equals(Build.VERSION.CODENAME);
    }

    public static boolean i() {
        return f3537a >= 25;
    }

    public static boolean j() {
        return Build.VERSION.RELEASE.equals("O") || f3537a >= 26;
    }

    public static boolean k() {
        return Build.VERSION.RELEASE.equals("O") || f3537a == 26;
    }

    public static boolean l() {
        return Build.VERSION.RELEASE.equals("P") || f3537a >= 27;
    }
}