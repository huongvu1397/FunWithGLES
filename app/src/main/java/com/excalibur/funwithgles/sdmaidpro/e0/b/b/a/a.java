package com.excalibur.funwithgles.sdmaidpro.e0.b.b.a;

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: outline */
public class a {
    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }
//
//    public static MenuItem a(MenuItem menuItem, boolean z, Menu menu, int i, String str) {
//        menuItem.setVisible(z);
//        MenuItem findItem = menu.findItem(i);
//        i.a((Object) findItem, str);
//        return findItem;
//    }
//
//    public static e.a.a.k2.a.a a(a.c cVar, String str, Object[] objArr, s sVar, e eVar) {
//        cVar.a(str, objArr);
//        return new e.a.a.k2.a.a(sVar, eVar);
//    }
//
//    public static e.a.a.m2.a.s a(ArrayList arrayList, e.a.a.m2.a.s sVar, String str) {
//        arrayList.add(sVar);
//        return new e.a.a.m2.a.s(str);
//    }
//
//    public static String a(RecyclerView recyclerView, StringBuilder sb) {
//        sb.append(recyclerView.k());
//        return sb.toString();
//    }
//
//    public static String a(Class cls, StringBuilder sb, String str, String str2) {
//        sb.append(cls.getSimpleName());
//        sb.append(str);
//        sb.append(cls.getSimpleName());
//        sb.append(str2);
//        return sb.toString();
//    }
//
//    public static String a(String str, int i) {
//        return str + i;
//    }
//
//    public static String a(String str, long j) {
//        return str + j;
//    }
//
//    public static String a(String str, Uri uri) {
//        return str + uri;
//    }
//
//    public static String a(String str, Fragment fragment, String str2) {
//        return str + fragment + str2;
//    }
//
//    public static String a(String str, String str2) {
//        return str + str2;
//    }
//
//    public static String a(String str, String str2, String str3) {
//        return str + str2 + str3;
//    }
//
//    public static String a(String str, Type type) {
//        return str + type;
//    }
//
//    public static String a(StringBuilder sb, int i, String str) {
//        sb.append(i);
//        sb.append(str);
//        return sb.toString();
//    }
//
//    public static String a(StringBuilder sb, String str, String str2) {
//        sb.append(str);
//        sb.append(str2);
//        return sb.toString();
//    }
//
//    public static String a(StringBuilder sb, String str, String str2, String str3) {
//        sb.append(str);
//        return str2.replace(str3, sb.toString());
//    }
//
//    public static String a(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
//        sb.append(xmlPullParser.getPositionDescription());
//        sb.append(str);
//        return sb.toString();
//    }

    public static StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

//    public static void a(SharedPreferences sharedPreferences, String str, boolean z) {
//        sharedPreferences.edit().putBoolean(str, z).apply();
//    }
//
//    public static void a(SparseBooleanArray sparseBooleanArray, int i, f fVar, ArrayList arrayList) {
//        arrayList.add(fVar.getItem(sparseBooleanArray.keyAt(i)));
//    }
//
//    public static void a(n nVar, m.a aVar, LinkedHashSet linkedHashSet) {
//        linkedHashSet.addAll(aVar.a(nVar.e()));
//    }
//
//    public static StringBuilder b(String str, String str2) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.append(str2);
//        return sb;
//    }
//
//    public static Pattern b(StringBuilder sb, String str, String str2, String str3) {
//        sb.append(str);
//        return Pattern.compile(str2.replace(str3, sb.toString()));
//    }
}