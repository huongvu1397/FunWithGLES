//package com.excalibur.funwithgles.sdmaidpro.tools.io;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Locale;
//
///* compiled from: ReadTask */
//public final class k implements aa {
//
//    /* renamed from: a  reason: collision with root package name */
//    public final Collection<p> f3842a;
//
//    /* renamed from: b  reason: collision with root package name */
//    public final b f3843b;
//    public final boolean c;
//    public final boolean d;
//    public final d e;
//    public final q f;
//
//    /* compiled from: ReadTask */
//    public interface c extends aa.a {
//        List<p> a();
//
//        List<String> b();
//    }
//
//    /* compiled from: ReadTask */
//    public interface d {
//        void a(c cVar);
//    }
//
//    /* compiled from: ReadTask */
//    public enum b {
//        LEVEL3(4),
//        LEVEL2(3),
//        LEVEL1(2),
//        CONTENT(1),
//        ITEM(0),
//        ALL(-1);
//
//        public final int g;
//
//        private b(int i) {
//            this.g = i;
//        }
//    }
//
//    k(a aVar) {
//        this.f3842a = aVar.f3844a;
//        this.f3843b = aVar.f3845b;
//        this.c = aVar.c;
//        this.d = aVar.f;
//        this.e = aVar.d;
//        this.f = aVar.e;
//    }
//
//    public final String toString() {
//        return String.format(Locale.US, "ShellFileTask(paths=%s, recursionLevel=%s, symlinks=%s, captureErrors=%s, resultCallback=%s, streamListener=%s)", new Object[]{this.f3842a, this.f3843b, Boolean.valueOf(this.c), Boolean.valueOf(this.d), this.e, this.f});
//    }
//
//    /* compiled from: ReadTask */
//    public static class a {
//
//        /* renamed from: a  reason: collision with root package name */
//        final Collection<p> f3844a;
//
//        /* renamed from: b  reason: collision with root package name */
//        public b f3845b = b.ALL;
//        public boolean c = false;
//        public d d;
//        public q e;
//        public boolean f = false;
//
//        private a(Collection<p> collection) {
//            this.f3844a = collection;
//        }
//
//        public final a a() {
//            this.f3845b = b.ITEM;
//            return this;
//        }
//
//        public final a b() {
//            this.f3845b = b.CONTENT;
//            return this;
//        }
//
//        public final k c() {
//            return new k(this);
//        }
//
//        public final List<p> a(x xVar) {
//            return xVar.a(c()).a();
//        }
//
//        public final c b(x xVar) {
//            return xVar.a(c());
//        }
//
//        public static a a(Collection<p> collection) {
//            if (!collection.isEmpty()) {
//                return new a(collection);
//            }
//            throw new IllegalArgumentException("Paths to read empty!");
//        }
//    }
//}