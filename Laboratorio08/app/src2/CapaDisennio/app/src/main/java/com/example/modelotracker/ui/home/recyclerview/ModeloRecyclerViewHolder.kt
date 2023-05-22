package com.example.modelotracker.ui.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.modelotracker.data.model.ModeloModel
import com.example.modelotracker.databinding.ModeloItemBinding



//Modifying the disposition of the files to be able to apply the recyclerview
class ModeloRecyclerViewHolder(private val binding: ModeloItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(modelo: ModeloModel, clickListener:(ModeloModel) -> Unit){
        binding.modeloName.text = modelo.name
        binding.modeloQualification.text = modelo.qualification

        binding.modeloItemCardView.setOnClickListener{
            clickListener(modelo)
        }
    }
}