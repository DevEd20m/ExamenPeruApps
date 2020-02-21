package com.deved.examenperuapps.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deved.examenperuapps.domain.interactor.places.PlacesUsesCase
import com.deved.examenperuapps.domain.model.Places
import com.deved.examenperuapps.presentation.mapper.PlacesMapper
import com.deved.examenperuapps.presentation.model.PlacesView
import kotlinx.coroutines.launch

class PlacesViewModel(
    private val placesUsesCase: PlacesUsesCase,
    private val mapperPlaces: PlacesMapper): ViewModel(){

    fun getAllPlacesOfPeru()=viewModelScope.launch {
        placesUsesCase.getAllPlacesOfPeru()
    }
}