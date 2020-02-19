package com.deved.examenperuapps.data.source

import android.util.Log
import com.deved.examenperuapps.data.network.model.UserNet
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class LoginDataSource {

    suspend fun signInWithEmailAndPassword(userNet: UserNet):Unit = suspendCancellableCoroutine { continuation->
        userNet.Email?.let { email->
            userNet.Password?.let {password->
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful){
                        continuation.resume(Unit)
                    }else{
                        // todo Eliminar este log, porque es una mala practica.
                        Log.d("TAG_D","signInWithEmailAndPassword",it.exception)
                    }
                }
            }

        }

    }
}