package com.excalibur.funwithgles.sdmaidpro.tools.io;

import java.util.Collection;
import java.util.Collections;

/* compiled from: SmartDeleteTask */
public final class w implements SmartTask {

    /* renamed from: a  reason: collision with root package name */
    public final Collection<SDMFile> f3874a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3875b;
    public final boolean c;

    public final String toString() {
        return "SmartDeleteTask(...)";
    }

    public w(a aVar) {
        this.f3874a = aVar.f3876a;
        this.f3875b = aVar.f3877b;
        this.c = aVar.c;
    }

    public static a a(SDMFile SDMFileVar) {
        return new a(Collections.singleton(SDMFileVar));
    }

    /* compiled from: SmartDeleteTask */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Collection<SDMFile> f3876a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3877b;
        public boolean c;

        a(Collection<SDMFile> collection) {
            this.f3876a = collection;
        }

        public final w a() {
            return new w(this);
        }

        public final SmartDeleteResult a(DeleteTool deleteToolVar) {
            return deleteToolVar.a(a());
        }
    }
}