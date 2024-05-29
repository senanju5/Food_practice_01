package com.example.food_practice_01.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.food_practice_01.data.model.FoodRecipe
import com.example.food_practice_01.databinding.FragmentFoodDetailBinding
import com.example.food_practice_01.presentation.viewmodel.MainViewModel


class FoodDetailFragment : Fragment() {

    private var _binding:FragmentFoodDetailBinding?=null
    private val binding get() = _binding!!
    private val viewModel:MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFoodDetailBinding.inflate(inflater,container,false)
       val view = binding.root

        val position = arguments?.getInt("position")
        viewModel.foodRecipes.observe(viewLifecycleOwner){
            setFoodDetails(it[position!!])
        }
        return view
    }

    private fun setFoodDetails(food : FoodRecipe) {
        binding.detailImageView.load(food.image)
        binding.titleTextView.text = food.title
        binding.priceTextView.text = food.pricePerServing.toString()
        binding.summaryTextView.text = food.summary
    }

}