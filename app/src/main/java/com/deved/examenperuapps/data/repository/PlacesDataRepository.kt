package com.deved.examenperuapps.data.repository

import androidx.lifecycle.MutableLiveData
import com.deved.examenperuapps.data.mapper.PlacesToDataMapper
import com.deved.examenperuapps.data.network.model.PlaceNet
import com.deved.examenperuapps.data.source.PlacesDataSource
import com.deved.examenperuapps.domain.model.Places
import com.deved.examenperuapps.domain.repository.PlacesRepository
import com.google.firebase.firestore.CollectionReference

class PlacesDataRepository(val mPlaceCollection: CollectionReference) : PlacesRepository {


    override suspend fun getAllPlacesOfPeru(): MutableLiveData<List<PlaceNet>> {
        val placesDataSource = PlacesDataSource(mPlaceCollection)
        return placesDataSource.getAllPlacesOfPeru()
    }

    override suspend fun saveMyExperience(places:Places) {
        val placesDataSource = PlacesDataSource(mPlaceCollection)
        val placesToDataMapper = PlacesToDataMapper()
        placesDataSource.saveMyExperience(placesToDataMapper.mapFromEntity(places))
    }

}