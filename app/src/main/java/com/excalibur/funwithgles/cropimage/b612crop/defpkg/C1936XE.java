package com.excalibur.funwithgles.cropimage.b612crop.defpkg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.excalibur.funwithgles.App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: XE  reason: default package and case insensitive filesystem */
public class C1936XE {
//    public static int Ai(int i) {
//        s("GlesUtils", Ff.Ev()[0].getLineNumber());
//        int[] iArr = new int[1];
//        GLES20Ex.glGenTextures((Object) null, 1, iArr, 0);
//        int i2 = iArr[0];
//        GLES20.glBindTexture(i, i2);
//        GLES20.glTexParameterf(i, 10241, 9728.0f);
//        GLES20.glTexParameterf(i, 10240, 9729.0f);
//        GLES20.glTexParameteri(i, 10242, 33071);
//        GLES20.glTexParameteri(i, 10243, 33071);
//        GLES20.glBindTexture(i, 0);
//        s("GlesUtils", new Throwable().getStackTrace()[0].getLineNumber());
//        return i2;
//    }
//
//    public static int Bi(int i) {
//        return Math.round((((float) i) * 255.0f) / 100.0f);
//    }
//
//    public static int Ci(int i) {
//        return B612Application.De().getResources().getDimensionPixelSize(i);
//    }
//
//    public static float Da(float f) {
//        float f2 = f % 360.0f;
//        if (f2 < 0.0f) {
//            f2 += 360.0f;
//        }
//        return f2 > 180.0f ? f2 - 360.0f : f2;
//    }
//
//    public static int G(String str, String str2) {
//        int f = f(35633, str);
//        int f2 = f(35632, str2);
//        int glCreateProgram = GLES20.glCreateProgram();
//        GLES20.glAttachShader(glCreateProgram, f);
//        GLES20.glAttachShader(glCreateProgram, f2);
//        GLES20.glLinkProgram(glCreateProgram);
//        int[] iArr = new int[1];
//        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
//        if (iArr[0] != 1) {
//            Log.e("GlesUtils", "Could not link program:");
//            Log.e("GlesUtils", GLES20.glGetProgramInfoLog(glCreateProgram));
//            GLES20.glDeleteProgram(glCreateProgram);
//            glCreateProgram = 0;
//        }
//        GLES20.glDeleteShader(f);
//        GLES20.glDeleteShader(f2);
//        return glCreateProgram;
//    }
//
//    public static boolean H(String str, String str2) {
//        if (str == null && str2 == null) {
//            return true;
//        }
//        if (str == null || str2 == null) {
//            return false;
//        }
//        return str.equalsIgnoreCase(str2);
//    }
//
//    public static boolean I(String str, String str2) {
//        return !equals(str, str2);
//    }
//
//    public static String Yb(long j) {
//        return l(j, false);
//    }
//
//    public static long Zb(long j) {
//        return ((long) Math.ceil((double) (Math.max(0, j) / 1000))) * 1000;
//    }
//
//    public static final <T> T a(Kha<T> kha) {
//        C3905oka.e(kha, "receiver$0");
//        T value = kha.getValue();
//        if (value != null) {
//            return value;
//        }
//        C3905oka.ema();
//        throw null;
//    }
//
//    public static void ad(String str) {
//        if (!isEmpty(str)) {
//            o(new File(str));
//        }
//    }
//
//    public static Thread b(String str, Runnable runnable) {
//        Thread thread = new Thread(runnable, str);
//        thread.start();
//        return thread;
//    }
//
//    public static int bd(String str) {
//        try {
//            String replace = str.replace("://", "");
//            int indexOf = replace.indexOf(Constants.URL_PATH_DELIMITER);
//            if (indexOf == -1) {
//                return str.hashCode();
//            }
//            return replace.substring(indexOf).hashCode();
//        } catch (Exception unused) {
//            return str.hashCode();
//        }
//    }
//
//    public static Rect c(Rect rect, Rect rect2) {
//        int max = Math.max(1, rect.width());
//        int max2 = Math.max(1, rect.height());
//        if (rect2.height() * max > rect2.width() * max2) {
//            int width = ((max / 2) + (rect2.width() * max2)) / max;
//            int i = rect2.left;
//            int i2 = rect2.top;
//            int i3 = rect2.bottom;
//            return new Rect(i, ((i2 + i3) - width) / 2, rect2.right, ((i2 + i3) + width) / 2);
//        }
//        int height = ((max2 / 2) + (rect2.height() * max)) / max2;
//        int i4 = rect2.left;
//        int i5 = rect2.right;
//        return new Rect(((i4 + i5) - height) / 2, rect2.top, ((i4 + i5) + height) / 2, rect2.bottom);
//    }
//
//    public static String cd(String str) {
//        if (!str.startsWith("http://") && !str.startsWith("https://")) {
//            return Ff.g("http://", str);
//        }
//        return str;
//    }
//
//    public static void closeQuietly(Closeable closeable) {
//        if (closeable != null) {
//            try {
//                closeable.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void copyDirectory(File file, File file2, boolean z) throws IOException {
//        if (file.isDirectory()) {
//            if (file2.exists() || file2.mkdirs()) {
//                String[] list = file.list();
//                for (int i = 0; i < list.length; i++) {
//                    copyDirectory(new File(file, list[i]), new File(file2, list[i]), z);
//                }
//                return;
//            }
//            StringBuilder la = Ff.la("Cannot create dir ");
//            la.append(file2.getAbsolutePath());
//            throw new IOException(la.toString());
//        } else if (!file2.exists() || z) {
//            File parentFile = file2.getParentFile();
//            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
//                FileInputStream fileInputStream = new FileInputStream(file);
//                FileOutputStream fileOutputStream = new FileOutputStream(file2);
//                byte[] bArr = new byte[STMobileHumanActionNative.ST_MOBILE_ENABLE_EYEBALL_CENTER_DETECT];
//                while (true) {
//                    int read = fileInputStream.read(bArr);
//                    if (read > 0) {
//                        fileOutputStream.write(bArr, 0, read);
//                    } else {
//                        fileInputStream.close();
//                        fileOutputStream.close();
//                        return;
//                    }
//                }
//            } else {
//                StringBuilder la2 = Ff.la("Cannot create dir ");
//                la2.append(parentFile.getAbsolutePath());
//                throw new IOException(la2.toString());
//            }
//        }
//    }
//
//    public static void d(float[] fArr, float[] fArr2) {
//        int[] iArr = {1, 2, 0};
//        float f = fArr[0] + fArr[4] + fArr[8];
//        int i = 2;
//        int i2 = 1;
//        if (((double) f) > 0.0d) {
//            float sqrt = (float) Math.sqrt((double) (f + 1.0f));
//            fArr2[0] = sqrt * 0.5f;
//            float f2 = 0.5f / sqrt;
//            fArr2[1] = (fArr[5] - fArr[7]) * f2;
//            fArr2[2] = (fArr[6] - fArr[2]) * f2;
//            fArr2[3] = (fArr[1] - fArr[3]) * f2;
//            return;
//        }
//        if (fArr[4] <= fArr[0]) {
//            i2 = 0;
//        }
//        if (fArr[8] <= fArr[(i2 * 3) + i2]) {
//            i = i2;
//        }
//        int i3 = iArr[i];
//        int i4 = iArr[i3];
//        int i5 = i * 3;
//        int i6 = i3 * 3;
//        int i7 = i4 * 3;
//        float sqrt2 = (float) Math.sqrt((double) ((fArr[i5 + i] - (fArr[i6 + i3] + fArr[i7 + i4])) + 1.0f));
//        fArr2[i + 1] = sqrt2 * 0.5f;
//        float f3 = 0.5f / sqrt2;
//        fArr2[0] = (fArr[i6 + i4] - fArr[i7 + i3]) * f3;
//        fArr2[i3 + 1] = (fArr[i3 + i5] + fArr[i6 + i]) * f3;
//        fArr2[i4 + 1] = (fArr[i5 + i4] + fArr[i7 + i]) * f3;
//    }
//
//    public static boolean dd(String str) {
//        int length;
//        if (!(str == null || (length = str.length()) == 0)) {
//            for (int i = 0; i < length; i++) {
//                if (!Character.isWhitespace(str.charAt(i))) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static final void de(View view) {
//        C3905oka.e(view, "receiver$0");
//        view.setVisibility(4);
//    }
//
//    public static void e(float[] fArr, float[] fArr2) {
//        fArr2[0] = fArr[0];
//        fArr2[1] = fArr[1];
//        fArr2[2] = fArr[2];
//        fArr2[3] = fArr[3];
//    }
//
//    public static boolean ed(String str) {
//        return new File(str).exists();
//    }
//
//    public static final void ee(View view) {
//        C3905oka.e(view, "receiver$0");
//        view.setVisibility(0);
//    }
//
//    public static boolean equals(String str, String str2) {
//        if (str == null && str2 == null) {
//            return true;
//        }
//        if (str == null || str2 == null) {
//            return false;
//        }
//        return str.equals(str2);
//    }
//
//    public static int f(int i, String str) {
//        int glCreateShader = GLES20.glCreateShader(i);
//        GLES20.glShaderSource(glCreateShader, str);
//        GLES20.glCompileShader(glCreateShader);
//        int[] iArr = new int[1];
//        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
//        if (iArr[0] != 0) {
//            return glCreateShader;
//        }
//        Log.e("GlesUtils", "Could not compile shader(TYPE=" + i + "):");
//        Log.e("GlesUtils", GLES20.glGetShaderInfoLog(glCreateShader));
//        return 0;
//    }
//
//    public static boolean fd(String str) {
//        return !dd(str);
//    }
//
//    public static boolean g(_g _gVar) {
//        return _gVar.Wrc.getValue().booleanValue();
//    }
//
//    public static boolean gd(String str) {
//        return !isEmpty(str);
//    }
//
//    public static String getAssetPath(String str) {
//        if (g.isEmpty(str)) {
//            return null;
//        }
//        return str.substring(8);
//    }
//
    public static int getColor(int i) {
        return App.self().getResources().getColor(i);
    }
//
//    public static Drawable getDrawable(int i) {
//        return B612Application.De().getResources().getDrawable(i);
//    }
//
//    public static String getString(int i) {
//        return i == 0 ? "" : B612Application.De().getResources().getString(i);
//    }
//
//    public static FloatBuffer hU() {
//        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
//        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
//        allocateDirect.order(ByteOrder.nativeOrder());
//        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
//        asFloatBuffer.put(fArr);
//        asFloatBuffer.position(0);
//        return asFloatBuffer;
//    }
//
//    public static boolean hd(String str) {
//        try {
//            B612Application.De().getPackageManager().getPackageInfo(str, 128);
//            return true;
//        } catch (PackageManager.NameNotFoundException unused) {
//            return false;
//        }
//    }
//
//    public static Animation iU() {
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation.setDuration(300);
//        return alphaAnimation;
//    }
//
//    public static boolean isAsset(String str) {
//        if (g.isEmpty(str)) {
//            return false;
//        }
//        return str.startsWith(StickerHelper.ASSET_PREFIX);
//    }
//
//    public static boolean isEmpty(String str) {
//        return str == null || str.length() == 0;
//    }
//
    public static float[] j(RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        return new float[]{f, f2, f3, f2, f3, f4, f, f4};
    }
//
//    public static Animation jU() {
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//        alphaAnimation.setDuration(300);
//        return alphaAnimation;
//    }
//
//    public static Animation kU() {
//        float Ya = (float) C4081sY.Ya(-10.0f);
//        float Ya2 = (float) C4081sY.Ya(6.0f);
//        AnimationSet animationSet = new AnimationSet(false);
//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, Ya);
//        translateAnimation.setInterpolator(new DecelerateInterpolator());
//        translateAnimation.setDuration(266);
//        TranslateAnimation translateAnimation2 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, Ya2 - Ya);
//        translateAnimation2.setInterpolator(new AccelerateInterpolator());
//        translateAnimation2.setDuration(533);
//        translateAnimation2.setStartOffset(266);
//        TranslateAnimation translateAnimation3 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, -Ya2);
//        translateAnimation3.setDuration(233);
//        translateAnimation3.setStartOffset(799);
//        TranslateAnimation translateAnimation4 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, 0.0f);
//        translateAnimation4.setDuration(1000);
//        translateAnimation4.setStartOffset(1032);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.addAnimation(translateAnimation2);
//        animationSet.addAnimation(translateAnimation3);
//        animationSet.addAnimation(translateAnimation4);
//        return animationSet;
//    }
//
//    public static String l(long j, boolean z) {
//        long max = Math.max(0, j);
//        if (!z) {
//            max = Zb(j);
//        }
//        String str = TimeUnit.MILLISECONDS.toHours(max) > 0 ? "HH:mm:ss" : "mm:ss";
//        if (z) {
//            str = Ff.g(str, ".SSS");
//        }
//        return DurationFormatUtils.formatDuration(max, str);
//    }
//
//    public static Animation lU() {
//        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
//        translateAnimation.setDuration(300);
//        return translateAnimation;
//    }
//
//    public static int m(Context context, int i) {
//        return Math.round((float) ((i * context.getResources().getDisplayMetrics().densityDpi) / 160));
//    }
//
//    public static Animation mU() {
//        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
//        translateAnimation.setDuration(300);
//        return translateAnimation;
//    }
//
//    public static ea nU() {
//        String rU = rU();
//        for (ea eaVar : ea.values()) {
//            if (rU.endsWith(B612Application.De().getResources().getString(eaVar.pEc))) {
//                return eaVar;
//            }
//        }
//        return ea.CAMERA;
//    }
//
//    public static void o(File file) {
//        File[] listFiles;
//        if (file != null) {
//            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
//                for (File o : listFiles) {
//                    o(o);
//                }
//            }
//            file.delete();
//        }
//    }
//
//    public static int oU() {
//        return ri.Sg(R.dimen.camera_adjust_distort_bar_height);
//    }
//
//    public static File pU() {
//        File file;
//        boolean z;
//        if (C3780mF.getInstance().MU()) {
//            file = new File(c(ea.values()[C3780mF.getInstance().JU()]));
//        } else {
//            if (C1412DU.Vivo.match()) {
//                if (!C3780mF.getInstance().LU()) {
//                    C3780mF.getInstance().zd(new File(c(ea.SANGJI)).exists());
//                }
//                z = C3780mF.getInstance().NU();
//            } else {
//                z = C1385CU.jVd.match() ? C3968qF.g("isSaveRouteMeizuCheckNeeded", true) : false;
//            }
//            if (!z) {
//                file = new File(c(ea.CAMERA));
//            } else if (C1412DU.Vivo.match()) {
//                file = new File(c(ea.SANGJI));
//            } else {
//                file = new File(c(ea.DCIM));
//            }
//        }
//        file.mkdirs();
//        return file;
//    }
//
//    public static String qU() {
//        try {
//            TelephonyManager telephonyManager = (TelephonyManager) B612Application.De().getSystemService(PlaceFields.PHONE);
//            if (telephonyManager != null) {
//                String line1Number = telephonyManager.getLine1Number();
//                if (fd(line1Number)) {
//                    return line1Number;
//                }
//            }
//        } catch (Exception unused) {
//        }
//        return "";
//    }
//
//    public static void r(String str, int i) {
//        while (true) {
//            int eglGetError = EGL14.eglGetError();
//            if (eglGetError != 12288) {
//                StringBuilder b = Ff.b("LINE[", i, "] - eglGetError: 0x");
//                b.append(Integer.toHexString(eglGetError));
//                Log.e(str, b.toString());
//            } else {
//                return;
//            }
//        }
//    }
//
//    public static String rU() {
//        return pU().getAbsolutePath();
//    }
//
//    public static void s(String str, int i) {
//        while (true) {
//            int glGetError = GLES20.glGetError();
//            if (glGetError != 0) {
//                StringBuilder b = Ff.b("LINE[", i, "] - glGetError: 0x");
//                b.append(Integer.toHexString(glGetError));
//                Log.e(str, b.toString());
//            } else {
//                return;
//            }
//        }
//    }
//
//    @SuppressLint({"InlinedApi"})
//    public static boolean sU() {
//        NetworkInfo networkInfo;
//        NetworkInfo networkInfo2;
//        ConnectivityManager connectivityManager = (ConnectivityManager) B612Application.De().getSystemService("connectivity");
//        NetworkInfo networkInfo3 = null;
//        try {
//            networkInfo = connectivityManager.getNetworkInfo(0);
//        } catch (Exception unused) {
//            networkInfo = null;
//        }
//        boolean isConnectedOrConnecting = networkInfo != null ? networkInfo.isConnectedOrConnecting() : false;
//        try {
//            networkInfo2 = connectivityManager.getNetworkInfo(1);
//        } catch (Exception unused2) {
//            networkInfo2 = null;
//        }
//        boolean isConnectedOrConnecting2 = networkInfo2 != null ? networkInfo2.isConnectedOrConnecting() : false;
//        try {
//            networkInfo3 = connectivityManager.getNetworkInfo(6);
//        } catch (Exception unused3) {
//        }
//        boolean isConnectedOrConnecting3 = networkInfo3 != null ? networkInfo3.isConnectedOrConnecting() : false;
//        if (isConnectedOrConnecting2 || isConnectedOrConnecting || isConnectedOrConnecting3) {
//            return true;
//        }
//        return false;
//    }
//
//    public static int sb(int i, int i2) {
//        return (i & 16777215) | (i2 << 24);
//    }
//
//    public static <T> T t(Class<T> cls) {
//        try {
//            return cls.newInstance();
//        } catch (Exception e) {
//            throw new C3642jI(e);
//        }
//    }
//
//    public static boolean tU() {
//        return C3968qF.g("isRouteMoreBtnNewMark", false);
//    }
//
//    public static int u(int i, int i2, int i3) {
//        return b(i, i2, i3, false);
//    }
//
//    public static void writeStringToFile(File file, String str) {
//        BufferedWriter bufferedWriter = null;
//        try {
//            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
//            try {
//                bufferedWriter2.write(str);
//                b(bufferedWriter2);
//            } catch (IOException unused) {
//                bufferedWriter = bufferedWriter2;
//                b(bufferedWriter);
//            } catch (Throwable th) {
//                th = th;
//                bufferedWriter = bufferedWriter2;
//                b(bufferedWriter);
//                throw th;
//            }
//        } catch (IOException unused2) {
//            b(bufferedWriter);
//        } catch (Throwable th2) {
//            th = th2;
//            b(bufferedWriter);
//            throw th;
//        }
//    }
//
//    public static void yd(boolean z) {
//        C3968qF.h("isRouteMoreBtnNewMark", z);
//    }
//
//    public static Rect a(Rect rect, int i, int i2, int i3) {
//        return i == 0 ? rect : a(new Rect((rect.top * i3) / i2, i2 - ((rect.right * i2) / i3), (rect.bottom * i3) / i2, i2 - ((rect.left * i2) / i3)), i - 1, i2, i3);
//    }
//
//    public static <T> T[] a(Class<T> cls, int i) {
//        T[] tArr = (Object[]) Array.newInstance(cls, i);
//        for (int i2 = 0; i2 < i; i2++) {
//            try {
//                tArr[i2] = cls.newInstance();
//            } catch (Exception e) {
//                c.frd.Xa(e);
//            }
//        }
//        return tArr;
//    }
//
//    public static Rect b(Rect rect, Rect rect2) {
//        int max = Math.max(1, rect.width());
//        int max2 = Math.max(1, rect.height());
//        if (rect2.height() * max > rect2.width() * max2) {
//            int height = (rect2.height() * max) / max2;
//            int i = rect2.left;
//            int i2 = rect2.right;
//            return new Rect(((i + i2) - height) / 2, rect2.top, ((i + i2) + height) / 2, rect2.bottom);
//        }
//        int width = (rect2.width() * max2) / max;
//        int i3 = rect2.left;
//        int i4 = rect2.top;
//        int i5 = rect2.bottom;
//        return new Rect(i3, ((i4 + i5) - width) / 2, rect2.right, ((i4 + i5) + width) / 2);
//    }
//
//    public static int m(Bitmap bitmap) {
//        s("GlesUtils", Ff.Ev()[0].getLineNumber());
//        int[] iArr = new int[1];
//        GLES20Ex.glGenTextures((Object) null, 1, iArr, 0);
//        int i = iArr[0];
//        GLES20.glBindTexture(3553, i);
//        GLES20.glTexParameteri(3553, 10241, 9728);
//        GLES20.glTexParameteri(3553, 10240, 9729);
//        GLUtils.texImage2D(3553, 0, bitmap, 0);
//        GLES20.glBindTexture(3553, 0);
//        GLES20.glFinish();
//        s("GlesUtils", new Throwable().getStackTrace()[0].getLineNumber());
//        return i;
//    }
//
//    public static String t(String str, int i) {
//        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
//        characterInstance.setText(str);
//        int i2 = 0;
//        int i3 = 0;
//        while (characterInstance.next() != -1) {
//            int current = characterInstance.current();
//            if (!str.substring(i2, current).equals("\n")) {
//                i3++;
//            }
//            if (i3 == i) {
//                return str.substring(0, current);
//            }
//            i2 = current;
//        }
//        return str;
//    }
//
//    public static float a(Context context, float f) {
//        return (f * ((float) context.getResources().getDisplayMetrics().densityDpi)) / 160.0f;
//    }
//
//    public static void c(Canvas canvas, int i) {
//        int i2 = Build.VERSION.SDK_INT;
//        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), i);
//    }
//
//    public static void a(C0114i iVar, _g _gVar, SnowCodeData snowCodeData) {
//        try {
//            C0119n supportFragmentManager = iVar.getSupportFragmentManager();
//            SnowCodeDialogFragment snowCodeDialogFragment = new SnowCodeDialogFragment();
//            Bundle bundle = new Bundle();
//            bundle.putParcelable("snow_code_data", snowCodeData);
//            snowCodeDialogFragment.setArguments(bundle);
//            snowCodeDialogFragment.show(supportFragmentManager, SnowCodeDialogFragment.TAG);
//            supportFragmentManager.executePendingTransactions();
//            _gVar.Wrc.t(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static int b(int i, int i2, int i3, boolean z) {
//        return (int) ((((Math.sqrt((double) (i * i2)) * 5461.330078125d) * ((double) (C0605mh.Cvc * (z ? 0.6f : 1.0f)))) * ((double) i3)) / 30.0d);
//    }
//
//    public static void c(float[] fArr, float[] fArr2) {
//        float f = fArr[1] * fArr[1];
//        float f2 = fArr[2] * fArr[2];
//        float sqrt = 2.0f / ((float) Math.sqrt((double) ((fArr[3] * fArr[3]) + (f2 + (f + (fArr[0] * fArr[0]))))));
//        float f3 = fArr[1] * sqrt;
//        float f4 = fArr[2] * sqrt;
//        float f5 = fArr[3] * sqrt;
//        float f6 = fArr[0] * f3;
//        float f7 = fArr[0] * f4;
//        float f8 = fArr[0] * f5;
//        float f9 = fArr[1] * f3;
//        float f10 = fArr[1] * f4;
//        float f11 = fArr[1] * f5;
//        float f12 = fArr[2] * f4;
//        float f13 = fArr[2] * f5;
//        float f14 = fArr[3] * f5;
//        fArr2[0] = 1.0f - (f12 + f14);
//        fArr2[3] = f10 - f8;
//        fArr2[6] = f11 + f7;
//        fArr2[1] = f10 + f8;
//        fArr2[4] = 1.0f - (f14 + f9);
//        fArr2[7] = f13 - f6;
//        fArr2[2] = f11 - f7;
//        fArr2[5] = f13 + f6;
//        fArr2[8] = 1.0f - (f9 + f12);
//    }
//
//    public static void b(float[] fArr, float[] fArr2) {
//        float f;
//        float f2;
//        float f3;
//        float f4 = fArr[1] * fArr[1];
//        float f5 = fArr[2] * fArr[2];
//        float sqrt = 2.0f / ((float) Math.sqrt((double) ((fArr[3] * fArr[3]) + (f5 + (f4 + (fArr[0] * fArr[0]))))));
//        float f6 = fArr[1] * sqrt;
//        float f7 = fArr[2] * sqrt;
//        float f8 = fArr[3] * sqrt;
//        float f9 = fArr[0] * f6;
//        float f10 = fArr[0] * f8;
//        float f11 = fArr[1] * f6;
//        float f12 = fArr[1] * f7;
//        float f13 = fArr[2] * f7;
//        float f14 = fArr[2] * f8;
//        float f15 = fArr[3] * f8;
//        float f16 = (fArr[0] * f7) - (fArr[1] * f8);
//        float f17 = 1.0f;
//        float sqrt2 = (float) Math.sqrt((double) (1.0f - (f16 * f16)));
//        if (sqrt2 > 1.0E-4f) {
//            f = (f14 + f9) / sqrt2;
//            f2 = ((1.0f - f11) - f13) / sqrt2;
//            f3 = (f12 + f10) / sqrt2;
//            f17 = ((1.0f - f13) - f15) / sqrt2;
//        } else {
//            f = f9 - f14;
//            f2 = (1.0f - f11) - f15;
//            f3 = 0.0f;
//        }
//        fArr2[0] = (float) Math.atan2((double) f, (double) f2);
//        fArr2[1] = (float) Math.atan2((double) f16, (double) sqrt2);
//        fArr2[2] = (float) Math.atan2((double) f3, (double) f17);
//    }
//
//    public static String G(Context context) {
//        try {
//            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
//            if (activeNetworkInfo == null) {
//                return "";
//            }
//            if (activeNetworkInfo.getType() != 0) {
//                return "W";
//            }
//            switch (((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkType()) {
//                case 1:
//                case 2:
//                case 4:
//                case 7:
//                case 11:
//                    return "2G";
//                case 3:
//                case 5:
//                case 6:
//                case 8:
//                case 9:
//                case 10:
//                case 12:
//                case 14:
//                case 15:
//                    return "3G";
//                case 13:
//                    return "4G";
//                default:
//                    return "C";
//            }
//        } catch (Exception unused) {
//            return "";
//        }
//    }
//
    public static RectF d(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float round = ((float) Math.round(fArr[i - 1] * 10.0f)) / 10.0f;
            float round2 = ((float) Math.round(fArr[i] * 10.0f)) / 10.0f;
            float f = rectF.left;
            if (round < f) {
                f = round;
            }
            rectF.left = f;
            float f2 = rectF.top;
            if (round2 < f2) {
                f2 = round2;
            }
            rectF.top = f2;
            float f3 = rectF.right;
            if (round <= f3) {
                round = f3;
            }
            rectF.right = round;
            float f4 = rectF.bottom;
            if (round2 > f4) {
                f4 = round2;
            }
            rectF.bottom = f4;
        }
        rectF.sort();
        return rectF;
    }
//
//    public static boolean a(Context context, Intent intent) {
//        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
//        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
//            return false;
//        }
//        return true;
//    }
//
//    public static synchronized void a(FFmpegHandler fFmpegHandler, String[] strArr) {
//        synchronized (b.class) {
//            C1531IE.d("++SynchronizedFFmpegHandler.ffmpegMain() : ffmpeg " + TextUtils.join(StringUtils.SPACE, strArr), new Object[0]);
//            long elapsedRealtime = SystemClock.elapsedRealtime();
//            if (fFmpegHandler != null) {
//                fFmpegHandler.enableLog(false);
//                fFmpegHandler.ffmpegMain(strArr);
//            }
//            C1531IE.d("--SynchronizedFFmpegHandler.ffmpegMain() took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms : ffmpeg " + TextUtils.join(StringUtils.SPACE, strArr), new Object[0]);
//        }
//    }
//
//    public static String d(InputStream inputStream) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder sb = new StringBuilder();
//        while (true) {
//            try {
//                String readLine = bufferedReader.readLine();
//                if (readLine == null) {
//                    break;
//                }
//                sb.append(readLine);
//                sb.append("\n");
//            } finally {
//                bufferedReader.close();
//                if (inputStream != null) {
//                    try {
//                        inputStream.close();
//                    } catch (Exception unused) {
//                    }
//                }
//            }
//        }
//        return sb.toString();
//    }
//
//    public static <E extends Enum<E>> E a(Class<E> cls, String str, E e) {
//        if (str == null) {
//            return e;
//        }
//        try {
//            return Enum.valueOf(cls, str);
//        } catch (IllegalArgumentException unused) {
//            return e;
//        }
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
//    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e A[Catch:{ all -> 0x0050 }] */
//    public static C3843nV a(int i, boolean z, int i2) {
//        int i3;
//        C3843nV nVVar = new C3843nV();
//        if (i != 0) {
//            if (i == 1) {
//                i3 = 90;
//            } else if (i == 2) {
//                i3 = 180;
//            } else if (i == 3) {
//                i3 = 270;
//            }
//            if (!z) {
//                try {
//                    nVVar.Zod = (i2 + i3) % 360;
//                    nVVar.Zod = (360 - nVVar.Zod) % 360;
//                } catch (Throwable unused) {
//                }
//            } else {
//                nVVar.Zod = ((i2 - i3) + 360) % 360;
//            }
//            nVVar.cameraOrientation = i2;
//            nVVar.Yod = (i2 + i3) % 360;
//            nVVar.compensatedCameraRotation = (360 - nVVar.Yod) % 360;
//            if (nVVar.cameraOrientation == 0 && !z) {
//                nVVar.compensatedCameraRotation += 180;
//            }
//            return nVVar;
//        }
//        i3 = 0;
//        if (!z) {
//        }
//        nVVar.cameraOrientation = i2;
//        nVVar.Yod = (i2 + i3) % 360;
//        nVVar.compensatedCameraRotation = (360 - nVVar.Yod) % 360;
//        nVVar.compensatedCameraRotation += 180;
//        return nVVar;
//    }
//
//    public static void b(Closeable closeable) {
//        if (closeable != null) {
//            try {
//                closeable.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } catch (Error e2) {
//                e2.printStackTrace();
//            }
//        }
//    }
//
//    public static String c(ea eaVar) {
//        String string = B612Application.De().getString(eaVar.pEc);
//        if (eaVar == ea.CAMERA || eaVar == ea.KAJI) {
//            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + Constants.URL_PATH_DELIMITER + string;
//        } else if (eaVar == ea.DCIM) {
//            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
//        } else {
//            return Environment.getExternalStorageDirectory() + Constants.URL_PATH_DELIMITER + string;
//        }
//    }
//
//    public static void a(View view, float f, Animation.AnimationListener animationListener, int i) {
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f, 1, 0.5f, 1, 0.5f);
//        scaleAnimation.setDuration((long) i);
//        scaleAnimation.setAnimationListener(animationListener);
//        scaleAnimation.setFillAfter(true);
//        view.startAnimation(scaleAnimation);
//    }
//
//    public static void c(float[] fArr) {
//        float sqrt = (float) Math.sqrt((double) ((fArr[3] * fArr[3]) + (fArr[2] * fArr[2]) + (fArr[1] * fArr[1]) + (fArr[0] * fArr[0])));
//        for (int i = 0; i < 4; i++) {
//            fArr[i] = fArr[i] / sqrt;
//        }
//    }
//
//    public static File a(File file, String str, List<String> list) throws IOException {
//        String str2;
//        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"", "-f", "mp4", "-i", str}));
//        if (file == null) {
//            str2 = "-c copy -map 0:0";
//        } else if (file.getAbsolutePath().contains("dat")) {
//            str2 = String.format(Locale.US, "-f aac -i %s -c copy -map 0:0 -map 1:0 -bsf:a aac_adtstoasc", new Object[]{file.getAbsolutePath()});
//        } else {
//            str2 = String.format(Locale.US, "-f mp4 -i %s -c copy -map 0:0 -map 1:a:0 -bsf:a aac_adtstoasc", new Object[]{file.getAbsolutePath()});
//        }
//        arrayList.addAll(Arrays.asList(TextUtils.split(str2, StringUtils.SPACE)));
//        arrayList.add("-y");
//        if (list != null && list.size() > 0) {
//            arrayList.addAll(list);
//        }
//        arrayList.add("-movflags");
//        arrayList.add("+faststart");
//        File T = C4312xU.T(Environment.DIRECTORY_MOVIES, StickerHelper.MP4);
//        arrayList.add("-f");
//        arrayList.add("mp4");
//        arrayList.add(T.getAbsolutePath());
//        a(new FFmpegHandler(), (String[]) arrayList.toArray(new String[arrayList.size()]));
//        return T;
//    }
//
//    public static void a(float[] fArr, float[] fArr2) {
//        double d = (double) (fArr[0] / 2.0f);
//        double cos = Math.cos(d);
//        double d2 = (double) (fArr[1] / 2.0f);
//        double d3 = (double) (fArr[2] / 2.0f);
//        fArr2[0] = (float) ((Math.sin(d3) * Math.sin(d2) * Math.sin(d)) + (Math.cos(d3) * Math.cos(d2) * cos));
//        fArr2[1] = (float) ((Math.cos(d3) * (Math.cos(d2) * Math.sin(d))) - (Math.sin(d3) * (Math.sin(d2) * Math.sin(d))));
//        fArr2[2] = (float) ((Math.sin(d3) * Math.cos(d2) * Math.sin(d)) + (Math.cos(d3) * Math.sin(d2) * Math.cos(d)));
//        fArr2[3] = (float) ((Math.sin(d3) * (Math.cos(d2) * Math.cos(d))) - (Math.cos(d3) * (Math.sin(d2) * Math.sin(d))));
//    }
}