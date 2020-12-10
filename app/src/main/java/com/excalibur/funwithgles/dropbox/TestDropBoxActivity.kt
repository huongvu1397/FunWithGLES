package com.excalibur.funwithgles.dropbox

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.users.FullAccount
import com.excalibur.funwithgles.R
import kotlinx.android.synthetic.main.activity_drop_box.*
import kotlinx.android.synthetic.main.activity_drop_box.btnLogin
import kotlinx.android.synthetic.main.activity_user.*
import java.lang.Exception
import java.util.*


class TestDropBoxActivity : DropboxActivity() {

    private val ACCESS_TOKEN = "sl.AnGWWcuAvV_2jcoKElvKd_3eaOlv6_J8b6dJD8dWAlfY_MNTip-Jyd1YaUYlsFkl-vnpWqIUgpdL2ep2zZarI2vM-8E174xGcq-IxgOoTkXhqPrjawMcUaYFVtcdWFnJwifKYsk"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // Create Dropbox client
        //val config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build()
        //val client = DbxClientV2(config, ACCESS_TOKEN)

        login_button.setOnClickListener {
            startOAuth2Authentication(this,getString(R.string.app_key),
                listOf("account_info.read", "files.content.write")
            )
        }


    }

    override fun loadData() {
        GetCurrentAccountTask(DropboxClientFactory.getClient(),object : GetCurrentAccountTask.Callback{
            override fun onComplete(result: FullAccount?) {
                Log.e("HVV1312", "loadData complete 1 : ${result?.email}")
                Log.e("HVV1312", "loadData complete 2 : ${result?.name?.displayName}")
                Log.e("HVV1312", "loadData complete 3 : ${result?.accountType?.name}")
            }

            override fun onError(e: Exception?) {
                Log.e("HVV1312", "Failed to get account details.", e)
            }
        }).execute()
    }
}