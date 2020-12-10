//package com.excalibur.funwithgles.sdmaidpro.model;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import com.excalibur.funwithgles.sdmaidpro.tools.io.p;
//
//public class b implements Parcelable {
//    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
//        public final /* bridge */ /* synthetic */ b[] newArray(int i) {
//            return new b[i];
//        }
//
//        public final /* synthetic */ b createFromParcel(Parcel parcel) {
//            return new b(parcel);
//        }
//    };
//
//    /* renamed from: a  reason: collision with root package name */
//    public final String f3804a;
//
//    /* renamed from: b  reason: collision with root package name */
//    public final Location f3805b;
//    public final Boolean c;
//    public final p d;
//    public final f e;
//    public final eu.thedarken.sdm.tools.storage.b f;
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public b(p pVar, Location location, String str, eu.thedarken.sdm.tools.storage.b bVar) {
//        this(pVar, location, str, false, (f) null, bVar);
//    }
//
//    public b(p pVar, Location location, String str, boolean z, f fVar) {
//        this(pVar, location, str, z, fVar, (eu.thedarken.sdm.tools.storage.b) null);
//    }
//
//    private b(p pVar, Location location, String str, boolean z, f fVar, eu.thedarken.sdm.tools.storage.b bVar) {
//        this.d = pVar;
//        this.f3805b = location;
//        this.f3804a = str;
//        this.c = Boolean.valueOf(z);
//        this.e = fVar;
//        if (fVar != null) {
//            this.f = fVar.c;
//        } else {
//            this.f = bVar;
//        }
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(this.d.c());
//        parcel.writeString(this.f3804a);
//        parcel.writeString(this.f3805b.name());
//        parcel.writeString(this.c.toString());
//        parcel.writeParcelable(this.e, i);
//        parcel.writeParcelable(this.f, i);
//    }
//
//    protected b(Parcel parcel) {
//        this.d = i.a(parcel.readString());
//        this.f3804a = parcel.readString();
//        this.f3805b = Location.valueOf(parcel.readString());
//        this.c = Boolean.valueOf(Boolean.parseBoolean(parcel.readString()));
//        this.e = (f) parcel.readParcelable(f.class.getClassLoader());
//        this.f = (eu.thedarken.sdm.tools.storage.b) parcel.readParcelable(eu.thedarken.sdm.tools.storage.b.class.getClassLoader());
//    }
//
//    public final String a() {
//        return this.d.c().replace(this.f3804a, "");
//    }
//
//    public final boolean b() {
//        if (this.f != null && this.f.a()) {
//            if (this.e != null) {
//                if (!this.e.a(f.b.EMULATED)) {
//                    return true;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof b)) {
//            return false;
//        }
//        b bVar = (b) obj;
//        return this.f3804a.equals(bVar.f3804a) && this.f3805b.equals(bVar.f3805b) && this.d.equals(bVar.d) && this.c == bVar.c;
//    }
//
//    public int hashCode() {
//        return ((((((527 + this.f3804a.hashCode()) * 31) + this.f3805b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.c.hashCode();
//    }
//
//    public String toString() {
//        return "LocationInfo(file=" + this.d.toString() + ", location=" + this.f3805b.toString() + ", prefix=" + this.f3804a + ", blacklist=" + this.c + ", storage=" + this.e + ")";
//    }
//}