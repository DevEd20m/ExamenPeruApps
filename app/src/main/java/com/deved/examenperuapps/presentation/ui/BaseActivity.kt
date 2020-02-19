package com.deved.examenperuapps.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    @LayoutRes
    abstract fun getLayout():Int

    fun goTo(activity:Class<*>,boolean: Boolean){
        // cambiar de actividad
        val intent = Intent(application,activity)
        startActivity(intent)
        if(boolean)
        finish() else {}
    }

}