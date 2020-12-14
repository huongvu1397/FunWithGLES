package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.util.TypedValue;
import android.view.View;
import java.lang.reflect.Array;
import java.util.List;

/* renamed from: pd  reason: default package and case insensitive filesystem */
public final class C1085pd {
    static {
        new TypedValue();
    }

    private static String V(View view, int i) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i);
    }

    public static View a(View view, int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String V = V(view, i);
        StringBuilder sb = new StringBuilder();
        sb.append("Required view '");
        sb.append(V);
        sb.append("' with ID ");
        sb.append(i);
        sb.append(" for ");
        throw new IllegalStateException(Ff.a(sb, str, " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation."));
    }

//    @SafeVarargs
//    public static <T> List<T> b(T... tArr) {
//        int i = 0;
//        for (T t : tArr) {
//            if (t != null) {
//                tArr[i] = t;
//                i++;
//            }
//        }
//        if (i != r1) {
//            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
//            System.arraycopy(tArr, 0, tArr2, 0, i);
//            tArr = tArr2;
//        }
//        return new C1064od(tArr);
//    }

    public static <T> T c(View view, int i, String str, Class<T> cls) {
        return a(a(view, i, str), i, str, cls);
    }

    public static <T> T a(View view, int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            String V = V(view, i);
            StringBuilder sb = new StringBuilder();
            sb.append("View '");
            sb.append(V);
            sb.append("' with ID ");
            sb.append(i);
            sb.append(" for ");
            throw new IllegalStateException(Ff.a(sb, str, " was of the wrong type. See cause for more info."), e);
        }
    }

    public static <T> T b(View view, int i, String str, Class<T> cls) {
        return a(view.findViewById(i), i, str, cls);
    }
}