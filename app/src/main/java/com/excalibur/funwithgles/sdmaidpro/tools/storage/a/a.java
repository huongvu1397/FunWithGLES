//package com.excalibur.funwithgles.sdmaidpro.tools.storage.a;
//
//import eu.thedarken.sdm.tools.forensics.Location;
//import eu.thedarken.sdm.tools.io.g;
//import eu.thedarken.sdm.tools.io.p;
//import eu.thedarken.sdm.tools.storage.b;
//import eu.thedarken.sdm.tools.storage.f;
//import eu.thedarken.sdm.tools.storage.h;
//import eu.thedarken.sdm.tools.storage.k;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Map;
//
///* compiled from: CacheModule */
//public final class a extends h {
//    public a(k kVar) {
//        super(kVar);
//    }
//
//    public final Collection<f> a(Map<Location, Collection<f>> map) {
//        HashSet hashSet = new HashSet();
//        e();
//        p a2 = eu.thedarken.sdm.p.a();
//        b a3 = g.a(a(), a2);
//        if (a3 != null) {
//            f.a aVar = new f.a(Location.DOWNLOAD_CACHE);
//            aVar.f3927b = a3;
//            aVar.c = a2;
//            hashSet.add(aVar.a());
//        }
//        return hashSet;
//    }
//}