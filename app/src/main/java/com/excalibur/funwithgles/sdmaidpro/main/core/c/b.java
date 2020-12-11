//package com.excalibur.funwithgles.sdmaidpro.main.core.c;
//
//import eu.thedarken.sdm.App;
//import eu.thedarken.sdm.C0117R;
//import eu.thedarken.sdm.SDMContext;
//import eu.thedarken.sdm.main.core.c.n;
//import eu.thedarken.sdm.main.core.c.o;
//import eu.thedarken.sdm.main.core.c.p;
//import eu.thedarken.sdm.statistics.a.e;
//import eu.thedarken.sdm.tools.ag;
//import eu.thedarken.sdm.tools.h;
//import eu.thedarken.sdm.tools.io.x;
//import eu.thedarken.sdm.tools.upgrades.d;
//import io.reactivex.d.f;
//import io.reactivex.e.e.c.aa;
//import io.reactivex.e.e.c.j;
//import io.reactivex.j.a;
//import io.reactivex.j.c;
//import io.reactivex.s;
//import java.io.IOException;
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicBoolean;
//
///* compiled from: AbstractWorker */
//public abstract class b<TaskT extends p, ResultT extends n> implements ag, h {
//
//    /* renamed from: a  reason: collision with root package name */
//    private final a<o> f2996a;
//
//    /* renamed from: b  reason: collision with root package name */
//    private final eu.thedarken.sdm.statistics.a.b f2997b;
//    private c<ResultT> c = c.f();
//    private x d;
//    private eu.thedarken.sdm.tools.f.b e;
//    String g = App.a(getClass().getSimpleName());
//    public final o.a h;
//    protected final eu.thedarken.sdm.exclusions.core.c i;
//    public final AtomicBoolean j = new AtomicBoolean(false);
//    public final SDMContext k;
//    public volatile Boolean l = false;
//    n m;
//    public final a<ResultT> n = a.f();
//    public final io.reactivex.j.b<ResultT> o = io.reactivex.j.b.f();
//    public io.reactivex.b.b p;
//
//    public abstract m a();
//
//    public abstract ResultT b(TaskT taskt);
//
//    public b(SDMContext sDMContext, eu.thedarken.sdm.exclusions.core.c cVar, eu.thedarken.sdm.statistics.a.b bVar) {
//        this.k = sDMContext;
//        this.i = cVar;
//        this.f2997b = bVar;
//        this.h = o.a(sDMContext.f2120b);
//        this.f2996a = a.c(o.a(sDMContext.f2120b).a());
//        this.o.c(new c(this));
//    }
//
//    public eu.thedarken.sdm.tools.f.b d() {
//        return new eu.thedarken.sdm.tools.f.b(this.k);
//    }
//
//    public final eu.thedarken.sdm.tools.f.b i() {
//        if (this.e == null) {
//            this.e = d();
//        }
//        return this.e;
//    }
//
//    public final x j() {
//        if (this.d == null) {
//            this.d = new x(this.k);
//        }
//        return this.d;
//    }
//
//    public final synchronized io.reactivex.n<ResultT> k() {
//        b.a.a.b(this.g).b("BUS: Worker-Cache: uncacheBusEvents()", new Object[0]);
//        if (this.p == null) {
//            return io.reactivex.g.a.a(j.f4315a);
//        }
//        this.p.a();
//        this.p = null;
//        this.c.o_();
//        return this.c.a((f<? super io.reactivex.b.b>) io.reactivex.e.b.a.b(), (io.reactivex.d.a) new d(this)).b((f<? super io.reactivex.b.b>) new e(this)).a(new f(this));
//    }
//
//    public final synchronized void l() {
//        b.a.a.b(this.g).b("BUS: Worker-Cache: cacheBusEvents()", new Object[0]);
//        this.c = c.f();
//        this.o.b((f<? super io.reactivex.b.b>) new g(this)).a(new h(this)).a(this.c);
//    }
//
//    /* access modifiers changed from: package-private */
//    public final void q() {
//        this.f2996a.b_(this.h.a());
//    }
//
//    /* access modifiers changed from: package-private */
//    public final void r() {
//        this.l = false;
//        o.a aVar = this.h;
//        aVar.g = o.b.NONE;
//        o.a a2 = aVar.a(C0117R.string.progress_in_queue);
//        a2.f = null;
//        a2.f3017b = true;
//        a2.c = 0;
//        a2.d = 0;
//        a2.h = true;
//        q();
//    }
//
//    public final boolean h_() {
//        return this.l.booleanValue();
//    }
//
//    public void a(boolean z) {
//        if (this.d != null) {
//            if (z) {
//                this.d.c();
//            } else {
//                this.d.a();
//            }
//            this.d = null;
//        }
//        if (this.e != null) {
//            if (z) {
//                try {
//                    this.e.e();
//                } catch (IOException e2) {
//                    b.a.a.b(this.g).b(e2);
//                    this.e = null;
//                    return;
//                } catch (Throwable th) {
//                    this.e = null;
//                    throw th;
//                }
//            } else {
//                this.e.f();
//            }
//            this.e = null;
//        }
//    }
//
//    /* access modifiers changed from: package-private */
//    public final void b(boolean z) {
//        b.a.a.b(this.g).b("Cleaning up after task (force=%b)", Boolean.valueOf(z));
//        a(z);
//    }
//
//    public final ResultT c(TaskT taskt) {
//        a(o.b.INDETERMINATE);
//        ResultT b2 = b(taskt);
//        if (b2.g == n.a.NEW) {
//            if (this.l.booleanValue()) {
//                b2.g = n.a.CANCELED;
//            } else {
//                b2.g = n.a.SUCCESS;
//            }
//        }
//        if (b2 instanceof e) {
//            b(String.format(Locale.getDefault(), "%s: %s", new Object[]{a((int) C0117R.string.progress_working), a((int) C0117R.string.navigation_statistics)}));
//            c((String) null);
//            this.f2997b.a(((e) b2).d(this.k.f2120b));
//        }
//        this.m = b2;
//        this.n.b_(b2);
//        this.h.e = this.m.b(this.k.f2120b);
//        this.h.f = this.m.c(this.k.f2120b);
//        this.o.b_(b2);
//        return b2;
//    }
//
//    public final io.reactivex.n<o> s() {
//        a<o> aVar = this.f2996a;
//        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
//        s a2 = io.reactivex.i.a.a();
//        io.reactivex.e.b.b.a(timeUnit, "unit is null");
//        io.reactivex.e.b.b.a(a2, "scheduler is null");
//        return io.reactivex.g.a.a(new aa(aVar, timeUnit, a2));
//    }
//
//    public final void b(String str) {
//        this.h.e = str;
//        q();
//    }
//
//    public final void c(String str) {
//        this.h.f = str;
//        q();
//    }
//
//    public final void a(o.b bVar) {
//        this.h.g = bVar;
//        q();
//    }
//
//    public final void t() {
//        b(this.h.c + 1, this.h.d);
//    }
//
//    public final void a(int i2, int i3) {
//        if (i3 == 0) {
//            b(-1, -1);
//            return;
//        }
//        int i4 = (int) ((((float) i2) / ((float) i3)) * 100.0f);
//        if (i4 != this.h.c) {
//            b(i4, 100);
//        }
//    }
//
//    public final void c(int i2) {
//        b(this.h.c, i2);
//    }
//
//    public final void b(int i2, int i3) {
//        if (i3 != -1) {
//            if (this.h.g != o.b.DETERMINATE) {
//                this.h.g = o.b.DETERMINATE;
//            }
//            this.h.c = i2;
//            this.h.d = i3;
//            q();
//        } else if (this.h.g != o.b.INDETERMINATE) {
//            a(o.b.INDETERMINATE);
//        }
//    }
//
//    public final eu.thedarken.sdm.tools.storage.j m() {
//        return (eu.thedarken.sdm.tools.storage.j) this.k.a(eu.thedarken.sdm.tools.storage.j.class, false);
//    }
//
//    public final eu.thedarken.sdm.tools.forensics.a n() {
//        return (eu.thedarken.sdm.tools.forensics.a) this.k.a(eu.thedarken.sdm.tools.forensics.a.class, false);
//    }
//
//    public final boolean a(d dVar) {
//        return this.k.h.a(dVar);
//    }
//
//    public final eu.thedarken.sdm.tools.binaries.sdmbox.a o() {
//        return (eu.thedarken.sdm.tools.binaries.sdmbox.a) this.k.a(eu.thedarken.sdm.tools.binaries.sdmbox.a.class, false);
//    }
//
//    public final String a(int i2) {
//        return this.k.f2120b.getString(i2);
//    }
//
//    public final eu.darken.a.d.c p() {
//        return (eu.darken.a.d.c) this.k.a(eu.darken.a.d.c.class, false);
//    }
//
//    public final synchronized void c() {
//        if (!this.j.get() || this.l.booleanValue()) {
//            b.a.a.b(this.g).d("Already canceled or not working!", new Object[0]);
//            return;
//        }
//        b.a.a.b(this.g).d("Canceling...", new Object[0]);
//        this.l = true;
//        o.a aVar = this.h;
//        aVar.h = false;
//        o.a a2 = aVar.a(C0117R.string.progress_canceling);
//        a2.f = null;
//        a2.g = o.b.INDETERMINATE;
//        q();
//        b(true);
//    }
//
//    public final void b(int i2) {
//        b(this.k.f2120b.getString(i2));
//    }
//}