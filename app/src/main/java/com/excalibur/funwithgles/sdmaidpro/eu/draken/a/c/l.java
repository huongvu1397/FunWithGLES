package com.excalibur.funwithgles.sdmaidpro.eu.draken.a.c;

import android.util.Log;

import com.excalibur.funwithgles.sdmaidpro.eu.draken.a.b.RXSDebug;

import io.reactivex.rxjava3.functions.Cancellable;

final /* synthetic */ class l implements Cancellable {

    /* renamed from: a  reason: collision with root package name */
    private final d f2024a;

    /* renamed from: b  reason: collision with root package name */
    private final Process f2025b;

    l(d dVar, Process process) {
        this.f2024a = dVar;
        this.f2025b = process;
    }

    @Override
    public void cancel() throws Throwable {
        d dVar = this.f2024a;
        Process process = this.f2025b;
        if (RXSDebug.a()) {
            //a.b("RXS:RxProcess").a("cancel()", new Object[0]);
            Log.e("HVV1312","RXS:RxProcess cancel");
        }
        dVar.a(process);
    }
}