package com.excalibur.funwithgles.sdmaidpro.main.core;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.TransactionTooLargeException;
import android.util.Log;

import com.excalibur.funwithgles.App;
import com.excalibur.funwithgles.sdmaidpro.tools.io.SDMFile;

import java.util.List;
import java.util.concurrent.Semaphore;

/* compiled from: IPCFunnel */
public final class IPCFunnel {

    /* renamed from: a  reason: collision with root package name */
    static final String f2994a = App.self().a("IPCFunnel");

    /* renamed from: b  reason: collision with root package name */
    private final Semaphore f2995b = new Semaphore(1);
    private final PackageManager c;

    public IPCFunnel(Context context) {
        this.c = context.getPackageManager();
        Log.e("HVV1312","IPCFunnel initialized");
    }

    /* JADX INFO: finally extract failed */
    public final Intent a(String str) {
        try {
            this.f2995b.acquire();
            Intent launchIntentForPackage = this.c.getLaunchIntentForPackage(str);
            this.f2995b.release();
            return launchIntentForPackage;
        } catch (InterruptedException e) {
            Log.e("HVV1312","Intent InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return null;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final List<ResolveInfo> a(Intent intent) {
        try {
            this.f2995b.acquire();
            @SuppressLint("WrongConstant") List<ResolveInfo> queryBroadcastReceivers = this.c.queryBroadcastReceivers(intent, 544);
            this.f2995b.release();
            return queryBroadcastReceivers;
        } catch (InterruptedException e) {
            Log.e("HVV1312","List<ResolveInfo> InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return null;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final List<PackageInfo> a(int i) {
        try {
            this.f2995b.acquire();
            List<PackageInfo> a2 = a(this.c, i);
            this.f2995b.release();
            return a2;
        } catch (InterruptedException e) {
            Log.e("HVV1312","List<PackageInfo> InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return null;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }

    public final PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = null;
        try {
            this.f2995b.acquire();
            PackageInfo packageInfo2 = this.c.getPackageInfo(str, i);
            this.f2995b.release();
            return packageInfo2;
        } catch (PackageManager.NameNotFoundException e) {
            for (PackageInfo next : a(this.c, i)) {
                if (next.packageName.equals(str)) {
                    packageInfo = next;
                }
            }
            if (packageInfo == null) {
                throw e;
            }
        } catch (InterruptedException e2) {
            Log.e("HVV1312","PackageInfo InterruptedException 1"+ e2.getMessage());

        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
        this.f2995b.release();
        return packageInfo;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003a */
    public final String b(String str) {
        try {
            this.f2995b.acquire();
            @SuppressLint("WrongConstant") String charSequence = this.c.getApplicationInfo(str, 8192).loadLabel(this.c).toString();
            this.f2995b.release();
            return charSequence;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("HVV1312","b PackageManager.NameNotFoundException 1"+ e.getMessage());
        } catch (RuntimeException e) {
            Log.e("HVV1312","b RuntimeException 1"+ e.getMessage());
        } catch (InterruptedException e2) {
            Log.e("HVV1312","b InterruptedException 1"+ e2.getMessage());
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
        this.f2995b.release();
        return null;
    }

    public final String c(String str) {
        try {
            this.f2995b.acquire();
            String installerPackageName = this.c.getInstallerPackageName(str);
            this.f2995b.release();
            return installerPackageName;
        } catch (RuntimeException e) {
            Log.e("HVV1312","c RuntimeException 1"+ e.getMessage());
        } catch (InterruptedException e2) {
            Log.e("HVV1312","c InterruptedException 1"+ e2.getMessage());
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
        this.f2995b.release();
        return null;
    }

    @SuppressLint("WrongConstant")
    public final boolean d(String str) {
        try {
            this.f2995b.acquire();
            try {
                this.c.getPackageInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                this.f2995b.release();
                return false;
            }
        } catch (InterruptedException e) {
            Log.e("HVV1312","d InterruptedException 1"+ e.getMessage());
            return true;
        } finally {
            this.f2995b.release();
        }
    }

    private static List<PackageInfo> a(PackageManager packageManager, int i) {
        try {
            return packageManager.getInstalledPackages(i);
        } catch (Exception e) {
            if (e.getCause() instanceof TransactionTooLargeException) {
                throw new RuntimeException(f2994a + ":internalGetInstalledPackages(" + i + "):TransactionTooLargeException");
            }
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: finally extract failed */
    public final ApplicationInfo e(String str) throws PackageManager.NameNotFoundException {
        try {
            this.f2995b.acquire();
            ApplicationInfo applicationInfo = this.c.getApplicationInfo(str, 0);
            this.f2995b.release();
            return applicationInfo;
        } catch (InterruptedException e) {
            Log.e("HVV1312","e InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return null;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final PackageInfo a(SDMFile pVar, int i) {
        try {
            this.f2995b.acquire();
            PackageInfo packageArchiveInfo = this.c.getPackageArchiveInfo(pVar.c(), i);
            this.f2995b.release();
            return packageArchiveInfo;
        } catch (InterruptedException e) {
            Log.e("HVV1312","a InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return null;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Drawable f(String str) throws PackageManager.NameNotFoundException {
        try {
            this.f2995b.acquire();
            Drawable applicationIcon = this.c.getApplicationIcon(str);
            this.f2995b.release();
            return applicationIcon;
        } catch (InterruptedException e) {
            Log.e("HVV1312","f InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return null;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final ResolveInfo b(Intent intent) {
        try {
            this.f2995b.acquire();
            @SuppressLint("WrongConstant") ResolveInfo resolveActivity = this.c.resolveActivity(intent, 65536);
            this.f2995b.release();
            return resolveActivity;
        } catch (InterruptedException e) {
            Log.e("HVV1312","b InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return null;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final int a(ComponentName componentName) {
        try {
            this.f2995b.acquire();
            int componentEnabledSetting = this.c.getComponentEnabledSetting(componentName);
            this.f2995b.release();
            return componentEnabledSetting;
        } catch (InterruptedException e) {
            Log.e("HVV1312","a InterruptedException 1"+ e.getMessage());
            this.f2995b.release();
            return 0;
        } catch (Throwable th) {
            this.f2995b.release();
            throw th;
        }
    }
}