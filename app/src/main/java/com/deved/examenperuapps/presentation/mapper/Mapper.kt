package com.deved.examenperuapps.presentation.mapper

interface Mapper<V, D> {

    fun mapToEntity(type:D): V
}