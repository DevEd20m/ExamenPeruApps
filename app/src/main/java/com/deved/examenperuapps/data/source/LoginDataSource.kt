package com.deved.examenperuapps.data.source

import com.deved.examenperuapps.data.network.model.UserNet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LoginDataSource {

    suspend fun signInWithEmailAndPassword(userNet: UserNet):Unit = suspendCancellableCoroutine { continuation->
        userNet.Email?.let { email->
            userNet.Password?.let {password->
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if(it.isSuccessful){
                        continuation.resume(Unit)
                    }else{
                        it.exception?.message?.let {message->
                            continuation.resumeWithException(FirebaseAuthException(message,"Recuerde ingresar credenciales correctas"))
                        }

                    }
                }
            }

        }

    }
}