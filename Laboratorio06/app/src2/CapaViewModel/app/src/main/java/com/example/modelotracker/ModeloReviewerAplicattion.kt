package com.example.modelotracker

import android.app.Application
import com.example.modelotracker.data.modelos
import com.example.modelotracker.repositorie.ModeloRepository
//Creating ModelReviewerApplication which postpones the creation of the repository until it is used
class ModeloReviewerAplicattion: Application(){
    val modeloRepository: ModeloRepository by lazy {
        ModeloRepository(modelos)
    }
}