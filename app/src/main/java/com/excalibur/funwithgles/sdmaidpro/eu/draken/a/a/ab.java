//package com.excalibur.funwithgles.sdmaidpro.eu.draken.a.a;
//
//import android.support.v4.e.j;
//import eu.darken.a.a.a;
//import eu.darken.a.a.g;
//import eu.darken.a.a.z;
//import eu.darken.a.b.c;
//import eu.darken.a.c.e;
//import eu.darken.a.c.h;
//import eu.darken.a.c.u;
//import eu.darken.a.e.b;
//import io.reactivex.d.f;
//import io.reactivex.e.e.c.i;
//import io.reactivex.n;
//import io.reactivex.t;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///* compiled from: RxCmdShell */
//public final class ab {
//
//    /* renamed from: a  reason: collision with root package name */
//    final Map<String, String> f1944a;
//
//    /* renamed from: b  reason: collision with root package name */
//    final eu.darken.a.e.b f1945b;
//    final g.a c;
//    t<b> d;
//
//    private ab() {
//        throw new InstantiationException("Use the builder()!");
//    }
//
//    ab(a aVar, eu.darken.a.e.b bVar) {
//        this.f1944a = aVar.f1948a;
//        this.c = aVar.f1949b;
//        this.f1945b = bVar;
//    }
//
//    public final synchronized t<b> a() {
//        if (c.a()) {
//            b.a.a.b("RXS:RxCmdShell").a("open()", new Object[0]);
//        }
//        if (this.d == null) {
//            this.d = t.a(new ac(this)).b(io.reactivex.i.a.b()).a(new ad(this)).b((f<? super Throwable>) ae.f1954a).a();
//        }
//        return this.d;
//    }
//
//    /* compiled from: RxCmdShell */
//    public static class b {
//
//        /* renamed from: a  reason: collision with root package name */
//        final b.a f1950a;
//
//        /* renamed from: b  reason: collision with root package name */
//        final t<Integer> f1951b;
//        public final io.reactivex.b c;
//        private final g d;
//        private final t<Integer> e;
//
//        public b(b.a aVar, g gVar) {
//            this.f1950a = aVar;
//            this.d = gVar;
//            this.f1951b = aVar.b().a();
//            this.c = aVar.a().a(ai.f1958a).a((f<? super Throwable>) aj.f1959a).a();
//            n<Boolean> a2 = gVar.f1973b.a(s.f1993a).a(ak.f1960a);
//            io.reactivex.e.b.b.a(true, "defaultItem is null");
//            this.e = io.reactivex.g.a.a(new i(a2, true)).a(new al(aVar)).a(am.f1962a).b((f<? super Throwable>) an.f1963a).a();
//        }
//
//        public final t<a.b> a(a aVar) {
//            return t.a(new h(this.d, aVar)).a(i.f1981a);
//        }
//
//        public final t<Integer> a() {
//            if (c.a()) {
//                b.a.a.b("RXS:RxCmdShell:Session").a("close()", new Object[0]);
//            }
//            return this.e;
//        }
//    }
//
//    /* compiled from: RxCmdShell */
//    public static class a {
//
//        /* renamed from: a  reason: collision with root package name */
//        final Map<String, String> f1948a = new HashMap();
//
//        /* renamed from: b  reason: collision with root package name */
//        final g.a f1949b = new g.a(new z.c());
//        public boolean c = false;
//        private final List<eu.darken.a.b.b> d = new ArrayList();
//
//        public final a a(eu.darken.a.b.b bVar) {
//            this.d.add(bVar);
//            return this;
//        }
//
//        public final ab a() {
//            for (eu.darken.a.b.b a2 : this.d) {
//                for (j next : a2.a(this.c)) {
//                    this.f1948a.put((String) next.f585a, (String) next.f586b);
//                }
//            }
//            eu.darken.a.c.a aVar = new eu.darken.a.c.a();
//            return new ab(this, new eu.darken.a.e.b(new h(aVar, this.c ? new e(aVar) : new u(), this.c ? "su" : "sh")));
//        }
//    }
//}