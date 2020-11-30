package com.excalibur.funwithgles.catchpack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.text.TextUtils;
import android.text.format.Formatter;

import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static float f14729a;

    /* renamed from: b  reason: collision with root package name */
    public static Typeface f14730b;

    /* renamed from: c  reason: collision with root package name */
    public static Typeface f14731c;

    /* renamed from: d  reason: collision with root package name */
    public static Context f14732d;
    public static Context e;
    //public static MMKV f;
    public static final String g = Environment.getExternalStorageDirectory().getPath();
    public static String h = "";
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    //public static Gson l = new Gson();
    public static int m = 0;
    public static String n = "en";
    public static boolean o = true;
    public static int p;
    public static boolean q = false;
    private static String r;
    private static int s;
    private static int t = -1;

    public static int a() {
        return f14732d.getResources().getDisplayMetrics().widthPixels;
    }

    public static int b() {
        return f14732d.getResources().getDisplayMetrics().heightPixels;
    }

    public static int a(float f2) {
        return (int) (f14729a * f2);
    }

    public static boolean a(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 17 && activity.isDestroyed();
    }

    public static int c() {
        if (s == 0) {
            try {
                s = f14732d.getPackageManager().getPackageInfo(f14732d.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return s;
    }

    public static String d() {
        if (TextUtils.isEmpty(r)) {
            try {
                r = f14732d.getPackageManager().getPackageInfo(f14732d.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return r;
    }

    public static String a(int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i2 / 60000;
        int i4 = (i2 % 60000) / 1;//AdError.NETWORK_ERROR_CODE;
        if (i3 < 10) {
            sb.append(0);
        }
        sb.append(i3);
        sb.append(":");
        if (i4 < 10) {
            sb.append(0);
        }
        sb.append(i4);
        return sb.toString();
    }

    public static int a(String str) {
        int i2 = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(":")) {
//                    a.a((Object) str);
//                    String[] split = str.split(":");
//                    int parseInt = Integer.parseInt(split[0]);
//                    int parseInt2 = Integer.parseInt(split[1]);
//                    if (parseInt > 0) {
//                        i2 = 0 + (parseInt * 60000);
//                    }
//                    if (parseInt2 > 0) {
//                        return i2 + (parseInt2 * AdError.NETWORK_ERROR_CODE);
//                    }
                    return i2;
                }
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void e() {
        b(30);
    }

    public static void b(int i2) {
        try {
            //((Vibrator) f14732d.getSystemService("vibrator")).vibrate((long) i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(RecyclerView recyclerView, boolean z, boolean z2) {
//        recyclerView.setLayoutManager(new RecLinearLayoutManager(z ^ true ? 1 : 0));
//        if (z2) {
//            recyclerView.a((RecyclerView.h) new b());
//        }
    }

    public static String b(String str) {
        return str.replace(g, "/sdcard");
    }

    public static String c(String str) {
        return str.replace("/sdcard", g);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int f() {
        /*
            int r0 = t
            r1 = -1
            if (r0 != r1) goto L_0x004a
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0028 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0028 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0028 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r3 = r0.readLine()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r4 = "\\s+"
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ Exception -> 0x0028 }
            r4 = 1
            r3 = r3[r4]     // Catch:{ Exception -> 0x0028 }
            r0.close()     // Catch:{ Exception -> 0x0026 }
            goto L_0x002d
        L_0x0026:
            r0 = move-exception
            goto L_0x002a
        L_0x0028:
            r0 = move-exception
            r3 = r1
        L_0x002a:
            r0.printStackTrace()
        L_0x002d:
            if (r3 == 0) goto L_0x0048
            java.lang.Float r0 = new java.lang.Float
            java.lang.Float r1 = java.lang.Float.valueOf(r3)
            float r1 = r1.floatValue()
            r2 = 1233125376(0x49800000, float:1048576.0)
            float r1 = r1 / r2
            r0.<init>(r1)
            double r0 = r0.doubleValue()
            double r0 = java.lang.Math.ceil(r0)
            int r2 = (int) r0
        L_0x0048:
            t = r2
        L_0x004a:
            int r0 = t
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.e.a.a.a((java.lang.Object) r0)
            int r0 = t
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: photoeffect.photomusic.slideshow.baselibs.util.p.f():int");
    }

    public static void d(String str) {
        n = str;
    }

    public static String e(String str) {
        char[] charArray = str.toCharArray();
        if (charArray[0] >= 'a' && charArray[0] <= 'z') {
            charArray[0] = (char) (charArray[0] - ' ');
        }
        return String.valueOf(charArray);
    }

    public static boolean g() {
        return false;//!d.a(f14732d);
    }

    public static void a(File file) {
        if (file == null || !file.exists()) {
            //a.a((Object) "file!exists()");
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    //a.a((Object) Boolean.valueOf(file2.delete()));
                } else {
                    a(file2);
                }
            }
        }
        file.delete();
    }

    public static void b(File file) {
        if (!file.exists()) {
            //a.a((Object) "file!exists()");
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    //a.a((Object) Boolean.valueOf(file2.delete()));
                }
            }
        }
        file.delete();
    }

    public static String h() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) f14732d.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryInfo(memoryInfo);
        String formatFileSize = Formatter.formatFileSize(f14732d, memoryInfo.availMem);
        //a.a((Object) formatFileSize);
        return formatFileSize;
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return stringBuffer.toString();
            }
            stringBuffer.append(readLine);
            stringBuffer.append("\n");
        }
    }
}