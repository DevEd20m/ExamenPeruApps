package com.deved.examenperuapps.presentation.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_places.view.*

/**
 * A simple [Fragment] subclass.
 */
class PlacesFragment : Fragment(), BottomNavigation {

    private lateinit var mDocCollection: CollectionReference
    private lateinit var placesAdapter: PlacesAdapter
    private lateinit var placesViewModel: PlacesViewModel
    private lateinit var placesViewModelFactory: PlacesViewModelFactory
    private var rv_places: RecyclerView? = null
    private lateinit var vista: View

    open override fun newInstance(): Fragment {
        return PlacesFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_places, container, false)
        setUpUi()
        setUpFirebaseDb()
        setUpViewModel()

        loadPlaces()

        return vista
    }

    override fun setUpUi() {
        rv_places = vista?.findViewById(R.id.rv_places)
        rv_places?.layoutManager = LinearLayoutManager(activity)
        rv_places?.setHasFixedSize(true)
    }


    private fun loadPlaces() {
        placesAdapter = PlacesAdapter()
        placesViewModel.getAllPlacesOfPeru().observe(this, Observer {
            if (it != null) {
                placesAdapter.setData(it)
                rv_places?.adapter = placesAdapter
            }
        })

    }

    private fun setUpViewModel() {
        placesViewModelFactory = PlacesViewModelFactory(
            PlacesUsesCase(PlacesDataRepository(mDocCollection)),
            PlacesMapper()
        )
        placesViewModel =
            ViewModelProvider(this, placesViewModelFactory).get(PlacesViewModel::class.java)
    }

    private fun setUpFirebaseDb() {
        mDocCollection = FirebaseFirestore.getInstance().collection("places")
    }

}
