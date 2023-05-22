package com.example.modelotracker.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modelotracker.R
import com.example.modelotracker.data.model.ModeloModel
import com.example.modelotracker.databinding.FragmentHomeBinding
import com.example.modelotracker.ui.home.recyclerview.ModelosAdapter
import com.example.modelotracker.ui.modelo.viewmodel.ModeloViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
//Creating the fragments that will be used in the project\
//Implementing navigation component to all fragments for navigation flow
//Replacing the functions previously done with binding and liveata to apply the recyvler view
class HomeFragment : Fragment() {

    private val viewModel: ModeloViewModel by activityViewModels {
        ModeloViewModel.Factory
    }
    private lateinit var binding: FragmentHomeBinding
    private lateinit var buttonNewMovie: FloatingActionButton
    private lateinit var adapter: ModelosAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.newModeloButton.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newModeloFragment)
        }

    }
    companion object {

    }

    private fun setRecyclerView(view: View){
        binding.recyclerModelos.layoutManager = LinearLayoutManager(view.context)

        adapter = ModelosAdapter { selectedModelo ->
            showSelectedItem(selectedModelo)

        }

        binding.recyclerModelos.adapter = adapter
        displayModelos()

    }

    private fun displayModelos(){
        adapter.setData(viewModel.getModelos())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(modelo: ModeloModel) {
        viewModel.setSelectedModelo(modelo)
        findNavController().navigate(R.id.action_homeFragment_to_modeloFragment)
    }
}