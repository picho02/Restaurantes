package com.example.restaurantes.interfaces

import com.example.restaurantes.clases.Restaurante
import com.example.restaurantes.clases.UsuarioResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getRestaurant(@Url url:String): Response<Restaurante>
    @GET
    suspend fun getUsuarios(@Url url: String): Response<UsuarioResponse>
}