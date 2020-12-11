package com.excalibur.funwithgles.sdmaidpro.tools;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: StringUtils */
public final class StringUtils {
    public static String a(Collection<?> collection) {
        return a(collection, ", ");
    }

    public static String a(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        if (collection.isEmpty()) {
            return "{}";
        }
        int size = collection.size() * str.length();
        for (Object next : collection) {
            if (next != null) {
                size += next.toString().length();
            }
        }
        StringBuilder sb = new StringBuilder(size + 2);
        sb.append("{");
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2.toString());
            }
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static SpannableString a(Context context, int i, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i)), 0, str.length(), 0);
        return spannableString;
    }
}