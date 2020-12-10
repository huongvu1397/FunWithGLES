package com.excalibur.funwithgles.sdmaidpro.tools.io;

import java.util.Collection;
import java.util.Locale;

/* compiled from: SmartSizeTask */
public final class SmartSizeTask {

    /* renamed from: a  reason: collision with root package name */
    public final Collection<p> f3884a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3885b;

    public SmartSizeTask(a aVar) {
        this.f3884a = aVar.f3886a;
        this.f3885b = aVar.f3887b;
        if (this.f3884a.isEmpty()) {
            throw new IllegalArgumentException("Can't determine size without any target!");
        }
    }

    /* compiled from: SmartSizeTask */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Collection<p> f3886a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3887b = false;

        public a(Collection<p> collection) {
            this.f3886a = collection;
        }
    }

    public final String toString() {
        return String.format(Locale.US, "SizeTask(ignoreErrors=%b, targets=%s)", new Object[]{Boolean.valueOf(this.f3885b), this.f3884a});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartSizeTask smartSizeTaskVar = (SmartSizeTask) obj;
        return this.f3885b == smartSizeTaskVar.f3885b && this.f3884a.equals(smartSizeTaskVar.f3884a);
    }

    public final int hashCode() {
        return (31 * this.f3884a.hashCode()) + (this.f3885b ? 1 : 0);
    }
}