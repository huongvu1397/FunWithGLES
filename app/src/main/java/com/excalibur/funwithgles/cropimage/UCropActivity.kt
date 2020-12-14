package com.excalibur.funwithgles.cropimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.cropimage.b612crop.EditCropItemAdapter
import com.excalibur.funwithgles.cropimage.b612crop.b
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C2428e
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3936pU
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C4218vU
import com.excalibur.funwithgles.cropimage.b612crop.view.CropAngleView
import com.excalibur.funwithgles.cropimage.b612crop.view.CropView


class UCropActivity : AppCompatActivity() {

    private var xfindViewCache: HashMap<Int, Int>? = null

    private var Zwa = -1

    var areaCropBottomFeature: View? = null

    var cropAngleView: CropAngleView? = null

    private var hxa: C2428e? = null

    private var rxa: EditCropItemAdapter? = null

    var sxa: b = b.TYPE_ORIGINAL

    private var txa: com.excalibur.funwithgles.cropimage.b612crop.c? = null

    var uxa = 0
    private var vxa = 0
    private var wxa = 0

    /* synthetic */  fun b(editFeatureCropFragment: UCropActivity): EditCropItemAdapter? {
        var editCropItemAdapter: EditCropItemAdapter = editFeatureCropFragment.rxa!!
        if (editCropItemAdapter != null) {
            return editCropItemAdapter
        }
        C3905oka.Pf("cropItemAdapter")
        return null
    }

    fun Ap(): Boolean {
        return false
    }

    fun Dp(): CropView? {
        val cropView2 = cropView
        if (cropView2 != null) {
            return cropView2
        }
        C3905oka.Pf("cropView")
        return null
    }

    val path = "/storage/emulated/0/DCIM/Screenshots/Screenshot_20201127-174734_Cat Island.jpg"

    var cropView: CropView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_crop)
        cropView = findViewById(R.id.edit_crop_view)
        val bitmap: Bitmap = BitmapFactory.decodeFile(path, BitmapFactory.Options())
        cropView?.setImageBitmap(bitmap)
        areaCropBottomFeature = findViewById(R.id.area_crop_bottom_feature)
    }

    fun d(fragment: Fragment?) {
        var fragment: Fragment? = fragment
        C3905oka.e(fragment, "parentFragment")
        val cVar: com.excalibur.funwithgles.cropimage.b612crop.c? =
            (if (fragment !is com.excalibur.funwithgles.cropimage.b612crop.c) null else fragment) as com.excalibur.funwithgles.cropimage.b612crop.c?
        if (cVar != null) {
            txa = cVar
            if (fragment !is C2428e) {
                fragment = null
            }
            val eVar = fragment as C2428e?
            if (eVar != null) {
                hxa = eVar
                return
            }
            throw RuntimeException("PhotoContentCallback should not be null")
        }
        throw RuntimeException("CropResultCallback should not be null")
    }

    fun g(runnable: Runnable?) {
        C3905oka.e(runnable, "listener")
        val view = areaCropBottomFeature
        if (view != null) {
            C3936pU.a(view, 8, true, C4218vU.TO_DOWN, com.excalibur.funwithgles.cropimage.b612crop.d(this, runnable))
        } else {
            C3905oka.Pf("areaCropBottomFeature")
        }
    }

    companion object{
        fun d(editFeatureCropFragment: UCropActivity) {
            editFeatureCropFragment.uxa = 0
            val cropAngleView2: CropAngleView = editFeatureCropFragment.cropAngleView!!
            if (cropAngleView2 != null) {
                cropAngleView2.reset()
                editFeatureCropFragment.sxa = b.TYPE_ORIGINAL
                val editCropItemAdapter: EditCropItemAdapter = editFeatureCropFragment.rxa!!
                if (editCropItemAdapter != null) {
                    editCropItemAdapter.notifyDataSetChanged()
                    val cropView2: CropView = editFeatureCropFragment.cropView!!
                    if (cropView2 != null) {
                        cropView2.setCropType(editFeatureCropFragment.sxa)
                        /*
                        val itemClickRecyclerView: ItemClickRecyclerView = editFeatureCropFragment.cropItemRecyclerView
                        if (itemClickRecyclerView != null) {
                            val editCropItemAdapter2: EditCropItemAdapter = editFeatureCropFragment.rxa!!
                            if (editCropItemAdapter2 != null) {
                                itemClickRecyclerView.La(editCropItemAdapter2.b(editFeatureCropFragment.sxa))
                            } else {
                                C3905oka.Pf("cropItemAdapter")
                                //throw null
                            }
                        } else {
                            C3905oka.Pf("cropItemRecyclerView")
                            //throw null
                        }
                       */
                    } else {
                        C3905oka.Pf("cropView")
                        //throw null
                    }
                } else {
                    C3905oka.Pf("cropItemAdapter")
                    //throw null
                }
            } else {
                C3905oka.Pf("cropAngleView")
                //throw null
            }
        }
    }




}