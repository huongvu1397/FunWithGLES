//package com.excalibur.funwithgles.sdmaidpro.tools.io;
//
//import android.content.Context;
//
//import com.excalibur.funwithgles.App;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.concurrent.ConcurrentHashMap;
//
///* compiled from: SmartIO */
//public final class x implements ae, d, f, h, l, o, t {
//
//    /* renamed from: a  reason: collision with root package name */
//    static final String f3878a = App.self().a("SmartIO");
//
//    /* renamed from: b  reason: collision with root package name */
//    private final Context f3879b;
//    private final ConcurrentHashMap<a, h> c = new ConcurrentHashMap<>();
//    private final SDMContext d;
//    private boolean e = true;
//    private final Object f = new Object();
//    private final c g;
//    private a h;
//    private j i;
//
//    public x(SDMContext sDMContext) {
//        this.d = sDMContext;
//        this.f3879b = sDMContext.f2120b;
//        this.g = (c) sDMContext.a(c.class, false);
//        this.i = (j) sDMContext.a(j.class, false);
//        this.e = l.f2949a.g;
//    }
//
//    private a d() {
//        synchronized (this.f) {
//            if (this.h == null) {
//                this.h = (a) this.d.a(a.class, false);
//            }
//        }
//        return this.h;
//    }
//
//    private synchronized h a(a aVar) {
//        h hVar;
//        hVar = this.c.get(aVar);
//        if (hVar == null) {
//            if (aVar == a.ROOT) {
//                hVar = new eu.thedarken.sdm.tools.io.shell.c(this.d, true);
//            } else if (aVar == a.NORMAL) {
//                hVar = new eu.thedarken.sdm.tools.io.shell.c(this.d, false);
//            } else if (aVar == a.SAF && eu.thedarken.sdm.tools.a.e()) {
//                hVar = new eu.thedarken.sdm.tools.io.b.c(this.d);
//            }
//            if (hVar != null) {
//                this.c.put(aVar, hVar);
//            }
//        }
//        if (hVar != null) {
//            hVar.a(e());
//        }
//        return hVar;
//    }
//
//    private synchronized ae b(a aVar) {
//        h a2 = a(aVar);
//        if (!(a2 instanceof ae)) {
//            return null;
//        }
//        return (ae) a2;
//    }
//
//    private synchronized d c(a aVar) {
//        h a2 = a(aVar);
//        if (!(a2 instanceof ae)) {
//            return null;
//        }
//        return (d) a2;
//    }
//
//    private synchronized o d(a aVar) {
//        h a2 = a(aVar);
//        if (!(a2 instanceof o)) {
//            return null;
//        }
//        return (o) a2;
//    }
//
//    private synchronized f e(a aVar) {
//        h a2 = a(aVar);
//        if (!(a2 instanceof f)) {
//            return null;
//        }
//        return (f) a2;
//    }
//
//    private synchronized t f(a aVar) {
//        h a2 = a(aVar);
//        if (!(a2 instanceof t)) {
//            return null;
//        }
//        return (t) a2;
//    }
//
//    private synchronized l g(a aVar) {
//        h a2 = a(aVar);
//        if (!(a2 instanceof l)) {
//            return null;
//        }
//        return (l) a2;
//    }
//
//    private a a(Collection<p> collection) {
//        a aVar = null;
//        for (p a2 : collection) {
//            a b2 = d().b(d().a(a2));
//            if (aVar == null) {
//                aVar = b2;
//            }
//            if (aVar == a.NORMAL && (b2 == a.SAF || b2 == a.ROOT)) {
//                aVar = b2;
//            }
//            if (aVar != a.ROOT) {
//                if (aVar == a.NONE) {
//                    break;
//                }
//            } else {
//                break;
//            }
//        }
//        if (aVar == null) {
//            aVar = a.NONE;
//        }
//        a.b b3 = b.a.a.b(f3878a);
//        int i2 = aVar == a.NONE ? 5 : 2;
//        b3.a(i2, "determineWriteAccess(" + collection.toString() + "):" + aVar, new Object[0]);
//        return aVar;
//    }
//
//    private a a(Collection<p> collection, k.b bVar) {
//        a aVar = null;
//        for (p next : collection) {
//            if (bVar != k.b.ITEM) {
//                next = i.a(next, "Test");
//            }
//            a a2 = d().a(d().a(next));
//            if (aVar == null) {
//                aVar = a2;
//            }
//            if (aVar == a.NORMAL && (a2 == a.SAF || a2 == a.ROOT)) {
//                aVar = a2;
//            }
//            if (aVar != a.ROOT) {
//                if (aVar == a.NONE) {
//                    break;
//                }
//            } else {
//                break;
//            }
//        }
//        if (aVar == null) {
//            aVar = a.NONE;
//        }
//        a.b b2 = b.a.a.b(f3878a);
//        int i2 = aVar == a.NONE ? 5 : 2;
//        b2.a(i2, "determineReadAccess(" + collection.toString() + "):" + aVar, new Object[0]);
//        return aVar;
//    }
//
//    public final r a(z zVar) {
//        r rVar;
//        t f2;
//        b.a.a.b(f3878a).b("size(task=%s)", zVar);
//        a a2 = a(zVar.f3884a, k.b.ITEM);
//        t f3 = f(a2);
//        if (f3 == null) {
//            b.a.a.b(f3878a).d("No suitable size tool available", new Object[0]);
//            rVar = new s(aa.a.C0091a.ERROR);
//        } else {
//            rVar = f3.a(zVar);
//        }
//        if (!(rVar.d() == aa.a.C0091a.OK || a2 == a.ROOT || !this.g.a() || (f2 = f(a.ROOT)) == null)) {
//            rVar = f2.a(zVar);
//        }
//        b.a.a.b(f3878a).b("size(result=%s)", rVar);
//        return rVar;
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8  */
//    /* JADX WARNING: Removed duplicated region for block: B:44:0x011b  */
//    public final synchronized v a(w wVar) {
//        f fVar;
//        b.a.a.b(f3878a).b("Processing %s", wVar);
//        Collection<p> b2 = this.i.b();
//        for (p next : wVar.f3874a) {
//            if (b2.contains(next)) {
//                b.a.a.b(f3878a).b(new IllegalDeletionAttempt(next));
//                return new e(wVar.f3874a);
//            }
//        }
//        a a2 = a(wVar.f3874a);
//        if (a2 != a.NONE || !eu.thedarken.sdm.tools.a.c()) {
//            fVar = e(a2);
//        } else {
//            b.a.a.b(f3878a).a("Let's try the kitkat provider trick", new Object[0]);
//            fVar = new b(this.f3879b);
//        }
//        if (fVar == null) {
//            b.a.a.b(f3878a).d("No suitable deleter available", new Object[0]);
//            return new e(wVar.f3874a);
//        }
//        v a3 = fVar.a(wVar);
//        ArrayList<p> arrayList = new ArrayList<>();
//        if (a3.d() == aa.a.C0091a.ERROR && e()) {
//            if (a2 == a.ROOT) {
//                if (this.g.a()) {
//                    for (p add : k.a.a(a3.b()).a().a(this)) {
//                        arrayList.add(add);
//                    }
//                    if (!arrayList.isEmpty()) {
//                        b.a.a.b(f3878a).b("Files failed to delete, but actually no longer existed", new Object[0]);
//                        a3 = new e(aa.a.C0091a.OK, a3.a(), a3.c(), Collections.emptyList());
//                    } else if (a2 == a.ROOT || !this.g.a()) {
//                        for (p c2 : arrayList) {
//                            b.a.a.b(f3878a).d("Couldn't delete: %s", c2.c());
//                        }
//                    } else {
//                        f e2 = e(a.ROOT);
//                        if (e2 != null) {
//                            v a4 = e2.a(wVar);
//                            ArrayList arrayList2 = new ArrayList();
//                            arrayList2.addAll(a3.a());
//                            arrayList2.addAll(a4.a());
//                            a3 = new e(a4.d(), arrayList2, a3.c() + a4.c(), a4.b());
//                        }
//                    }
//                }
//            }
//            for (p next2 : a3.b()) {
//                if (next2.d().exists()) {
//                    arrayList.add(next2);
//                }
//            }
//            if (!arrayList.isEmpty()) {
//            }
//        }
//        b.a.a.b(f3878a).b("Delete result: %s", a3);
//        return a3;
//    }
//
//    public final k.c a(k kVar) {
//        k.c cVar;
//        l g2;
//        a a2 = a(kVar.f3842a, kVar.f3843b);
//        l g3 = g(a2);
//        if (g3 == null) {
//            b.a.a.b(f3878a).d("No suitable read tool available", new Object[0]);
//            cVar = new j(aa.a.C0091a.ERROR);
//        } else {
//            cVar = g3.a(kVar);
//        }
//        if (!(cVar.d() == aa.a.C0091a.OK || a2 == a.ROOT || !this.g.a() || (g2 = g(a.ROOT)) == null)) {
//            cVar = g2.a(kVar);
//        }
//        b.a.a.b(f3878a).b("read(result=%s)", cVar);
//        return cVar;
//    }
//
//    public final synchronized void a() {
//        for (h a2 : this.c.values()) {
//            try {
//                a2.a();
//            } catch (IOException e2) {
//                b.a.a.b(f3878a).b(e2);
//            }
//        }
//        synchronized (this.f) {
//            if (this.h != null) {
//                this.h = null;
//            }
//        }
//    }
//
//    public final synchronized void a(boolean z) {
//        this.e = z;
//        for (h a2 : this.c.values()) {
//            a2.a(z);
//        }
//    }
//
//    private synchronized boolean e() {
//        return this.e;
//    }
//
//    public final synchronized boolean h_() {
//        for (h h_ : this.c.values()) {
//            if (!h_.h_()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public final synchronized void c() {
//        for (h c2 : this.c.values()) {
//            try {
//                c2.c();
//            } catch (Exception e2) {
//                b.a.a.b(f3878a).b(e2);
//            }
//        }
//    }
//
//    public final m a(y yVar) {
//        m mVar;
//        o d2;
//        a a2 = a((Collection<p>) Collections.singleton(yVar.f3880a));
//        o d3 = d(a2);
//        if (d3 == null) {
//            b.a.a.b(f3878a).d("No suitable creator available", new Object[0]);
//            mVar = new n();
//        } else {
//            mVar = d3.a(yVar);
//        }
//        if (!(mVar.d() == aa.a.C0091a.OK || a2 == a.ROOT || !this.g.a() || (d2 = d(a.ROOT)) == null)) {
//            mVar = d2.a(yVar);
//        }
//        b.a.a.b(f3878a).b("Rename result: %s", mVar);
//        return mVar;
//    }
//
//    public final b a(u uVar) {
//        b bVar;
//        d c2;
//        a a2 = a((Collection<p>) Collections.singletonList(uVar.f3868a));
//        d c3 = c(a2);
//        if (c3 == null) {
//            b.a.a.b(f3878a).d("No suitable creator available", new Object[0]);
//            bVar = new c(aa.a.C0091a.ERROR);
//        } else {
//            bVar = c3.a(uVar);
//        }
//        if (!(bVar.d() == aa.a.C0091a.OK || a2 == a.ROOT || !this.g.a() || (c2 = c(a.ROOT)) == null)) {
//            bVar = c2.a(uVar);
//        }
//        b.a.a.b(f3878a).b("Create reuslt: %s", bVar);
//        return bVar;
//    }
//
//    public final ac a(ab abVar) {
//        ac acVar;
//        ae b2;
//        a a2 = a(abVar.d, k.b.ITEM);
//        a a3 = a((Collection<p>) Collections.singleton(i.a(abVar.f3823a.d(), abVar.d.iterator().next().d().getName())));
//        a aVar = a.NONE;
//        if (a2 == a.NONE || a3 == a.NONE) {
//            aVar = a.NONE;
//        } else if (a2 == a.ROOT || a3 == a.ROOT) {
//            aVar = a.ROOT;
//        } else if (a2 == a.SAF || a3 == a.SAF) {
//            aVar = a.SAF;
//        } else if (a2 == a.NORMAL && a3 == a.NORMAL) {
//            aVar = a.NORMAL;
//        }
//        ae b3 = b(aVar);
//        if (b3 == null) {
//            b.a.a.b(f3878a).d("No suitable copier available", new Object[0]);
//            acVar = new ad();
//        } else {
//            acVar = b3.a(abVar);
//        }
//        if (!(acVar.d() == aa.a.C0091a.OK || aVar == a.ROOT || !this.g.a() || (b2 = b(a.ROOT)) == null)) {
//            acVar = b2.a(abVar);
//        }
//        b.a.a.b(f3878a).b("doMoveCopy(result=%s)", acVar);
//        return acVar;
//    }
//}