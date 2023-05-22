package com.example.modelotracker.ui.modelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.modelotracker.databinding.FragmentModeloBinding
import com.example.modelotracker.ui.modelo.viewmodel.ModeloViewModel

//Creating the fragments that will be used in the project
class ModeloFragment : Fragment() {

    private val viewModel: ModeloViewModel by activityViewModels {
        ModeloViewModel.Factory
    }

    private lateinit var binding: FragmentModeloBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModeloBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.name.observe(viewLifecycleOwner) { newname ->
            binding.modeloNameTextView.text = newname
        }

        viewModel.category.observe(viewLifecycleOwner) { newcategory ->
            binding.modeloCategoryTextView.text = newcategory
        }

        viewModel.qualification.observe(viewLifecycleOwner) { newcal ->
            binding.modeloCalificationTextModelo.text = newcal
        }
        viewModel.description.observe(viewLifecycleOwner) { newdesc ->
            binding.modeloDescriptionTextView.text = newdesc
        }


    }


}