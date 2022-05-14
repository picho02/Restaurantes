package com.example.restaurantes.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantes.clases.Resenia
import com.example.restaurantes.databinding.ItemReseniaBinding
import com.squareup.picasso.Picasso

class ReseniaViewHolder (binding: ItemReseniaBinding) : RecyclerView.ViewHolder(binding.root) {
    private val binding = binding
    private lateinit var resenia: Resenia
    fun render(resenia: Resenia) {
        this.resenia = resenia
        binding.tvUsuarioResenia.text = resenia.usuario
        binding.tvFechayCal.text = "Cal: ${resenia.calificacion}     Fecha: ${resenia.fecha}"
        binding.tvTituloRes.text = resenia.titulo
        binding.tvResenia.text = resenia.resenia


    }
}