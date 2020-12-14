package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import java.util.Arrays;
import java.util.List;

/* renamed from: oka  reason: default package and case insensitive filesystem */
public class C3905oka {
    private C3905oka() {
    }

    public static void Pf(String str) {
        Fja fja = new Fja(Ff.b("lateinit property ", str, " has not been initialized"));
        ja(fja);
        throw fja;
    }

    private static void Th(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str);
        ja(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static boolean a(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(Ff.g(str, " must not be null"));
            ja(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            Th(str);
            throw null;
        }
    }

    public static void ema() {
        C4092sja sja = new C4092sja();
        ja(sja);
        throw sja;
    }

    private static <T extends Throwable> T ja(T t) {
        a(t, C3905oka.class.getName());
        return t;
    }

    public static boolean k(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}