package com.example.modelotracker.ui.modelo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.modelotracker.R
import com.example.modelotracker.databinding.FragmentHomeBinding
import com.example.modelotracker.databinding.FragmentModeloBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
//Creating the fragments that will be used in the project\
//Implementing navigation component to all fragments for navigation flow
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var buttonNewMovie: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()

        buttonNewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_newModeloFragment)
        }

    }
    companion object {

    }

    private fun bind(){
        buttonNewMovie = view?.findViewById(R.id.new_movie_button) as FloatingActionButton
    }
}