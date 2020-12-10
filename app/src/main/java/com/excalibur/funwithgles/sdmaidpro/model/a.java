//package com.excalibur.funwithgles.sdmaidpro.model;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.excalibur.funwithgles.sdmaidpro.tools.io.p;
//
//import java.util.ArrayList;
//
//public final class a implements Parcelable {
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
//    public final p f2435a;
//
//    /* renamed from: b  reason: collision with root package name */
//    public final d f2436b;
//    public List<p> c;
//    public boolean d;
//    long e;
//
//    public final int describeContents() {
//        return 0;
//    }
//
//    public a(p pVar, d dVar) {
//        this.c = new ArrayList();
//        this.d = true;
//        this.e = -1;
//        this.f2435a = pVar;
//        this.f2436b = dVar;
//    }
//
//    public final Location a() {
//        return this.f2436b.f3808a.f3805b;
//    }
//
//    public final long b() {
//        if (this.e == -1) {
//            this.e = this.f2435a.b();
//            for (p b2 : this.c) {
//                this.e += b2.b();
//            }
//        }
//        return this.e;
//    }
//
//    public final void writeToParcel(Parcel parcel, int i) {
//        parcel.writeParcelable(this.f2435a, i);
//        parcel.writeList(this.c);
//        parcel.writeByte(this.d ? (byte) 1 : 0);
//        parcel.writeLong(this.e);
//        parcel.writeParcelable(this.f2436b, i);
//    }
//
//    protected a(Parcel parcel) {
//        this.c = new ArrayList();
//        boolean z = true;
//        this.d = true;
//        this.e = -1;
//        this.f2435a = (p) parcel.readParcelable(p.class.getClassLoader());
//        this.c = new ArrayList();
//        parcel.readList(this.c, p.class.getClassLoader());
//        this.d = parcel.readByte() == 0 ? false : z;
//        this.e = parcel.readLong();
//        this.f2436b = (d) parcel.readParcelable(d.class.getClassLoader());
//    }
//
//    public final boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof a)) {
//            return false;
//        }
//        a aVar = (a) obj;
//        return this.f2435a.equals(aVar.f2435a) && this.d == aVar.d && this.c.equals(aVar.c) && this.e == aVar.e && !this.f2436b.equals(aVar.f2436b);
//    }
//
//    public final int hashCode() {
//        return ((((((((527 + this.f2435a.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.valueOf(this.d).hashCode()) * 31) + Long.valueOf(this.e).hashCode()) * 31) + this.f2436b.hashCode();
//    }
//
//    public final String toString() {
//        return this.f2435a.c();
//    }
//}