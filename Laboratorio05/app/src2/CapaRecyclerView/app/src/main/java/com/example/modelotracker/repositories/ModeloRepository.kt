package com.example.modelotracker.repositorie

import com.example.modelotracker.data.model.ModeloModel
//Creating repository model which will carry the functions that will be done like get and add
class ModeloRepository(private val modelos: MutableList<ModeloModel>){
    fun getModelos() = modelos

    fun addModelos(modelo: ModeloModel) = modelos.add(modelo)
}