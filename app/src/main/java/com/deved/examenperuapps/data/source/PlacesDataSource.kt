package com.deved.examenperuapps.data.source

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.*


class PlacesDataSource(private var mPlacesDocument:CollectionReference) {

    fun getAllPlacesOfPeru() {

        mPlacesDocument.get().addOnCompleteListener{task->
            if(task.isSuccessful){
                task?.result?.let {
                    for(document:QueryDocumentSnapshot in it){
                        Log.d("TAG_D","${document.id} -> ${document.data}")
                    }
                }

            }else{
                Log.w("TAG_D","Error getting document -> ${task.exception}")
            }
        }

    }
}
