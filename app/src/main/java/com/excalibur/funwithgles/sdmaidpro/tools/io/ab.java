package com.excalibur.funwithgles.sdmaidpro.tools.io;

import java.util.Collection;
import java.util.Collections;

/* compiled from: SmartTransactionTask */
public final class ab implements SmartTask {

    /* renamed from: a  reason: collision with root package name */
    public final SDMFile f3823a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3824b;
    public final int c;
    public final Collection<SDMFile> d;

    /* compiled from: SmartTransactionTask */
    public enum b {
        ;
        

        /* renamed from: a  reason: collision with root package name */
        public static final int f3827a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3828b = 2;
        public static final int c = 3;

        static {
            //todo
            //d = new int[]{f3827a, f3828b, c};
        }
    }

    ab(a aVar) {
        this.c = aVar.f3825a;
        this.d = aVar.f3826b;
        this.f3823a = aVar.c;
        this.f3824b = aVar.d;
    }

    public static a a(SDMFile SDMFileVar, SDMFile SDMFileVar2) {
        return new a(b.f3828b, Collections.singleton(SDMFileVar), SDMFileVar2);
    }

    /* compiled from: SmartTransactionTask */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f3825a;

        /* renamed from: b  reason: collision with root package name */
        final Collection<SDMFile> f3826b;
        final SDMFile c;
        public boolean d;

        public a(int i, Collection<SDMFile> collection, SDMFile SDMFileVar) {
            this.f3825a = i;
            this.f3826b = collection;
            this.c = SDMFileVar;
        }

        public final TransactionResult a(TransactionTool transactionToolVar) {
            return transactionToolVar.a(new ab(this));
        }
    }
}