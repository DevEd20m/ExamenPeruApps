package com.deved.examenperuapps.presentation.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
import com.deved.examenperuapps.presentation.viewModel.PlacesViewModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlinx.android.synthetic.main.fragment_places.*
import kotlinx.android.synthetic.main.fragment_places.view.*

/**
 * A simple [Fragment] subclass.
 */
class PlacesFragment : Fragment(), BottomNavigation {
    private lateinit var mDocCollection:CollectionReference
//    private lateinit var placesAdapter: PlacesAdapter
    private lateinit var placesViewModel: PlacesViewModel
    private lateinit var placesViewModelFactory : PlacesViewModelFactory
    private var rv_places : RecyclerView? = null
    private var btntest : Button? = null

    open override fun newInstance(): Fragment {
        return PlacesFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_places, container, false)
        setUpUi()
        setUpFirebaseDb()
        setUpViewModel()


        view.btntest2.setOnClickListener {
            loadPlaces()
        }

        return view
    }

    private fun setUpUi() {
        rv_places = view?.findViewById(R.id.rv_places)
        btntest = view?.findViewById(R.id.btntest)
        rv_places?.layoutManager = LinearLayoutManager(activity)
        rv_places?.setHasFixedSize(true)


    }

    private fun loadPlaces() {
        placesViewModel.getAllPlacesOfPeru()
    }

    private fun setUpViewModel() {
        placesViewModelFactory = PlacesViewModelFactory(PlacesUsesCase(PlacesDataRepository(mDocCollection)), PlacesMapper())
        placesViewModel = ViewModelProvider(this,placesViewModelFactory).get(PlacesViewModel::class.java)
    }

    private fun setUpFirebaseDb() {
        mDocCollection = FirebaseFirestore.getInstance().collection("places")
    }

    override fun onStart() {
        super.onStart()
//        placesAdapter.startListening()
    }
    override fun onStop() {
        super.onStop()
//        placesAdapter.stopListening()
    }


}
