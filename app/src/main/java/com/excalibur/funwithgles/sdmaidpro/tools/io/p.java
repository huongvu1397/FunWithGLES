package com.excalibur.funwithgles.sdmaidpro.tools.io;

import android.content.Context;
import android.os.Parcelable;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: SDMFile */
public interface p extends Parcelable {
    public static final DateFormat g = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.US);

    long a();

    String a(Context context);

    long b();

    String c();

    File d();

    String e();

    String f();

    p g();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    Date l();

    boolean m();

    int n();

    int o();

    int p();

    String q();

    p r();

    String s();
}