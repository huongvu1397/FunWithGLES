package com.excalibur.funwithgles.sdmaidpro.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import android.os.storage.StorageVolume;

import com.excalibur.funwithgles.App;
import com.excalibur.funwithgles.sdmaidpro.tools.ApiHelper;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* compiled from: StorageVolumeX */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        public final /* bridge */ /* synthetic */ com.excalibur.funwithgles.sdmaidpro.model.c[] newArray(int i) {
            return new c[i];
        }

        public final /* synthetic */ com.excalibur.funwithgles.sdmaidpro.model.c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    static final String f3940a = App.self().a("StorageVolumeX");

    /* renamed from: b  reason: collision with root package name */
    public Object f3941b;
    private final Class<?> c = this.f3941b.getClass();

    public c(com.excalibur.funwithgles.sdmaidpro.model.c f3941b) {
        this.f3941b = f3941b;
    }

    public int describeContents() {
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final boolean a() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (ApiHelper.h()) {
            return ((StorageVolume) this.f3941b).isPrimary();
        }
        return ((Boolean) this.c.getMethod("isPrimary", new Class[0]).invoke(this.f3941b, new Object[0])).booleanValue();
    }

    @SuppressLint({"NewApi"})
    public final boolean b() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (ApiHelper.h()) {
            return ((StorageVolume) this.f3941b).isEmulated();
        }
        return ((Boolean) this.c.getMethod("isEmulated", new Class[0]).invoke(this.f3941b, new Object[0])).booleanValue();
    }

    @SuppressLint({"NewApi"})
    public final String c() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (ApiHelper.h()) {
            return ((StorageVolume) this.f3941b).getUuid();
        }
        return (String) this.c.getMethod("getUuid", new Class[0]).invoke(this.f3941b, new Object[0]);
    }

    @SuppressLint({"NewApi"})
    public final String d()throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (ApiHelper.h()) {
            return ((StorageVolume) this.f3941b).getState();
        }
        return (String) this.c.getMethod("getState", new Class[0]).invoke(this.f3941b, new Object[0]);
    }

    @SuppressLint({"NewApi"})
    public final String e() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        return (String) this.c.getMethod("getPath", new Class[0]).invoke(this.f3941b, new Object[0]);
    }

    @SuppressLint({"NewApi"})
    public final File f() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        return (File) this.c.getMethod("getPathFile", new Class[0]).invoke(this.f3941b, new Object[0]);
    }

    @SuppressLint({"NewApi"})
    public final String a(Context context) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        try {
            return (String) this.c.getMethod("getDescription", new Class[]{Context.class}).invoke(this.f3941b, new Object[]{context});
        } catch (Resources.NotFoundException e) {
            //b.a.a.b(f3940a).c(e);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public final UserHandle g() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        if (ApiHelper.l()) {
            UserHandle userHandleForUid = UserHandle.getUserHandleForUid(0);
            //b.a.a.b(f3940a).d("Android P workaround, assuming owner is %s", userHandleForUid);
            return userHandleForUid;
        }
        try {
            return (UserHandle) this.c.getMethod("getOwner", new Class[0]).invoke(this.f3941b, new Object[0]);
        } catch (Resources.NotFoundException e) {
            //b.a.a.b(f3940a).c(e);
            return null;
        }
    }

    public String toString() {
        try {
            return "StorageVolumeX(uuid=" + c() + ", state=" + d() + ", path=" + e() + ", primary=" + a() + ", emulated=" + b() + ", owner=" + g() + ", userlabel=" + ((String) this.c.getMethod("getUserLabel", new Class[0]).invoke(this.f3941b, new Object[0])) + ")";
        } catch (ReflectiveOperationException e) {
            return e.getMessage();
        }
    }

    protected c(Parcel parcel) {
        this.f3941b = parcel.readParcelable(getClass().getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable((Parcelable) this.f3941b, 0);
    }
}