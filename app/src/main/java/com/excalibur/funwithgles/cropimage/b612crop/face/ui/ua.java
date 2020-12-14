//package com.excalibur.funwithgles.cropimage.b612crop.face.ui;
//
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//
//class ua extends GestureDetector.SimpleOnGestureListener {
//    final /* synthetic */ ItemClickRecyclerView this$0;
//
//    ua(ItemClickRecyclerView itemClickRecyclerView) {
//        this.this$0 = itemClickRecyclerView;
//    }
//
//    public boolean onDown(MotionEvent motionEvent) {
//        int ia = this.this$0.ia(this.this$0.e(motionEvent.getX(), motionEvent.getY()));
//        if (ia == -1 || this.this$0.RD == null) {
//            return true;
//        }
//        return this.this$0.RD.a(motionEvent, ia);
//    }
//
//    public void onLongPress(MotionEvent motionEvent) {
//        View e = this.this$0.e(motionEvent.getX(), motionEvent.getY());
//        int ia = this.this$0.ia(e);
//        if (ia != -1 && this.this$0.SD != null) {
//            this.this$0.SD.b(e, ia);
//        }
//    }
//
//    public boolean onSingleTapUp(MotionEvent motionEvent) {
//        View e = this.this$0.e(motionEvent.getX(), motionEvent.getY());
//        int ia = this.this$0.ia(e);
//        if (ia == -1 || this.this$0.YA == null) {
//            return super.onSingleTapUp(motionEvent);
//        }
//        return this.this$0.YA.b(e, ia, motionEvent);
//    }
//}