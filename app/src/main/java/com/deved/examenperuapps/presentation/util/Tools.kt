package com.deved.examenperuapps.presentation.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.deved.examenperuapps.App
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class Tools {
    fun toast(context: Context, message: String?, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(context, message, duration).show()
    }


    companion object {
        fun validateNull(input: Any?): Boolean {
            return input != null
        }

        fun validateNumberPictures(arrayList: List<Any>): Boolean {
            return arrayList.size > 2
        }

        fun validatePermisionCamera(activity: Activity):Boolean{
            return if(ContextCompat.checkSelfPermission(activity,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CAMERA),1)
                false
            }else{
                true
            }
        }

        fun getUriToBitmap(context: Context,bitmap: Bitmap): Uri {
            val tempir:File = File("${context.applicationContext.filesDir }/image/"+"fotosPeruApps")
//            val tempir = File(Environment.getExternalStorageState()+File.separator+"image"+"/fotosPeruApps")
            if(!tempir.exists()){
                tempir.mkdirs()
            }
            val tempFIle = File.createTempFile("prueba","jpg",tempir)
            val byes = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,byes)
            val bitmapData = byes.toByteArray()

            val fos = FileOutputStream(tempFIle)
            fos.write(bitmapData)
            fos.flush()
            fos.close()
            return Uri.fromFile(tempFIle)


        }

        const val emptyInput: String = "El campo ingresado se encuentra vacio"
    }
}