package com.deved.examenperuapps.presentation.util

import android.content.Context
import android.widget.Toast

class Tools{
    fun toast(context: Context ,message:String?, duration:Int = Toast.LENGTH_LONG){
        Toast.makeText(context,message,duration).show()
    }


    companion object{
        fun validateNull(input:Any?):Boolean{
            return input!=null
        }


        const val emptyInput:String = "El campo ingresado se encuentra vacio"
    }
}