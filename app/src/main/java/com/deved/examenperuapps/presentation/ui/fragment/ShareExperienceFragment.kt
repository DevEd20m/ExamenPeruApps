package com.deved.examenperuapps.presentation.ui.fragment


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deved.examenperuapps.R
import com.deved.examenperuapps.data.repository.PlacesDataRepository
import com.deved.examenperuapps.domain.interactor.places.PlacesUsesCase
import com.deved.examenperuapps.presentation.adapter.FotosAdapter
import com.deved.examenperuapps.presentation.di.PlacesViewModelFactory
import com.deved.examenperuapps.presentation.interfaces.BottomNavigation
import com.deved.examenperuapps.presentation.interfaces.ChooseFoto
import com.deved.examenperuapps.presentation.mapper.PlacesMapper
import com.deved.examenperuapps.presentation.model.FotoView
import com.deved.examenperuapps.presentation.model.PlacesView
import com.deved.examenperuapps.presentation.ui.dialog.ChooseFotoDialog
import com.deved.examenperuapps.presentation.util.Tools
import com.deved.examenperuapps.presentation.viewModel.PlacesViewModel
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 */
class ShareExperienceFragment : Fragment(), BottomNavigation, ChooseFoto {


    private lateinit var tv_departamentExp: TextView
    private lateinit var tv_descriptionExp: TextView
    private lateinit var btn_saveExperience: Button
    private lateinit var rv_contentFotos: RecyclerView
    private lateinit var listFoto: MutableList<FotoView>
    private lateinit var vista: View
    private lateinit var iv_addFoto: ImageView
    private lateinit var fotosAdapter: FotosAdapter

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

        iv_addFoto.setOnClickListener {
            addFoto()
        }
        return vista
    }

    private fun addFoto() {
        if (!Tools.validateNumberPictures(listFoto)) {
            val dialog = ChooseFotoDialog(this)
            fragmentManager?.let {
                dialog.show(it, "dialog_choose_foto")
            }
        }
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
        rv_contentFotos = vista.findViewById(R.id.rv_contentFotos)
        iv_addFoto = vista.findViewById(R.id.iv_addFoto)

        listFoto = mutableListOf()

    }


    private fun validateInputPlaces(placesView: PlacesView): Boolean {
        return Tools.validateNull(placesView.Departament) &&
                Tools.validateNull(placesView.Decription) &&
                Tools.validateNull(placesView.CreateAt)
    }

    override fun chooseElection(numero: Int) {
        if (numero == 1) {
            takeFoto()
        }
    }

    private fun takeFoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 1)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            try {
                val uri = data?.extras?.get("data") as Bitmap
                context?.let {
                    rv_contentFotos.layoutManager = LinearLayoutManager(it)
                    rv_contentFotos.setHasFixedSize(true)
                    fotosAdapter = FotosAdapter(it)
                    val utiNew = Tools.getUriToBitmap(it,uri)
                    val imageUri = FotoView(utiNew)
                    listFoto.add(imageUri)
                    fotosAdapter.setFoto(listFoto)
                    rv_contentFotos.adapter = fotosAdapter
                }



            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
