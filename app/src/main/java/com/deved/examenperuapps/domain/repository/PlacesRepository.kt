package com.deved.examenperuapps.domain.repository

import androidx.lifecycle.MutableLiveData
import com.deved.examenperuapps.data.network.model.PlaceNet
import com.deved.examenperuapps.domain.model.Places

interface PlacesRepository {
    suspend fun getAllPlacesOfPeru(): MutableLiveData<List<PlaceNet>>
    suspend fun saveMyExperience(places: Places)
}