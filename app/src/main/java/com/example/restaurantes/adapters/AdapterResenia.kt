package com.example.restaurantes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantes.clases.Resenia

import com.example.restaurantes.databinding.ItemReseniaBinding

import com.example.restaurantes.holders.ReseniaViewHolder

class AdapterResenia(val resenias: List<Resenia>): RecyclerView.Adapter<ReseniaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReseniaViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemReseniaBinding.inflate(inflate)
        return ReseniaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReseniaViewHolder, position: Int) {
        val resenia = resenias[position]
        holder.render(resenia)
    }

    override fun getItemCount(): Int {
        return resenias.size
    }
}