//package com.excalibur.funwithgles.sdmaidpro.model;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.airbnb.lottie.model.Marker;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class d implements Parcelable {
//    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() {
//        public final /* bridge */ /* synthetic */ d[] newArray(int i) {
//            return new d[i];
//        }
//
//        public final /* synthetic */ d createFromParcel(Parcel parcel) {
//            return new d(parcel);
//        }
//    };
//
//    /* renamed from: a  reason: collision with root package name */
//    public final b f3808a;
//
//    /* renamed from: b  reason: collision with root package name */
//    public final List<c> f3809b;
//    public boolean c;
//    private Boolean d;
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public d(b bVar) {
//        this.f3809b = new ArrayList();
//        this.c = false;
//        this.d = null;
//        this.f3808a = bVar;
//    }
//
//    public final void a(Collection<Marker.a> collection) {
//        for (Marker.a a2 : collection) {
//            a(a2);
//        }
//    }
//
//    public final void a(c cVar) {
//        this.f3809b.add(cVar);
//    }
//
//    public final boolean a() {
//        for (c a2 : this.f3809b) {
//            if (a2.a(Marker.Flag.KEEPER)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public final boolean b() {
//        for (c a2 : this.f3809b) {
//            if (a2.a(Marker.Flag.COMMON)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeList(this.f3809b);
//        parcel.writeParcelable(this.f3808a, 0);
//        parcel.writeByte(this.c ? (byte) 1 : 0);
//    }
//
//    protected d(Parcel parcel) {
//        this.f3809b = new ArrayList();
//        boolean z = false;
//        this.c = false;
//        this.d = null;
//        parcel.readList(this.f3809b, c.class.getClassLoader());
//        this.f3808a = (b) parcel.readParcelable(b.class.getClassLoader());
//        this.c = parcel.readByte() != 0 ? true : z;
//    }
//
//    public final void a(Boolean bool) {
//        this.c = bool.booleanValue();
//    }
//
//    public final boolean c() {
//        return this.f3808a.c.booleanValue() ? !d().booleanValue() : !d().booleanValue() && this.f3809b.size() > 0;
//    }
//
//    public final Boolean d() {
//        if (this.d != null) {
//            return this.d;
//        }
//        throw new RuntimeException("checkOwnerState(...) has not been called!");
//    }
//
//    public final c a(String str) {
//        for (c next : this.f3809b) {
//            if (next.f3806a.equals(str)) {
//                return next;
//            }
//        }
//        return null;
//    }
//
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        d dVar = (d) obj;
//        if (this.c != dVar.c || !this.f3808a.equals(dVar.f3808a) || !this.f3809b.equals(dVar.f3809b)) {
//            return false;
//        }
//        if (this.d != null) {
//            return this.d.equals(dVar.d);
//        }
//        return dVar.d == null;
//    }
//
//    public int hashCode() {
//        return (31 * ((((this.f3808a.hashCode() * 31) + this.f3809b.hashCode()) * 31) + (this.c ? 1 : 0))) + (this.d != null ? this.d.hashCode() : 0);
//    }
//
//    public String toString() {
//        return "OwnerInfo(path=" + this.f3808a.d + ", owners=" + this.f3809b + ")";
//    }
//
//    public final void a(Marker.a aVar) {
//        for (String cVar : aVar.f3661a) {
//            this.f3809b.add(new c(cVar, aVar.a()));
//        }
//    }
//
//    public final boolean a(a aVar) {
//        for (c next : this.f3809b) {
//            next.f3807b = Boolean.valueOf(aVar.a(next.f3806a));
//            if (next.f3807b.booleanValue()) {
//                this.d = true;
//            }
//        }
//        if (this.c) {
//            this.d = true;
//        }
//        if (this.d == null) {
//            this.d = false;
//        }
//        return this.d.booleanValue();
//    }
//}