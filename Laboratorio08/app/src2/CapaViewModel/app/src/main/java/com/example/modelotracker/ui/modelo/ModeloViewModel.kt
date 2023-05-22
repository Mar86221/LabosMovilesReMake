package com.example.modelotracker.ui.modelo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.modelotracker.ModeloReviewerAplicattion
import com.example.modelotracker.data.model.ModeloModel
import com.example.modelotracker.repositorie.ModeloRepository
import kotlin.contracts.Returns
//Creating the fragments that will be used in the project
class ModeloViewModel(private val repository: ModeloRepository) : ViewModel() {
    //We create MutableLiveData to be able to apply LiveData and DataBinding
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getModelos() =  repository.getModelos()

    fun addModelos(modelo: ModeloModel) = repository.addModelos(modelo)
    //Creating the Create function that checks if the data is empty or null
    fun createModelo(){
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val modelo = ModeloModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addModelos(modelo)
        clearData()

        status.value = MODELO_CREATED
    }
    //This function is the one that validates if the information is correct which is used by the Create function
    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }
    //This function clears the variables to their original state
    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }
    //This, like cleardata, clears the status back to its original state
    fun clearStatus(){
        status.value = INACTIVE
    }
    //Initializing the ViewModel
    companion object {
       val Factory = viewModelFactory {
           initializer {
               val app = this[APPLICATION_KEY] as ModeloReviewerAplicattion
               ModeloViewModel(app.modeloRepository)

           }
       }
        const val MODELO_CREATED = "Modelo created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }


}