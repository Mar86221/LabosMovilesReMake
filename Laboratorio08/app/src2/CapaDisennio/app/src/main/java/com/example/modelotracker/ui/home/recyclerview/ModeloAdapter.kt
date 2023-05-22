package com.example.modelotracker.ui.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modelotracker.data.model.ModeloModel
import com.example.modelotracker.databinding.ModeloItemBinding
import java.util.ArrayList
//We create the adapter with its following methods which are responsible for creating new
//instances, updating views, returning the number of elements, etc.
class ModelosAdapter (
    private val clickListener: (ModeloModel) -> Unit
) : RecyclerView.Adapter<ModeloRecyclerViewHolder>() {
    private val modelos = ArrayList<ModeloModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeloRecyclerViewHolder {
        val binding = ModeloItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModeloRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modelos.size
    }

    override fun onBindViewHolder(holder: ModeloRecyclerViewHolder, position: Int) {
        val modelo = modelos[position]
        holder.bind(modelo, clickListener)
    }

    fun setData(modelosList: List<ModeloModel>){
        modelos.clear()
        modelos.addAll(modelosList)
    }
}