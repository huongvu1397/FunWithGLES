package com.excalibur.funwithgles.sdmaidpro.tools.apps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;

import com.excalibur.funwithgles.App;
import com.excalibur.funwithgles.sdmaidpro.tools.ApiHelper;
import com.excalibur.funwithgles.sdmaidpro.tools.StringUtils;
import com.excalibur.funwithgles.sdmaidpro.tools.ValueBox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AppTools */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final String f3557a = App.self().a("AppTools");

    public static boolean a(Context context) {
        if (ApiHelper.g()) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Method[] declaredMethods = packageManager.getClass().getDeclaredMethods();
        final Object obj = new Object();
        synchronized (obj) {
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method = declaredMethods[i];
                if (method.getName().equals("freeStorageAndNotify")) {
                    Object r0 = new IPackageStatsObserver.Stub() {
                        @Override
                        public void onGetStatsCompleted(PackageStats pStats, boolean succeeded) throws RemoteException {
                            Log.e("HVV1312","success: "+succeeded+ " object "+ new Object[0]);
                            synchronized (obj) {
                                obj.notify();
                            }
                        }

                        public final void onRemoveCompleted(String str, boolean z) {
                            //a.b b2 = b.a.a.b(a.f3557a);
                            //b2.b(str + " success:" + z, new Object[0]);
                        }
                    };



                    if (method.getGenericParameterTypes().length == 2) {
                        try {
                            method.invoke(packageManager, new Object[]{Long.MAX_VALUE, r0});
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } else if (ApiHelper.f() && method.getGenericParameterTypes().length == 3) {
                        try {
                            method.invoke(packageManager, new Object[]{null, Long.MAX_VALUE, r0});
                        } catch (IllegalAccessException e) {
                            Log.e("HVV1312","catch invoke 1 : "+e.getMessage());
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            Log.e("HVV1312","catch invoke 2 :"+e.getMessage());
                            e.printStackTrace();
                        }
                    }
                } else {
                    i++;
                }
            }
            try {
                obj.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static long a(Context context, String str) {
        PackageStats d;
        if (!ApiHelper.j() && (d = d(context, str)) != null) {
            return d.cacheSize;
        }
        return -1;
    }

    public static long b(Context context, String str) {
        PackageStats d = d(context, str);
        if (d == null) {
            return -1;
        }
        return d.dataSize + d.cacheSize;
    }

    private static PackageStats d(Context context, final String str) {
        final ValueBox aqVar = new ValueBox();
        try {
            PackageManager packageManager = context.getPackageManager();
            synchronized (aqVar) {
                if (ApiHelper.j()) {
                    packageManager.getClass().getMethod("getPackageSizeInfoAsUser", new Class[]{String.class, Integer.TYPE, IPackageStatsObserver.class}).invoke(packageManager, new Object[]{str, 0, new IPackageStatsObserver.Stub() {
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            synchronized (aqVar) {
                                aqVar.f3562a = packageStats;
                                aqVar.notify();
                            }
                        }
                    }});
                } else {
                    packageManager.getClass().getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(packageManager, new Object[]{str, new IPackageStatsObserver.Stub() {
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            synchronized (aqVar) {
                                if (packageStats == null || !z) {
                                    //b.a.a.a("Failed to get PackageStats for %s", str);
                                    Log.e("HVV1312","failed to get PackageStats");
                                }
                                aqVar.f3562a = packageStats;
                                aqVar.notify();
                            }
                        }
                    }});
                }
                aqVar.wait(5000);
            }
        } catch (IllegalAccessException | InterruptedException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("HVV1312","failed to query package stats");
        }
        return (PackageStats) aqVar.f3562a;
    }

    public static void c(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        context.startActivity(intent);
    }

    public static String a(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.applicationInfo == null || StringUtils.a(packageInfo.applicationInfo.sourceDir)) {
            return null;
        }
        return packageInfo.applicationInfo.sourceDir;
    }
}