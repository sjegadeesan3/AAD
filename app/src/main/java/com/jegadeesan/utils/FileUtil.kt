package com.jegadeesan.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream

class FileUtil(private val context: Context) {

    fun loadJSONFromAsset(fileName: String): String? {
        return try {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
    }

}