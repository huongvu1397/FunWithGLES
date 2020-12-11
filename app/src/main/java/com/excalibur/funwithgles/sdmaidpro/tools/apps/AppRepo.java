package com.excalibur.funwithgles.sdmaidpro.tools.apps;

import android.content.pm.PackageInfo;

import com.excalibur.funwithgles.App;
import com.excalibur.funwithgles.sdmaidpro.main.core.IPCBufferException;
import com.excalibur.funwithgles.sdmaidpro.main.core.IPCFunnel;
import com.excalibur.funwithgles.sdmaidpro.tools.ApiHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AppRepo {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3554a = App.self().a("AppRepo");

    /* renamed from: b  reason: collision with root package name */
    private final Object f3555b = new Object();
    private Map<String, PackageInfo> c;
    private final IPCFunnel d;

    public AppRepo(IPCFunnel cVar) {
        this.d = cVar;
    }

    public final Map<String, PackageInfo> a(boolean z) {
        synchronized (this.f3555b) {
            if (this.c == null || this.c.isEmpty() || z) {
                this.c = new ConcurrentHashMap();
                for (PackageInfo next : this.d.a(1024)) {
                    this.c.put(next.packageName, next);
                }
                for (PackageInfo next2 : this.d.a(8192)) {
                    this.c.put(next2.packageName, next2);
                }
                if (ApiHelper.k()) {
//                    Cmd.b b2 = Cmd.a("pm list packages").b(new ab.a().a());
//                    b.a.a.b(f3554a).b("Result: %s", Boolean.valueOf(z));
//                    if (b2.f1942b.isEmpty() && b2.c.size() > 3) {
//                        StringBuilder sb = new StringBuilder();
//                        for (int i = 0; i < 3; i++) {
//                            sb.append(b2.c.get(i));
//                        }
//                        if (sb.toString().contains("NullPointerException")) {
//                            throw new OreoInstantAppsException();
//                        }
//                    }
                }
                if (this.c.isEmpty()) {
                    throw new IPCBufferException("List of installed apps was empty!");
                }
            }
        }
        return new HashMap(this.c);
    }

    public class OreoInstantAppsException extends RuntimeException {
        public OreoInstantAppsException() {
        }
    }
}