package com.excalibur.funwithgles.utils

import android.provider.MediaStore
import android.util.Log
import com.excalibur.funwithgles.App
import com.excalibur.funwithgles.models.MyImage
import com.excalibur.funwithgles.models.MyMedia
import com.excalibur.funwithgles.models.MyVideo
import com.excalibur.funwithgles.models.TypeMedia
import java.io.File

object MediaUtils {

    fun getMediaItem(): List<MyMedia> {
        val list = ArrayList<MyMedia>()

        // add 10 images
        val imageProjection = arrayOf(MediaStore.Images.ImageColumns.DATA)
        val imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val imageCursor =
            App.self().contentResolver.query(imageUri, imageProjection, null, null, null)
        if (imageCursor != null && imageCursor.moveToFirst()) {
            imageCursor.moveToFirst()
            do {
                val path =
                    imageCursor.getString(imageCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                if (path == "" || !File(path).exists()) {
                    continue
                }
                Log.e("HVV1312","myMedia Image path : ${path}")
                try {
                    val file = File(path)
                    if (file.extension == "jpg" || file.extension == "jpeg" || file.extension == "png") {
                        list.add(
                            MyImage(
                                path = file.absolutePath,
                                name = file.name
                            )
                        )
                    }
                    if (list.size == 10) break
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            } while (imageCursor.moveToNext())
            imageCursor.close()
        }
        // add 10 videos
        val videoProjection = arrayOf(MediaStore.Video.VideoColumns.DATA)
        val videoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        val videoCursor =
            App.self().contentResolver.query(videoUri, videoProjection, null, null, null)
        if (videoCursor != null && videoCursor.moveToFirst()) {
            videoCursor.moveToFirst()
            do {
                val path =
                    videoCursor.getString(videoCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))
                Log.e("HVV1312","myMedia Video path : ${path}")
                if (path == "" || !File(path).exists()) {
                    continue
                }
                try {
                    val file = File(path)
                    if (file.extension == "mp4") {
                        list.add(
                            MyVideo(
                                path = file.absolutePath,
                                name = file.name
                            )
                        )
                    }
                    if (list.size == 20) break
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            } while (videoCursor.moveToNext())
            videoCursor.close()
        }

        return list
    }


}