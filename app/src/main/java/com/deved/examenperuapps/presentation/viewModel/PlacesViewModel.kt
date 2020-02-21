package com.deved.examenperuapps.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deved.examenperuapps.data.network.model.PlaceNet
import com.deved.examenperuapps.domain.interactor.places.PlacesUsesCase
import com.deved.examenperuapps.domain.model.Places
import com.deved.examenperuapps.presentation.mapper.PlacesMapper
import com.deved.examenperuapps.presentation.model.PlacesView
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class PlacesViewModel(
    private val placesUsesCase: PlacesUsesCase,
    private val mapperPlaces: PlacesMapper): ViewModel(){

    fun getAllPlacesOfPeru():MutableLiveData<List<PlaceNet>>{
        var lista = MutableLiveData<List<PlaceNet>>()
        runBlocking {
            async { lista = placesUsesCase.getAllPlacesOfPeru() } }
        return lista
    }

    fun saveMyExperience(placesView: PlacesView) = viewModelScope.launch{
        placesUsesCase.saveMyExperience(mapperPlaces.mapToEntity(placesView))
    }
}



