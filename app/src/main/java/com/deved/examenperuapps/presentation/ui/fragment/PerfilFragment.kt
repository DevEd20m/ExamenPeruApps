package com.deved.examenperuapps.presentation.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.deved.examenperuapps.R
import com.deved.examenperuapps.data.repository.PlacesDataRepository
import com.deved.examenperuapps.domain.interactor.places.PlacesUsesCase
import com.deved.examenperuapps.presentation.adapter.PlacesAdapter
import com.deved.examenperuapps.presentation.di.PlacesViewModelFactory
import com.deved.examenperuapps.presentation.interfaces.BottomNavigation
import com.deved.examenperuapps.presentation.mapper.PlacesMapper
import com.deved.examenperuapps.presentation.model.PlacesView
import com.deved.examenperuapps.presentation.viewModel.PlacesViewModel
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query

/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment(),BottomNavigation {

    override fun newInstance(): Fragment {
        return PerfilFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)


        return view
    }


}
