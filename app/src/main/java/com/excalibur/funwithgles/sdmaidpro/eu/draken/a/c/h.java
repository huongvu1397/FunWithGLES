//package com.excalibur.funwithgles.sdmaidpro.eu.draken.a.c;
//
//import android.util.Log;
//
//import com.excalibur.funwithgles.sdmaidpro.eu.draken.a.b.RXSDebug;
//
//import eu.darken.a.b.c;
//import io.reactivex.b.b;
//import io.reactivex.d.f;
//import io.reactivex.e;
//import io.reactivex.n;
//import io.reactivex.r;
//import io.reactivex.rxjava3.annotations.NonNull;
//import io.reactivex.rxjava3.core.Completable;
//import io.reactivex.rxjava3.core.CompletableOnSubscribe;
//import io.reactivex.rxjava3.core.Observable;
//import io.reactivex.rxjava3.core.Single;
//import io.reactivex.rxjava3.core.SingleEmitter;
//import io.reactivex.rxjava3.core.SingleOnSubscribe;
//import io.reactivex.t;
//import io.reactivex.u;
//import io.reactivex.w;
//
///* compiled from: RxProcess */
//public final class h {
//
//    /* renamed from: a  reason: collision with root package name */
//    final Observable<? extends Process> f2013a;
//
//    /* renamed from: b  reason: collision with root package name */
//    Single<a> f2014b;
//
//    public h(b bVar, d dVar, String... strArr) {
//        this.f2013a = Observable.create(new i(bVar, strArr, dVar));
//    }
//
//    public final synchronized Single<a> a() {
//        if (RXSDebug.a()) {
//            //b.a.a.b("RXS:RxProcess").a("open()", new Object[0]);
//            Log.e("HVV1312","RXS:RxProcess open");
//        }
//        if (this.f2014b == null) {
//            this.f2014b = Single.create(new SingleOnSubscribe<a>() {
//                @Override
//                public void subscribe(@NonNull SingleEmitter<a> emitter) throws Throwable {
//                    h.this.f2013a.doFinally((io.reactivex.d.a) new m(this)).a(new r<Process>() {
//                        private b c;
//
//                        public final /* synthetic */ void b_(Object obj) {
//                            Process process = (Process) obj;
//                            if (c.a()) {
//                                b.a.a.b("RXS:RxProcess").a("processCreator:onNext(%s)", process);
//                            }
//                            uVar.a(new a(process, this.c));
//                        }
//
//                        public final void a(b bVar) {
//                            this.c = bVar;
//                        }
//
//                        public final void a(Throwable th) {
//                            if (c.a()) {
//                                b.a.a.b("RXS:RxProcess").a(th, "processCreator:onError()", new Object[0]);
//                            }
//                            uVar.b(th);
//                        }
//
//                        public final void o_() {
//                            if (c.a()) {
//                                b.a.a.b("RXS:RxProcess").a("processCreator:onComplete()", new Object[0]);
//                            }
//                            this.c.a();
//                        }
//                    });
//                }
//
//               // public final void a(final u<a> uVar) {
//
//               // }
//            }).b(io.reactivex.i.a.b()).a(j.f2022a).b((f<? super Throwable>) k.f2023a).a();
//        }
//        return this.f2014b;
//    }
//
//    /* compiled from: RxProcess */
//    public static class a {
//
//        /* renamed from: a  reason: collision with root package name */
//        public final Process f2018a;
//
//        /* renamed from: b  reason: collision with root package name */
//        public final Single<Integer> f2019b;
//        public final Completable c;
//        private final b d;
//
//        public a(Process process, b bVar) {
//            this.f2018a = process;
//            this.d = bVar;
//            this.c = Completable.create((CompletableOnSubscribe) new n(bVar)).b(io.reactivex.i.a.b()).a(o.f2028a).a((f<? super Throwable>) p.f2029a).a();
//            this.f2019b = t.a(new q(process)).b(io.reactivex.i.a.b()).a(r.f2031a).b((f<? super Throwable>) s.f2032a).a();
//        }
//
//        public final String toString() {
//            return "RxProcess.Session(process=" + this.f2018a + ")";
//        }
//    }
//}