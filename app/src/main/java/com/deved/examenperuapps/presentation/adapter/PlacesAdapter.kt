package com.deved.examenperuapps.presentation.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deved.examenperuapps.R
import com.deved.examenperuapps.data.network.model.PlaceNet


class PlacesAdapter() : RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {
    private var listPlaces:List<PlaceNet> = arrayListOf()

    fun setData(list:List<PlaceNet>){
        this.listPlaces = list
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_nameDepartamento = itemView.findViewById<TextView>(R.id.tv_nameDepartamento)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_places,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPlaces.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = listPlaces[position]
        holder.tv_nameDepartamento.text = item.Departament
    }


}