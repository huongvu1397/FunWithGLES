package com.excalibur.funwithgles.sdmaidpro

import android.app.AppOpsManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Process
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.sdmaidpro.model.Location


class SDMaidPro : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_d_maid_pro)

        val appOps = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = appOps.checkOpNoThrow(
            AppOpsManager.OPSTR_GET_USAGE_STATS,
            Process.myUid(), packageName
        )

        if(mode == AppOpsManager.MODE_ALLOWED){
            loadPublicData()
        }else{
            //request permission
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
        }

    }

    private fun loadPublicData(){

    }

    fun a() {
        //val arrayList = ArrayList<Any>()

        //

//        for (next in d().a(Location.APP_ASEC)) {
//            a(next.c())
//            b(C0117R.string.progress_searching as Int)
//            b.a.a.b(f2437a).b("Searching: %s", next)
//            val a2: k.a = k.a.a(Collections.singletonList(next) as Collection<p?>)
//            a2.f3845b = k.b.CONTENT
//            a2.c = true
//            val a3: List<p> = a2.a(this.d)
//            if (h_()) {
//                return ArrayList()
//            }
//            b(C0117R.string.progress_filtering as Int)
//            b.a.a.b(f2437a).b("Filtering: %s", next)
//            arrayList.addAll(a(a3))
//            //if (h_()) {
//                //return ArrayList()
//            //}
//        }
        //return arrayList
    }

//    @Synchronized
//    fun a(vararg locationArr: Location?): Collection<com.excalibur.funwithgles.sdmaidpro.tools.io.p> {
//        val hashSet: HashSet
//        hashSet = HashSet()
//        for (a2 in locationArr) {
//            for (fVar in a(a2, false)) {
//                hashSet.add(fVar.f3924a)
//            }
//        }
//        return hashSet
//    }

//    @Synchronized
//    fun a(location: Location?, z: Boolean): Collection<f> {
//        val hashSet: HashSet
//        hashSet = HashSet()
//        if (location != null && this.f.containsKey(location)) {
//            hashSet.addAll(this.f.get(location))
//        } else if (location == null) {
//            for (addAll in this.f.values()) {
//                hashSet.addAll(addAll)
//            }
//        }
//        val it: MutableIterator<*> = hashSet.iterator()
//        while (it.hasNext()) {
//            val fVar: f = it.next() as f
//            if (!(fVar.f3925b === -1 || z || this.h === fVar.f3925b)) {
//                it.remove()
//            }
//        }
//        return hashSet
//    }


}