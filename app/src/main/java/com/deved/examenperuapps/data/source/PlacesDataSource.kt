package com.deved.examenperuapps.data.source

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.deved.examenperuapps.data.network.model.PlaceNet

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QueryDocumentSnapshot


class PlacesDataSource(private var mPlacesDocument: CollectionReference) {

    fun getAllPlacesOfPeru(): MutableLiveData<List<PlaceNet>> {
        val mutable = MutableLiveData<List<PlaceNet>>()
        mPlacesDocument.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                task?.result?.let {
                    var lista = arrayListOf<PlaceNet>()
                    for (document: QueryDocumentSnapshot in it) {
                        lista.add(document.toObject(PlaceNet::class.java))
                    }

                    mutable.value = lista
                }

            } else {
                mutable.value = null
            }
        }
        return mutable
    }

    fun saveMyExperience(placeNet: PlaceNet){
        mPlacesDocument.add(placeNet)
            .addOnSuccessListener {
                Log.d("TAG_D", "DocumentSnapshot added with ID: ${it.id}")
            }.addOnFailureListener {
                Log.w("TAG_D", "Error adding document", it)
            }
    }
}

