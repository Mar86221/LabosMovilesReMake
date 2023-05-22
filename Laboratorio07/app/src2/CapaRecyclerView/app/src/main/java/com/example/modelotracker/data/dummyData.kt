package com.example.modelotracker.data

import android.view.Display.Mode
import com.example.modelotracker.data.model.ModeloModel

//Creating burned data to be able to test the functionalities
val name = "DataN"
val category = "DataC"
val description = "DataD"
val qualification = "DataQ"

val name2 = "DataN2"
val category2 = "DataC2"
val description2 = "DataD2"
val qualification2 = "DataQ2"

var modelos = mutableListOf(
    ModeloModel(name, category, description, qualification),
    ModeloModel(name2, category2, description2, qualification2)
)