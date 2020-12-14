package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: Ff  reason: default package */
/* compiled from: outline */
public class Ff {
//    public static StackTraceElement[] Ev() {
//        return new Throwable().getStackTrace();
//    }
//
//    public static int a(Object obj, int i) {
//        return String.valueOf(obj).length() + i;
//    }
//
//    public static int a(boolean z, C0614nh nhVar, int i) {
//        return i - C3725kx.getInstance().a(z, nhVar);
//    }
//
//    public static View a(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z) {
//        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z);
//    }
//
    public static Character a(char c, HashMap hashMap, Object obj, char c2) {
        hashMap.put(obj, Character.valueOf(c));
        return Character.valueOf(c2);
    }

//    public static Object a(Object obj, String str, Kha kha, String str2) {
//        C3905oka.d(obj, str);
//        Object a = C1936XE.a(kha);
//        C3905oka.d(a, str2);
//        return a;
//    }

    public static String a(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String a(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    public static String a(Object obj, StringBuilder sb, String str) {
        sb.append(obj.getClass().getName());
        sb.append(str);
        return sb.toString();
    }

    public static String a(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String a(String str, Object obj, String str2) {
        return str + obj + str2;
    }

    public static String a(String str, Object obj, String str2, Object obj2) {
        return str + obj + str2 + obj2;
    }

    public static String a(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String a(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String a(StringBuilder sb, Object obj, char c) {
        sb.append(obj);
        sb.append(c);
        return sb.toString();
    }

    public static String a(StringBuilder sb, Object obj, String str) {
        sb.append(obj);
        sb.append(str);
        return sb.toString();
    }

    public static String a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String a(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }
//
    public static String a(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }
//
//    public static String a(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
//        sb.append(xmlPullParser.getPositionDescription());
//        sb.append(str);
//        return sb.toString();
//    }
//
//    public static StringBuilder a(char c) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(c);
//        return sb;
//    }
//
//    public static StringBuilder a(String str, int i, String str2, int i2, String str3) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.append(i);
//        sb.append(str2);
//        sb.append(i2);
//        sb.append(str3);
//        return sb;
//    }
//
//    public static StringBuilder a(String str, long j, String str2) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.append(j);
//        sb.append(str2);
//        return sb;
//    }
//
//    public static StringBuilder a(StringBuilder sb, String str, String str2, C1293zc zcVar, String str3) {
//        sb.append(str);
//        sb.append(str2);
//        zcVar.execSQL(sb.toString());
//        StringBuilder sb2 = new StringBuilder();
//        sb2.append(str3);
//        return sb2;
//    }
//
    public static ArrayList a(int i, Map map, Object obj, int i2, Object obj2) {
        map.put(Integer.valueOf(i), obj);
        ArrayList arrayList = new ArrayList(i2);
        arrayList.add(obj2);
        return arrayList;
    }
//
    public static ArrayList a(ArrayList arrayList, Object obj, int i, Map map, Object obj2, int i2) {
        arrayList.add(obj);
        map.put(Integer.valueOf(i), obj2);
        return new ArrayList(i2);
    }
//
//    public static JSONObject a(JSONException jSONException) {
//        jSONException.printStackTrace();
//        return new JSONObject();
//    }
//
//    public static void a(C1646ML ml, String str) {
//        C3905oka.d(ml, str);
//        ml.getRenderer().requestRender();
//    }
//
//    public static void a(Fragment fragment, StringBuilder sb, char c, String str, String str2) {
//        sb.append(c.u(fragment.getActivity()));
//        sb.append(c);
//        C1639ME.sendClick(str, str2, sb.toString());
//    }
//
//    public static void a(Pa pa, Object obj, String str, String str2, C4414zca zca) {
//        C4367yca Zp = pa.Zp();
//        C3905oka.e(obj, str);
//        C3905oka.e(Zp, str2);
//        Zp.add(zca);
//    }
//
    public static void a(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        Log.e(str, sb.toString());
    }

//    public static void a(Object obj, Kha kha, C3472fca fca, C0631pg pgVar) {
//        obj.getClass();
//        pgVar.add(fca.a(new Nd(kha)));
//    }

    public static void a(Object obj, String str, Object obj2, String str2, Object obj3, String str3) {
        C3905oka.e(obj, str);
        C3905oka.e(obj2, str2);
        C3905oka.e(obj3, str3);
    }
//
    public static void a(Object obj, String str, Object obj2, String str2, Object obj3, String str3, Object obj4, String str4) {
        C3905oka.e(obj, str);
        C3905oka.e(obj2, str2);
        C3905oka.e(obj3, str3);
        C3905oka.e(obj4, str4);
    }
//
    public static void a(Object obj, String str, Object obj2, String str2, Object obj3, String str3, Object obj4, String str4, Object obj5, String str5) {
        C3905oka.e(obj, str);
        C3905oka.e(obj2, str2);
        C3905oka.e(obj3, str3);
        C3905oka.e(obj4, str4);
        C3905oka.e(obj5, str5);
    }
//
//    public static void a(Object obj, String str, C4367yca yca, String str2, C4414zca zca) {
//        C3905oka.e(obj, str);
//        C3905oka.e(yca, str2);
//        yca.add(zca);
//    }

    public static void a(StringBuilder sb, String str, char c, String str2) {
        sb.append(str);
        sb.append(c);
        sb.append(str2);
    }

    public static void a(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }
//
//    public static void a(StringBuilder sb, String str, C4185uia uia) {
//        sb.append(str);
//        uia.debug(sb.toString());
//    }
//
    public static void a(Set set, Object obj, Object obj2, Object obj3, Object obj4) {
        set.add(obj);
        set.add(obj2);
        set.add(obj3);
        set.add(obj4);
    }
//
//    public static Object b(List list, int i) {
//        return list.get(list.size() + i);
//    }
//
    public static String b(String str, Object obj) {
        return str + obj;
    }

    public static String b(String str, String str2, String str3) {
        return str + str2 + str3;
    }
//
//    public static StringBuilder b(String str, int i, String str2) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.append(i);
//        sb.append(str2);
//        return sb;
//    }
//
//    public static StringBuilder b(String str, Object obj, String str2) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.append(obj);
//        sb.append(str2);
//        return sb;
//    }
//
//    public static void b(Object obj, StringBuilder sb, String str) {
//        sb.append(Integer.toHexString(System.identityHashCode(obj)));
//        sb.append(str);
//    }
//
//    public static void b(StringBuilder sb, String str, String str2, String str3) {
//        sb.append(str);
//        sb.append(str2);
//        sb.append(str3);
//    }
//
//    public static StringBuilder c(int i, String str) {
//        StringBuilder sb = new StringBuilder(i);
//        sb.append(str);
//        return sb;
//    }
//
//    public static StringBuilder c(String str, String str2, String str3) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.append(str2);
//        sb.append(str3);
//        return sb;
//    }
//
//    public static void c(String str, int i, String str2) {
//        com.google.android.exoplayer2.util.Log.w(str2, str + i);
//    }
//
//    public static void c(String str, Object obj) {
//        str + obj;
//    }
//
//    public static void c(String str, Object obj, String str2) {
//        Log.e(str2, str + obj);
//    }
//
//    public static FloatBuffer d(ByteBuffer byteBuffer) {
//        return byteBuffer.order(ByteOrder.nativeOrder()).asFloatBuffer();
//    }
//
//    public static void d(String str, String str2, String str3) {
//        com.google.android.exoplayer2.util.Log.w(str3, str + str2);
//    }
//
    public static float e(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }
//
//    public static String e(String str, long j) {
//        return str + j;
//    }
//
    public static String g(String str, String str2) {
        return str + str2;
    }
//
//    public static int h(int i, int i2, int i3, int i4) {
//        return ((i + i2) * i3) + i4;
//    }
//
//    public static StringBuilder h(String str, String str2) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.append(str2);
//        return sb;
//    }
//
//    public static int i(int i, int i2, int i3, int i4) {
//        return ((i - i2) / i3) + i4;
//    }
//
//    public static int j(int i, int i2, int i3, int i4) {
//        return (i * i2) + i3 + i4;
//    }
//
//    public static Bundle j(String str, String str2) {
//        Bundle bundle = new Bundle();
//        bundle.putString(str, str2);
//        return bundle;
//    }
//
//    public static String k(String str, int i) {
//        return str + i;
//    }
//
//    public static void k(String str, String str2) {
//        str + str2;
//    }
//
//    public static String l(String str, int i) {
//        return str + i;
//    }
//
//    public static StringBuilder la(String str) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        return sb;
//    }
//
//    public static void m(String str, int i) {
//        str + i;
//    }
//
//    public static Sticker.Builder ma(String str) {
//        return new Sticker.Builder().name(str);
//    }
//
//    public static StickerItem.Builder na(String str) {
//        return new StickerItem.Builder().resourceName(str);
//    }
}