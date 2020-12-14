//package com.excalibur.funwithgles.cropimage.b612crop.face.ui;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class ItemClickRecyclerView extends RecyclerView {
//    /* access modifiers changed from: private */
//    public GestureDetector Ak;
//    /* access modifiers changed from: private */
//    public c RD;
//    /* access modifiers changed from: private */
//    public b SD;
//    /* access modifiers changed from: private */
//    public a YA;
//
//    public interface a {
//        boolean b(View view, int i, MotionEvent motionEvent);
//    }
//
//    public interface b {
//        void b(View view, int i);
//    }
//
//    public interface c {
//        boolean a(MotionEvent motionEvent, int i);
//    }
//
//    public ItemClickRecyclerView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        init(context);
//    }
//
//    private void init(Context context) {
//        this.Ak = new GestureDetector(context, new ua(this));
//        a((RecyclerView.l) new va(this));
//    }
//
//    public void setOnItemClickListener(a aVar) {
//        this.YA = aVar;
//    }
//
//    public void setOnItemLongClickListener(b bVar) {
//        this.SD = bVar;
//    }
//
//    public void setOnItemTouchDownListener(c cVar) {
//        this.RD = cVar;
//    }
//
//    public ItemClickRecyclerView(Context context) {
//        super(context, (AttributeSet) null, 0);
//        init(context);
//    }
//
//    public ItemClickRecyclerView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet, 0);
//        init(context);
//    }
//}