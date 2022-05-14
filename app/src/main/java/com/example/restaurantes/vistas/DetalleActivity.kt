package com.example.restaurantes.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantes.adapters.AdapterFotos
import com.example.restaurantes.adapters.AdapterResenia
import com.example.restaurantes.clases.RestauranteResponse
import com.example.restaurantes.databinding.ActivityDetalleBinding
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val restaurante = bundle?.getSerializable("restaurante") as RestauranteResponse
        if (restaurante!=null){
            binding.tvNombreDetalle.text = restaurante.nombre
            binding.tvCalyCost.text = "Cal: ${restaurante.calificacionPromedio}    $ ${restaurante.costoPromedio}   Inagurado: ${restaurante.fundacion}"
            binding.tvDireccion.text = restaurante.direccion
            val adapterFotos = AdapterFotos(restaurante.fotos)
            Picasso.get().load(restaurante.fotos.first()).into(binding.ivPrincipal)
            binding.rvImagenes.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
            binding.rvImagenes.adapter = adapterFotos
            val adapterResenia = AdapterResenia(restaurante.resenia)
            binding.rvResenia.layoutManager = LinearLayoutManager(this)
            binding.rvResenia.adapter = adapterResenia

        }
    }
}