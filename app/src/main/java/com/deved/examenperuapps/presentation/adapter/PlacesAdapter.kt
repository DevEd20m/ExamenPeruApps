package com.deved.examenperuapps.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.deved.examenperuapps.R
import com.deved.examenperuapps.presentation.model.PlacesView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class PlacesAdapter(options:FirebaseRecyclerOptions<PlacesView>):FirebaseRecyclerAdapter<PlacesView,PlacesViewHolder>(options){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PlacesViewHolder(inflater.inflate(R.layout.item_places,parent,false))
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int, model: PlacesView) {
        holder.tv_nameDepartamento.text =model.Departament
    }

}