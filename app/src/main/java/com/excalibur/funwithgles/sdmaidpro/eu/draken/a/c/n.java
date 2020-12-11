package com.excalibur.funwithgles.sdmaidpro.eu.draken.a.c;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;

final /* synthetic */ class n implements CompletableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    private final b f2027a;

    n(b bVar) {
        this.f2027a = bVar;
    }

    @Override
    public void subscribe(@NonNull CompletableEmitter emitter) throws Throwable {
        this.f2027a.a();
        emitter.onComplete();
    }
}