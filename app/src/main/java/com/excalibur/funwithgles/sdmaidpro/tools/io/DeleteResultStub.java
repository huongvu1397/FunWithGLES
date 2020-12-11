package com.excalibur.funwithgles.sdmaidpro.tools.io;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: DeleteResultStub */
public final class DeleteResultStub implements SmartDeleteResult {

    /* renamed from: a  reason: collision with root package name */
    private final Collection<SDMFile> f3835a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3836b;
    private final SmartTask.a.C0091a c;
    private final Collection<SDMFile> d;

    public DeleteResultStub(Collection<SDMFile> collection) {
        this(SmartTask.a.C0091a.ERROR, new ArrayList(), 0, collection);
    }

    public DeleteResultStub(SmartTask.a.C0091a aVar, Collection<SDMFile> collection, long j, Collection<SDMFile> collection2) {
        this.c = aVar;
        this.d = collection;
        this.f3836b = j;
        this.f3835a = collection2;
    }

    public final Collection<SDMFile> a() {
        return this.d;
    }

    public final Collection<SDMFile> b() {
        return this.f3835a;
    }

    public final long c() {
        return this.f3836b;
    }

    public final SmartTask.a.C0091a d() {
        return this.c;
    }

    public final String toString() {
        return String.format("DeleteResultStub(state=%s, affectedsize=%s, deletedFiles=%s, errorFiles=%s)", new Object[]{this.c.name(), Long.valueOf(this.f3836b), Integer.valueOf(this.d.size()), Integer.valueOf(this.f3835a.size())});
    }
}