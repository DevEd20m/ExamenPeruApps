package com.deved.examenperuapps.domain.interactor.places

import com.deved.examenperuapps.domain.repository.PlacesRepository

class PlacesUsesCase(private val placesRepository: PlacesRepository) {

    suspend fun getAllPlacesOfPeru(){
        placesRepository.getAllPlacesOfPeru()
    }
}
