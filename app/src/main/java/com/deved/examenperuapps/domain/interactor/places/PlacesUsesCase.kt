package com.deved.examenperuapps.domain.interactor.places

import androidx.lifecycle.MutableLiveData
import com.deved.examenperuapps.data.network.model.PlaceNet
import com.deved.examenperuapps.domain.model.Places
import com.deved.examenperuapps.domain.repository.PlacesRepository
import com.deved.examenperuapps.presentation.model.PlacesView

class PlacesUsesCase(private val placesRepository: PlacesRepository) {

    suspend fun getAllPlacesOfPeru():MutableLiveData<List<PlaceNet>>{
        return placesRepository.getAllPlacesOfPeru()
    }
    suspend fun saveMyExperience(places:Places){
        return placesRepository.saveMyExperience(places)
    }
}
