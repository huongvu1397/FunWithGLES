//package com.excalibur.funwithgles.sdmaidpro.eu.draken.a.e;
//
//import eu.darken.a.b.c;
//import eu.darken.a.c.h;
//import io.reactivex.d.f;
//import io.reactivex.e;
//import io.reactivex.e.e.b.g;
//import io.reactivex.e.e.d.d;
//import io.reactivex.rxjava3.core.Single;
//import io.reactivex.s;
//import java.io.InputStream;
//import java.io.OutputStreamWriter;
//
///* compiled from: RxShell */
//public final class b {
//
//    /* renamed from: a  reason: collision with root package name */
//    Single<a> f2067a;
//
//    /* renamed from: b  reason: collision with root package name */
//    private h f2068b;
//
//    public b(h hVar) {
//        this.f2068b = hVar;
//    }
//
//    public final synchronized t<a> a() {
//        if (c.a()) {
//            b.a.a.b("RXS:RxShell").a("open()", new Object[0]);
//        }
//        if (this.f2067a == null) {
//            this.f2067a = this.f2068b.a().b(c.f2071a).b(io.reactivex.i.a.b()).a(new d(this)).b((f<? super Throwable>) e.f2073a).a();
//        }
//        return this.f2067a;
//    }
//
//    /* compiled from: RxShell */
//    public static class a {
//
//        /* renamed from: a  reason: collision with root package name */
//        public final h.a f2069a;
//
//        /* renamed from: b  reason: collision with root package name */
//        public final io.reactivex.h<String> f2070b;
//        public final t<Integer> c;
//        final io.reactivex.b.b d;
//        final io.reactivex.b.b e;
//        private final OutputStreamWriter f;
//        private final io.reactivex.h<String> g;
//        private final t<Integer> h;
//        private final io.reactivex.b i;
//
//        public a(h.a aVar, OutputStreamWriter outputStreamWriter) {
//            this.f2069a = aVar;
//            this.f = outputStreamWriter;
//            if (c.a()) {
//                b.a.a.b("RXS:RxProcess:Session").a("output()", new Object[0]);
//            }
//            this.f2070b = b.a(aVar.f2018a.getInputStream(), "output");
//            this.e = this.f2070b.a(j.f2080a, (f<? super Throwable>) k.f2081a);
//            if (c.a()) {
//                b.a.a.b("RXS:RxProcess:Session").a("error()", new Object[0]);
//            }
//            this.g = b.a(aVar.f2018a.getErrorStream(), "error");
//            this.d = c().a(n.f2084a, (f<? super Throwable>) o.f2085a);
//            if (c.a()) {
//                b.a.a.b("RXS:RxProcess:Session").a("destroy()", new Object[0]);
//            }
//            this.i = aVar.c.a(p.f2086a).a((f<? super Throwable>) q.f2087a).a();
//            if (c.a()) {
//                b.a.a.b("RXS:RxProcess:Session").a("waitFor()", new Object[0]);
//            }
//            this.h = aVar.f2019b.a(r.f2088a).b((f<? super Throwable>) s.f2089a).a();
//            io.reactivex.b b2 = io.reactivex.b.a((e) new t(this, outputStreamWriter)).b(io.reactivex.i.a.b());
//            t<Integer> b3 = b();
//            io.reactivex.e.b.b.a(b3, "next is null");
//            this.c = io.reactivex.g.a.a(new d(b3, b2)).a((io.reactivex.d.a) new u(this)).a(l.f2082a).b((f<? super Throwable>) m.f2083a).a();
//        }
//
//        public final void a(String str, boolean z) {
//            if (c.a()) {
//                b.a.a.b("RXS:RxShell:Session").b("writeLine(line=%s, flush=%b)", str, Boolean.valueOf(z));
//            }
//            OutputStreamWriter outputStreamWriter = this.f;
//            outputStreamWriter.write(str + a.a());
//            if (z) {
//                this.f.flush();
//            }
//        }
//
//        public final io.reactivex.b a() {
//            if (c.a()) {
//                b.a.a.b("RXS:RxShell:Session").a("cancel()", new Object[0]);
//            }
//            return this.i;
//        }
//
//        public final t<Integer> b() {
//            if (c.a()) {
//                b.a.a.b("RXS:RxShell:Session").a("waitFor()", new Object[0]);
//            }
//            return this.h;
//        }
//
//        public final io.reactivex.h<String> c() {
//            if (c.a()) {
//                b.a.a.b("RXS:RxShell:Session").a("errorLines()", new Object[0]);
//            }
//            return this.g;
//        }
//
//        public final String toString() {
//            return "RxShell.Session(processSession=" + this.f2069a + ")";
//        }
//    }
//
//    static io.reactivex.h<String> a(InputStream inputStream, String str) {
//        io.reactivex.h a2 = io.reactivex.h.a(new f(inputStream, str), io.reactivex.a.MISSING);
//        s b2 = io.reactivex.i.a.b();
//        io.reactivex.e.b.b.a(b2, "scheduler is null");
//        boolean z = !(a2 instanceof io.reactivex.e.e.b.b);
//        io.reactivex.e.b.b.a(b2, "scheduler is null");
//        io.reactivex.h a3 = io.reactivex.g.a.a(new g(a2, b2, z));
//        int b3 = io.reactivex.h.b();
//        io.reactivex.e.b.b.a(b3, "bufferSize");
//        return io.reactivex.g.a.a(new io.reactivex.e.e.b.f(io.reactivex.e.e.b.e.a(a3, b3)));
//    }
//}