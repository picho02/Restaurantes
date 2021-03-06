package com.example.restaurantes.clases

import com.example.restaurantes.clases.Resenia
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class RestauranteResponse(@SerializedName("id") val id:Int, @SerializedName("nombre") val nombre:String, @SerializedName("calificacion_promedio") val calificacionPromedio:Int,
                               @SerializedName("anio_creacion") val fundacion:String, @SerializedName("costo_promedio") val costoPromedio:Int, @SerializedName("fotos") val fotos: List<String>,
                               @SerializedName("resenia") val resenia:List<Resenia>, @SerializedName("telefono") val telefono: String, @SerializedName("direccion") val direccion:String) : Serializable