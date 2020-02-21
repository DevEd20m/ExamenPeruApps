package com.deved.examenperuapps.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deved.examenperuapps.R
import com.deved.examenperuapps.presentation.model.FotoView

class FotosAdapter(val context: Context): RecyclerView.Adapter<FotosAdapter.ViewHolder>() {
    private var list:MutableList<FotoView> = mutableListOf()

    fun setFoto(listFoto: MutableList<FotoView>) {
        this.list = listFoto
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivFoto = itemView.findViewById<ImageView>(R.id.ivFoto)
        var ivAccionFoto = itemView.findViewById<ImageView>(R.id.ivAccionFoto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_foto,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = list[position]

        Glide.with(context).load(item.uri).centerCrop().placeholder(R.drawable.background_login).into(holder.ivFoto)
        holder.ivFoto.setOnClickListener {

        }
        holder.ivAccionFoto.setOnClickListener {

        }
    }

}