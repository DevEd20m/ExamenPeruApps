package com.deved.examenperuapps.presentation.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.deved.examenperuapps.R
import com.deved.examenperuapps.data.repository.PlacesDataRepository
import com.deved.examenperuapps.domain.interactor.places.PlacesUsesCase
import com.deved.examenperuapps.presentation.di.PlacesViewModelFactory
import com.deved.examenperuapps.presentation.interfaces.BottomNavigation
import com.deved.examenperuapps.presentation.mapper.PlacesMapper
import com.deved.examenperuapps.presentation.model.PlacesView
import com.deved.examenperuapps.presentation.util.Tools
import com.deved.examenperuapps.presentation.viewModel.PlacesViewModel
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 */
class ShareExperienceFragment : Fragment(), BottomNavigation {
    private lateinit var tv_departamentExp: TextView
    private lateinit var tv_descriptionExp: TextView
    private lateinit var btn_saveExperience: Button
    private lateinit var vista: View

    private lateinit var mDocCollection: CollectionReference
    private lateinit var placesViewModel: PlacesViewModel
    private lateinit var placesViewModelFactory: PlacesViewModelFactory


    override fun newInstance(): Fragment {
        return ShareExperienceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_share_experience, container, false)
        setUpUi()
        setUpFirebase()
        setUpViewModel()

        btn_saveExperience.setOnClickListener {
            val departament = tv_departamentExp.text.toString()
            val description = tv_descriptionExp.text.toString()
            val placesView = PlacesView(null, departament, description, "", "", "Hoy")
            if (validateInputPlaces(placesView)) {
                placesViewModel.saveMyExperience(placesView)
            } else {
                Log.d("TAG_D", "DAtos incompletos")
            }
        }
        return vista
    }

    private fun setUpFirebase() {
        mDocCollection = FirebaseFirestore.getInstance().collection("places")
    }

    private fun setUpViewModel() {
        placesViewModelFactory = PlacesViewModelFactory(
            PlacesUsesCase(PlacesDataRepository(mDocCollection)),
            PlacesMapper()
        )
        placesViewModel =
            ViewModelProvider(this, placesViewModelFactory).get(PlacesViewModel::class.java)
    }


    override fun setUpUi() {
        tv_departamentExp = vista.findViewById(R.id.tv_departamentExp)
        tv_descriptionExp = vista.findViewById(R.id.tv_descriptionExp)
        btn_saveExperience = vista.findViewById(R.id.btn_saveExperience)
    }


    private fun validateInputPlaces(placesView: PlacesView): Boolean {
        return Tools.validateNull(placesView.Departament) &&
                Tools.validateNull(placesView.Decription) &&
                Tools.validateNull(placesView.CreateAt)
    }

}
