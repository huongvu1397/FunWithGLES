package com.excalibur.funwithgles.sdmaidpro.eu.draken.a.c;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

final /* synthetic */ class i implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    private final b f2020a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f2021b;
    private final d c;

    i(b bVar, String[] strArr, d dVar) {
        this.f2020a = bVar;
        this.f2021b = strArr;
        this.c = dVar;
    }

//    public final void a(o oVar) {
//
//    }

    @Override
    public void subscribe(@NonNull ObservableEmitter emitter) throws Throwable {
        b bVar = this.f2020a;
        String[] strArr = this.f2021b;
        d dVar = this.c;
        Process a2 = bVar.a(strArr);
        emitter.setCancellable(new l(dVar, a2));
        emitter.onNext(a2);
        a2.waitFor();
        emitter.onComplete();
    }
}