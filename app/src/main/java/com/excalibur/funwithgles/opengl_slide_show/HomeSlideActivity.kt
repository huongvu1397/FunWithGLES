package com.excalibur.funwithgles.opengl_slide_show

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.excalibur.funwithgles.R
import com.excalibur.funwithgles.opengl_slide_show.viewmodels.ActivityViewModel
import com.excalibur.funwithgles.utils.PermissionUtils

class HomeSlideActivity : AppCompatActivity() {

    val viewModel by viewModels<ActivityViewModel> {
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)
    }

    companion object {
        private const val REQUEST_PERMISSION = 1
    }

    private var onAllow: (() -> Unit)? = null
    private var onDenied: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_slide)
    }

    @SuppressLint("ObsoleteSdkInt")
    protected fun doRequestPermission(
        permissions: Array<String>,
        onAllow: () -> Unit = {},
        onDenied: () -> Unit = {}
    ) {
        this.onAllow = onAllow
        this.onDenied = onDenied
        if (PermissionUtils.checkPermission(permissions)) {
            onAllow()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, REQUEST_PERMISSION)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (PermissionUtils.checkPermission(permissions)) {
            onAllow?.invoke()
        } else {
            onDenied?.invoke()
            openAppSetting(this, requestCode)
        }
    }

    fun openAppSetting(activity: AppCompatActivity, REQ: Int) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        activity.startActivityForResult(intent, REQ)
    }

}