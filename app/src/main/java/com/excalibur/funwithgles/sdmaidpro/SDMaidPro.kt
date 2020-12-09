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

        }else{
            //request permission
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
        }



    }

}