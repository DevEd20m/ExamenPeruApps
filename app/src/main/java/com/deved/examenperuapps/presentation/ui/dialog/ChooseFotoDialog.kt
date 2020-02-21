package com.deved.examenperuapps.presentation.ui.dialog

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.deved.examenperuapps.R
import com.deved.examenperuapps.presentation.interfaces.ChooseFoto
import com.deved.examenperuapps.presentation.util.Tools

class ChooseFotoDialog(var chooseFoto: ChooseFoto) :DialogFragment(){
    private lateinit var tv_takeFoto:TextView
    private lateinit var tv_chooGaleria:TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.dialog_choose_foto,container,false)
        tv_takeFoto  = view.findViewById(R.id.tv_takeFoto)
        tv_chooGaleria  = view.findViewById(R.id.tv_chooGaleria)
        eventos()
        return view

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ChooseFoto){
            chooseFoto = context as ChooseFoto
        }else{
            Log.e("TAG_E", "must implement optionChosseMyBook")
        }
    }
    private fun eventos() {
        tv_takeFoto.setOnClickListener {
            activity?.let {
                if(Tools.validatePermisionCamera(it)){
                    chooseFoto.chooseElection(1)
                    dismiss()
                }else{
                    dismiss()
                }
            }

        }
        tv_chooGaleria.setOnClickListener {

        }
    }


}