package com.excalibur.funwithgles.sdmaidpro.tools.io;

/* compiled from: SmartCreateTask */
public final class SmartCreateTask implements SmartTask {

    /* renamed from: a  reason: collision with root package name */
    public final p f3868a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3869b;
    public final int c;
    public final boolean d;

    /* compiled from: SmartCreateTask */
    public enum b {
        ;
        

        /* renamed from: a  reason: collision with root package name */
        public static final int f3872a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3873b = 2;

        static {
            //c = new int[]{f3872a, f3873b};
        }
    }

    SmartCreateTask(a aVar) {
        this.c = aVar.f3870a;
        this.f3868a = aVar.f3871b;
        this.f3869b = aVar.c;
        this.d = aVar.d;
    }

    public static a a(p pVar) {
        return new a(b.f3873b, pVar);
    }

    /* compiled from: SmartCreateTask */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f3870a;

        /* renamed from: b  reason: collision with root package name */
        final p f3871b;
        public boolean c;
        public boolean d;

        public a(int i, p pVar) {
            this.f3870a = i;
            this.f3871b = pVar;
        }

        public final CreateResult a(CreateTool createToolVar) {
            return createToolVar.a(new SmartCreateTask(this));
        }
    }
}