package com.example.modelotracker.ui.modelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modelotracker.R
import com.example.modelotracker.databinding.FragmentModeloBinding
//Creating the fragments that will be used in the project
class ModeloFragment : Fragment() {

    private lateinit var binding: FragmentModeloBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModeloBinding.inflate(inflater, container, false)
        return binding.root
    }

}