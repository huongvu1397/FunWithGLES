package com.excalibur.funwithgles.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import com.excalibur.funwithgles.App

object PermissionUtils {

    val WRITE_PERMISSIONS = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    fun hasPermissions(context: Context?, permissions: Array<String>?) : Boolean {
        if (Build.VERSION.SDK_INT < 23 || context == null || permissions == null) {
            return true
        }
        for ( permission in permissions) {
            if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    fun checkPermission(permissions: Array<String>): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissions.forEach {
                if (ActivityCompat.checkSelfPermission(App.self(),it) == PackageManager.PERMISSION_DENIED) {
                    return false
                }
            }
        }
        return true
    }

}