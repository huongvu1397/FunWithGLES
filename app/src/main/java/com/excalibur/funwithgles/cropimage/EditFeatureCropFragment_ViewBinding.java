//package com.excalibur.funwithgles.cropimage;
//
//import android.view.View;
//
//import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C1085pd;
//import com.excalibur.funwithgles.cropimage.b612crop.view.CropView;
//
//import butterknife.Unbinder;
//
//public final class UCropActivity_ViewBinding implements Unbinder {
//    public UCropActivity_ViewBinding(UCropActivity editFeatureCropFragment, View view) {
//        editFeatureCropFragment.cropView = (CropView) C1085pd.c(view, R.id.edit_crop_view, "field 'cropView'", CropView.class);
//        editFeatureCropFragment.areaCropBottomFeature = C1085pd.a(view, R.id.area_crop_bottom_feature, "field 'areaCropBottomFeature'");
//        editFeatureCropFragment.cropItemRecyclerView = (ItemClickRecyclerView) C1085pd.c(view, R.id.crop_item_recycler_view, "field 'cropItemRecyclerView'", ItemClickRecyclerView.class);
//        editFeatureCropFragment.cropAngleView = (CropAngleView) C1085pd.c(view, R.id.crop_angle_view, "field 'cropAngleView'", CropAngleView.class);
//        C1085pd.a(view, R.id.btn_confirm, "method 'onClickConfirmBtn'").setOnClickListener(new k(this, editFeatureCropFragment));
//        C1085pd.a(view, R.id.btn_cancel, "method 'onClickCancelBtn'").setOnClickListener(new l(this, editFeatureCropFragment));
//        C1085pd.a(view, R.id.btn_rotate, "method 'onClickRotateBtn'").setOnClickListener(new m(this, editFeatureCropFragment));
//    }
//
//    @Override
//    public void unbind() {
//
//    }
//}