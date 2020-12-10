package com.excalibur.funwithgles.sdmaidpro.epack;

import android.view.View;

import com.excalibur.funwithgles.sdmaidpro.ui.WorkerStatusBar;

public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ WorkerStatusBar f1181e;
    private final /* synthetic */ View.OnClickListener f;

    public /* synthetic */ y(WorkerStatusBar workerStatusBar, View.OnClickListener onClickListener) {
        this.f1181e = workerStatusBar;
        this.f = onClickListener;
    }

    public final void onClick(View view) {
        this.f1181e.a(this.f, view);
    }
}