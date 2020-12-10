//package com.excalibur.funwithgles.sdmaidpro.model;
//
//import android.net.Uri;
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.excalibur.funwithgles.sdmaidpro.tools.io.p;
//
//import java.util.Collections;
//import java.util.HashSet;
//
///* compiled from: Storage */
//public class f implements Parcelable {
//    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() {
//        public final /* bridge */ /* synthetic */ com.excalibur.funwithgles.sdmaidpro.model.f[] newArray(int i) {
//            return new f[i];
//        }
//
//        public final /* synthetic */ com.excalibur.funwithgles.sdmaidpro.model.f createFromParcel(Parcel parcel) {
//            return new f(parcel);
//        }
//    };
//
//    /* renamed from: a  reason: collision with root package name */
//    public final p f3924a;
//
//    /* renamed from: b  reason: collision with root package name */
//    public final long f3925b;
//    public final b c;
//    public final Location d;
//    public final HashSet<b> e;
//    public c f;
//    public Uri g;
//    public String h;
//
//    /* compiled from: Storage */
//    public enum b {
//        PRIMARY,
//        SECONDARY,
//        EMULATED
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//
//    f(a aVar) {
//        this.d = aVar.f3926a;
//        this.f3924a = aVar.c;
//        this.c = aVar.f3927b;
//        this.f3925b = aVar.e;
//        this.e = aVar.f;
//        this.f = aVar.d;
//    }
//
//    protected f(Parcel parcel) {
//        this.f3924a = i.a(parcel.readString());
//        this.c = (b) parcel.readParcelable(b.class.getClassLoader());
//        this.d = (Location) parcel.readParcelable(Location.class.getClassLoader());
//        this.f3925b = parcel.readLong();
//        this.g = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
//        this.h = (String) parcel.readValue(String.class.getClassLoader());
//        this.e = (HashSet) parcel.readSerializable();
//        this.f = (c) parcel.readValue(c.class.getClassLoader());
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(this.f3924a.c());
//        parcel.writeParcelable(this.c, i);
//        parcel.writeParcelable(this.d, i);
//        parcel.writeLong(this.f3925b);
//        parcel.writeParcelable(this.g, i);
//        parcel.writeValue(this.h);
//        parcel.writeSerializable(this.e);
//        parcel.writeValue(this.f);
//    }
//
//    public final boolean a(b... bVarArr) {
//        int i = 0;
//        for (int i2 = 0; i2 <= 0; i2++) {
//            if (this.e.contains(bVarArr[0])) {
//                i++;
//            }
//        }
//        return 1 == i;
//    }
//
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof f)) {
//            return false;
//        }
//        f fVar = (f) obj;
//        return this.c.equals(fVar.c) && this.e.size() == fVar.e.size() && this.e.containsAll(fVar.e) && this.f3925b == fVar.f3925b && this.d.equals(fVar.d) && this.f3924a.equals(fVar.f3924a);
//    }
//
//    public int hashCode() {
//        return ((((((((527 + this.c.hashCode()) * 31) + this.e.hashCode()) * 31) + Long.valueOf(this.f3925b).hashCode()) * 31) + this.d.hashCode()) * 31) + this.f3924a.hashCode();
//    }
//
//    public String toString() {
//        return "Storage(location=" + this.d.name() + ", path=" + this.f3924a.c() + ", userHandle=" + this.f3925b + ", flags=" + this.e + ", safUri=" + this.g + ", mount=" + this.c + ")";
//    }
//
//    /* compiled from: Storage */
//    public static class a {
//
//        /* renamed from: a  reason: collision with root package name */
//        final Location f3926a;
//
//        /* renamed from: b  reason: collision with root package name */
//        public b f3927b;
//        public p c;
//        public c d;
//        public long e = -1;
//        final HashSet<b> f = new HashSet<>();
//
//        public a(Location location) {
//            this.f3926a = location;
//        }
//
//        public final a a(b... bVarArr) {
//            Collections.addAll(this.f, bVarArr);
//            return this;
//        }
//
//        public final a a(f fVar) {
//            this.f.addAll(fVar.e);
//            return this;
//        }
//
//        public final f a() {
//            if (this.c == null) {
//                throw new IllegalArgumentException("Missing path for " + this.f3926a);
//            } else if (this.f3927b != null) {
//                return new f(this);
//            } else {
//                throw new IllegalArgumentException("Missing mount for " + this.f3926a + " at " + this.c);
//            }
//        }
//    }
//}