package com.example.restaurantes.clases

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Restaurante(@SerializedName("restaurantes") val restaurantes: List<RestauranteResponse>): Serializable
