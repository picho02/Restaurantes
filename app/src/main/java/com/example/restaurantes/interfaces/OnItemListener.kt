package com.example.restaurantes.interfaces

import com.example.restaurantes.clases.RestauranteResponse

interface OnItemListener {
    fun onItemClick(restaurante: RestauranteResponse)
}