package com.example.restaurantes.interfaces

import com.example.restaurantes.clases.Restaurante
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getRestaurant(@Url url:String): Response<Restaurante>
}