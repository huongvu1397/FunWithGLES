//package com.excalibur.funwithgles.sdmaidpro.sdm.corpsefinder.core.tasks;
//
//import android.content.Context;
//import eu.thedarken.sdm.C0117R;
//import eu.thedarken.sdm.corpsefinder.core.b;
//import eu.thedarken.sdm.main.core.c.n;
//import eu.thedarken.sdm.main.core.c.p;
//
//public abstract class CorpseFinderTask extends p {
//    public CorpseFinderTask() {
//        super(b.class);
//    }
//
//    public static abstract class Result extends n<CorpseFinderTask> {
//        public Result(CorpseFinderTask corpseFinderTask) {
//            super(corpseFinderTask);
//        }
//
//        public final String a(Context context) {
//            return context.getString(C0117R.string.navigation_label_corpsefinder);
//        }
//    }
//}