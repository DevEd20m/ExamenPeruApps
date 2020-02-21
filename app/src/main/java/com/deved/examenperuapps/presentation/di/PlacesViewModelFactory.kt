package com.deved.examenperuapps.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deved.examenperuapps.domain.interactor.places.PlacesUsesCase
import com.deved.examenperuapps.presentation.mapper.PlacesMapper
import com.deved.examenperuapps.presentation.viewModel.PlacesViewModel


class PlacesViewModelFactory(private val placesUsesCase: PlacesUsesCase,private val placesMapper: PlacesMapper):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlacesViewModel(placesUsesCase,placesMapper) as T
    }

}