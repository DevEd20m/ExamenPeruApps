package com.deved.examenperuapps.data.repository

import com.deved.examenperuapps.data.source.PlacesDataSource
import com.deved.examenperuapps.domain.repository.PlacesRepository
import com.google.firebase.firestore.CollectionReference

class PlacesDataRepository(val mPlaceCollection: CollectionReference):PlacesRepository {
    override suspend fun getAllPlacesOfPeru() {
        val placesDataSource = PlacesDataSource(mPlaceCollection)
        placesDataSource.getAllPlacesOfPeru()
    }

}