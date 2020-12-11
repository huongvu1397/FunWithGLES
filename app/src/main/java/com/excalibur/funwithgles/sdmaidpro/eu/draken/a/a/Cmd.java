//package com.excalibur.funwithgles.sdmaidpro.eu.draken.a.a;
//
//import com.excalibur.funwithgles.R;
//
//import io.reactivex.rxjava3.core.Single;
//import io.reactivex.rxjava3.processors.FlowableProcessor;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.UUID;
//
///* compiled from: Cmd */
//public final class Cmd {
//
//    /* renamed from: a  reason: collision with root package name */
//    final String f1937a = UUID.randomUUID().toString();
//
//    /* renamed from: b  reason: collision with root package name */
//    final List<String> f1938b;
//    final long c;
//    final FlowableProcessor<String> d;
//    final FlowableProcessor<String> e;
//    final boolean f;
//    final boolean g;
//
//    private Cmd() throws InstantiationException {
//        throw new InstantiationException("Use the builder()!");
//    }
//
//    Cmd(C0062a aVar) {
//        this.f1938b = aVar.f1939a;
//        this.c = aVar.d;
//        this.f = aVar.e;
//        this.g = aVar.f;
//        this.d = aVar.f1940b;
//        this.e = aVar.c;
//    }
//
//    public final String toString() {
//        return "Cmd(timeout=" + this.c + ", commands=" + this.f1938b + ")";
//    }
//
//    /* compiled from: Cmd */
//    public static class b {
//
//        /* renamed from: a  reason: collision with root package name */
//        public final int f1941a;
//
//        /* renamed from: b  reason: collision with root package name */
//        public final List<String> f1942b;
//        public final List<String> c;
//        private final Cmd d;
//
//        public b(Cmd cmdVar, int i, List<String> list, List<String> list2) {
//            this.d = cmdVar;
//            this.f1941a = i;
//            this.f1942b = list;
//            this.c = list2;
//        }
//
//        public final Collection<String> a() {
//            ArrayList arrayList = new ArrayList();
//            if (this.f1942b != null) {
//                arrayList.addAll(this.f1942b);
//            }
//            if (this.c != null) {
//                arrayList.addAll(this.c);
//            }
//            return arrayList;
//        }
//
//        public final String toString() {
//            StringBuilder sb = new StringBuilder("Cmd.Result(cmd=");
//            sb.append(this.d);
//            sb.append(", exitcode=");
//            sb.append(this.f1941a);
//            sb.append(", output.size()=");
//            Integer num = null;
//            sb.append(this.f1942b != null ? Integer.valueOf(this.f1942b.size()) : null);
//            sb.append(", errors.size()=");
//            if (this.c != null) {
//                num = Integer.valueOf(this.c.size());
//            }
//            sb.append(num);
//            sb.append(")");
//            return sb.toString();
//        }
//    }
//
//    public static C0062a a(String... strArr) {
//        return new C0062a().a(strArr);
//    }
//
//    public static C0062a a(Collection<String> collection) {
//        C0062a aVar = new C0062a();
//        aVar.f1939a.addAll(collection);
//        return aVar;
//    }
//
//    /* renamed from: eu.darken.a.a.a$a  reason: collision with other inner class name */
//    /* compiled from: Cmd */
//    public static class C0062a {
//
//        /* renamed from: a  reason: collision with root package name */
//        final List<String> f1939a = new ArrayList();
//
//        /* renamed from: b  reason: collision with root package name */
//        public FlowableProcessor<String> f1940b;
//        FlowableProcessor<String> c;
//        public long d = 0;
//        public boolean e = true;
//        public boolean f = true;
//
//        public final C0062a a(String... strArr) {
//            this.f1939a.addAll(Arrays.asList(strArr));
//            return this;
//        }
//
//        public final Cmd a() {
//            if (!this.f1939a.isEmpty()) {
//                return new Cmd(this);
//            }
//            throw new IllegalArgumentException("Trying to create a Command without commands.");
//        }
//
//        public final Single<b> a(ab abVar) {
//            Single<R> tVar;
//            a a2 = a();
//            if (c.a()) {
//                b.a.a.b("RXS:RxCmdShell").a("isAlive()", new Object[0]);
//            }
//            if (abVar.d == null) {
//                tVar = t.b(false);
//            } else {
//                tVar = abVar.d.a(af.f1955a);
//            }
//            return tVar.a((g<? super R, ? extends x<? extends R>>) new b(abVar, a2));
//        }
//
//        public final b b(ab abVar) {
//            t<b> a2 = a(abVar);
//            c cVar = new c(this);
//            io.reactivex.e.b.b.a(cVar, "resumeFunction is null");
//            return (b) io.reactivex.g.a.a(new l(a2, cVar, null)).b();
//        }
//
//        public final b a(ab.b bVar) {
//            return bVar.a(a()).b();
//        }
//    }
//}