//package com.excalibur.funwithgles.sdmaidpro.tools.io;
//
//import android.content.Context;
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.excalibur.funwithgles.App;
//import com.excalibur.funwithgles.sdmaidpro.tools.binaries.sdmbox.applets.StatApplet;
//import com.excalibur.funwithgles.sdmaidpro.tools.io.shell.a;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//
//public final class i implements Parcelable, p {
//    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() {
//        public final /* bridge */ /* synthetic */ i[] newArray(int i) {
//            return new i[i];
//        }
//
//        public final /* synthetic */ i createFromParcel(Parcel parcel) {
//            return new i(parcel);
//        }
//    };
//
//    /* renamed from: a  reason: collision with root package name */
//    static final String f3838a = App.self().a("JavaFile");
//
//    /* renamed from: b  reason: collision with root package name */
//    public final File f3839b;
//
//    public final int describeContents() {
//        return 0;
//    }
//
//    private i(File file) {
//        this.f3839b = file;
//    }
//
//    public static i a(p pVar, String... strArr) {
//        return a(pVar.d(), strArr);
//    }
//
//    public static i a(File file, String... strArr) {
//        String[] strArr2 = new String[(strArr.length + 1)];
//        strArr2[0] = file.getPath();
//        if (strArr.length > 0) {
//            System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
//        }
//        return a(strArr2);
//    }
//
//    public static i a(String... strArr) {
//        File file = new File(strArr[0]);
//        int i = 1;
//        while (i < strArr.length) {
//            i++;
//            file = new File(file, strArr[i]);
//        }
//        return new i(file);
//    }
//
//    public static i b(p pVar, String... strArr) {
//        return new i(a(pVar.d(), strArr).f3839b.getAbsoluteFile());
//    }
//
//    public static i b(File file, String... strArr) {
//        return new i(a(file, strArr).f3839b.getAbsoluteFile());
//    }
//
//    public static i b(String... strArr) {
//        return new i(a(strArr).f3839b.getAbsoluteFile());
//    }
//
//    public final long a() {
//        return this.f3839b.length();
//    }
//
//    public final String c() {
//        return this.f3839b.getPath();
//    }
//
//    public final File d() {
//        return this.f3839b;
//    }
//
//    public final String e() {
//        return this.f3839b.getName();
//    }
//
//    public final String f() {
//        return this.f3839b.getParent();
//    }
//
//    public final p g() {
//        File parentFile = this.f3839b.getParentFile();
//        if (parentFile == null) {
//            return null;
//        }
//        return new i(parentFile);
//    }
//
//    public final boolean h() {
//        return this.f3839b.isDirectory();
//    }
//
//    public final boolean i() {
//        return this.f3839b.isFile();
//    }
//
//    public final p r() {
//        try {
//            return new i(this.f3839b.getCanonicalFile());
//        } catch (IOException e) {
//            a.b(f3838a).d(e, (String) null, new Object[0]);
//            return this;
//        }
//    }
//
//    public final String s() {
//        p r = r();
//        if (r != null) {
//            return r.c();
//        }
//        return null;
//    }
//
//    public final boolean j() {
//        try {
//            if (!this.f3839b.equals(this.f3839b.getCanonicalFile())) {
//                return true;
//            }
//            return false;
//        } catch (IOException e) {
//            a.b(f3838a).d(e, (String) null, new Object[0]);
//            return false;
//        }
//    }
//
//    public final boolean k() {
//        return this.f3839b.canRead();
//    }
//
//    public final Date l() {
//        return new Date(this.f3839b.lastModified());
//    }
//
//    public final int n() {
//        throw new UnsupportedOperationException("getGroupID");
//    }
//
//    public final int o() {
//        throw new UnsupportedOperationException("getUserID");
//    }
//
//    public final int p() {
//        throw new UnsupportedOperationException("getPermissionsOctal");
//    }
//
//    public final String q() {
//        throw new UnsupportedOperationException("getUniqueIdentifier");
//    }
//
//    protected i(Parcel parcel) {
//        this.f3839b = new File(parcel.readString());
//    }
//
//    public final void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(this.f3839b.getPath());
//    }
//
//    public final boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || !(obj instanceof p)) {
//            return false;
//        }
//        return this.f3839b.getPath().equals(((p) obj).c());
//    }
//
//    public final String a(Context context) {
//        StatApplet.a aVar;
//        String str;
//        if (j()) {
//            aVar = StatApplet.a.SYMBOLIC_LINK;
//        } else if (this.f3839b.isDirectory()) {
//            aVar = StatApplet.a.DIRECTORY;
//        } else {
//            aVar = StatApplet.a.FILE;
//        }
//        Locale locale = Locale.US;
//        Object[] objArr = new Object[7];
//        objArr[0] = aVar;
//        objArr[1] = 0;
//        objArr[2] = 0;
//        objArr[3] = 0;
//        objArr[4] = Formatter.formatFileSize(context, this.f3839b.length());
//        objArr[5] = g.format(l());
//        if (aVar == StatApplet.a.SYMBOLIC_LINK) {
//            str = this.f3839b.getPath() + " -> " + s();
//        } else {
//            str = this.f3839b.getPath();
//        }
//        objArr[6] = str;
//        return String.format(locale, "%-9.9s %4d %5d:%5d %10.10s %19.19s %s", objArr);
//    }
//
//    public static i a(i iVar) {
//        if (iVar.f3839b.isAbsolute()) {
//            return iVar;
//        }
//        throw new IllegalPathException("Not absolute: " + iVar.f3839b.getPath());
//    }
//
//    public final boolean m() {
//        if (!this.f3839b.isDirectory()) {
//            return this.f3839b.length() == 0;
//        }
//        File[] listFiles = this.f3839b.listFiles();
//        return this.f3839b.canRead() && listFiles != null && listFiles.length == 0;
//    }
//
//    public final long b() {
//        return this.f3839b.length();
//    }
//
//    public final int hashCode() {
//        return this.f3839b.getPath().hashCode();
//    }
//
//    public final String toString() {
//        return this.f3839b.getPath();
//    }
//}