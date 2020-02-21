package com.deved.examenperuapps.data.source

import android.util.Log
import com.deved.examenperuapps.data.network.model.UserNet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegisterDataSource {
    fun registerUserWithFirebase(user: UserNet) {
        user.Email?.let {
            user.Password?.let {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(user.Email, user.Password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val perfilUpdate = UserProfileChangeRequest.Builder()
                                .setDisplayName(user.LastName)
                                .build()

                            FirebaseAuth.getInstance().currentUser?.updateProfile(perfilUpdate)
                                ?.addOnCompleteListener {
                                    if (it.isSuccessful) {

                                        Log.d("TAG_D", "Succcess register")
                                    }
                                }
                        } else {
                            Log.d("TAG_D", "error")
                            // todo eliminar estos logs, porque son una mala practica
                        }

                    }
            }

        }

    }
}