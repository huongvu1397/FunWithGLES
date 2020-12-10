//package com.excalibur.funwithgles.sdmaidpro.tools.io.shell;
//
//import android.content.Context;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.text.format.Formatter;
//
//import com.excalibur.funwithgles.App;
//import com.excalibur.funwithgles.sdmaidpro.tools.binaries.sdmbox.applets.StatApplet;
//import com.excalibur.funwithgles.sdmaidpro.tools.io.p;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Locale;
//
///* compiled from: ShellFile */
//public final class a implements Parcelable, p {
//    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
//        public final /* bridge */ /* synthetic */ a[] newArray(int i) {
//            return new a[i];
//        }
//
//        public final /* synthetic */ a createFromParcel(Parcel parcel) {
//            return new a(parcel);
//        }
//    };
//
//    /* renamed from: a  reason: collision with root package name */
//    static final String f3849a = App.self().a("ShellFile");
//
//    /* renamed from: b  reason: collision with root package name */
//    public final StatApplet.a f3850b;
//    public final File c;
//    private final int d;
//    private final int e;
//    private final long f;
//    private final int h;
//    private final int i;
//    private final long j;
//    private final Date k;
//    private final p l;
//    private final int m;
//    private final long n;
//
//    public final int describeContents() {
//        return 0;
//    }
//
//    public a(int i2, StatApplet.a aVar, int i3, long j2, int i4, int i5, long j3, int i6, long j4, Date date, File file, p pVar) {
//        this.d = i2;
//        this.f3850b = aVar;
//        this.e = i3;
//        this.f = j2;
//        this.h = i4;
//        this.i = i5;
//        this.j = j3;
//        this.m = i6;
//        this.n = j4;
//        this.k = date;
//        this.c = file;
//        this.l = pVar;
//    }
//
//    public static String a(com.excalibur.funwithgles.sdmaidpro.tools.binaries.sdmbox.a  aVar, p pVar, k.b bVar, boolean z, boolean z2) {
//        ArrayList arrayList = new ArrayList();
//        if (bVar != k.b.ALL) {
//            arrayList.add(new FindApplet.d(bVar.g));
//        }
//        if (bVar != k.b.ITEM) {
//            arrayList.add(new FindApplet.f());
//        }
//        arrayList.add(new FindApplet.j());
//        a.C0086a b2 = aVar.b(z2);
//        StringBuilder sb = new StringBuilder();
//        sb.append(b2.e().c(pVar));
//        sb.append(" || ");
//        sb.append(b2.m().a(z ? FindApplet.a.ALL_SYMLINKS : null, pVar, arrayList));
//        sb.append(" | ");
//        sb.append(b2.p().a(Arrays.asList(new XargsApplet.d[]{new XargsApplet.c(), new XargsApplet.b(), new XargsApplet.a()})));
//        sb.append(" ");
//        sb.append(b2.b().m_());
//        return sb.toString();
//    }
//
//    public final boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || !(obj instanceof p)) {
//            return false;
//        }
//        return this.c.getPath().equals(((p) obj).c());
//    }
//
//    public final long a() {
//        return this.j;
//    }
//
//    public final long b() {
//        return this.n * 512;
//    }
//
//    public final String c() {
//        return this.c.getPath();
//    }
//
//    public final File d() {
//        return this.c;
//    }
//
//    public final String e() {
//        return this.c.getName();
//    }
//
//    public final String f() {
//        return this.c.getParent();
//    }
//
//    public final p g() {
//        File parentFile = this.c.getParentFile();
//        if (parentFile == null) {
//            return null;
//        }
//        return i.a(parentFile, new String[0]);
//    }
//
//    public final boolean h() {
//        return this.f3850b == StatApplet.a.DIRECTORY;
//    }
//
//    public final boolean i() {
//        return this.f3850b == StatApplet.a.FILE || this.f3850b == StatApplet.a.EMPTY_FILE;
//    }
//
//    public final boolean j() {
//        return this.f3850b == StatApplet.a.SYMBOLIC_LINK;
//    }
//
//    public final boolean k() {
//        return this.c.canRead();
//    }
//
//    public final Date l() {
//        return this.k;
//    }
//
//    public final boolean m() {
//        if (this.f3850b != StatApplet.a.DIRECTORY) {
//            return this.j == 0 || this.f3850b == StatApplet.a.EMPTY_FILE;
//        }
//        File[] listFiles = this.c.listFiles();
//        return this.c.canRead() && listFiles != null && listFiles.length == 0;
//    }
//
//    public final int n() {
//        return this.i;
//    }
//
//    public final int o() {
//        return this.h;
//    }
//
//    public final int p() {
//        return this.d;
//    }
//
//    public final String q() {
//        return this.e + ":" + this.f;
//    }
//
//    public final p r() {
//        return this.l;
//    }
//
//    public final String s() {
//        if (this.l != null) {
//            return this.l.c();
//        }
//        return null;
//    }
//
//    public final void writeToParcel(Parcel parcel, int i2) {
//        parcel.writeInt(this.d);
//        parcel.writeString(this.f3850b.name());
//        parcel.writeInt(this.e);
//        parcel.writeLong(this.f);
//        parcel.writeInt(this.h);
//        parcel.writeInt(this.i);
//        parcel.writeLong(this.j);
//        parcel.writeInt(this.m);
//        parcel.writeLong(this.n);
//        parcel.writeLong(this.k.getTime());
//        parcel.writeString(this.c.getPath());
//        parcel.writeString(this.l.c());
//    }
//
//    protected a(Parcel parcel) {
//        this.d = parcel.readInt();
//        this.f3850b = StatApplet.a.valueOf(parcel.readString());
//        this.e = parcel.readInt();
//        this.f = parcel.readLong();
//        this.h = parcel.readInt();
//        this.i = parcel.readInt();
//        this.j = parcel.readLong();
//        this.m = parcel.readInt();
//        this.n = parcel.readLong();
//        this.k = new Date(parcel.readLong());
//        this.c = new File(parcel.readString());
//        this.l = i.a(parcel.readString());
//    }
//
//    public final String toString() {
//        return this.c.getPath();
//    }
//
//    public final String a(Context context) {
//        String str;
//        Locale locale = Locale.US;
//        Object[] objArr = new Object[7];
//        objArr[0] = this.f3850b;
//        objArr[1] = Integer.valueOf(this.d);
//        objArr[2] = Integer.valueOf(this.h);
//        objArr[3] = Integer.valueOf(this.i);
//        objArr[4] = Formatter.formatFileSize(context, b());
//        objArr[5] = g.format(this.k);
//        if (this.f3850b == StatApplet.a.SYMBOLIC_LINK) {
//            str = this.c.getPath() + " -> " + this.c.getPath();
//        } else {
//            str = s();
//        }
//        objArr[6] = str;
//        return String.format(locale, "%-9.9s %4d %5d:%5d %10.10s %19.19s %s", objArr);
//    }
//
//    public final int hashCode() {
//        return this.c.getPath().hashCode();
//    }
//}