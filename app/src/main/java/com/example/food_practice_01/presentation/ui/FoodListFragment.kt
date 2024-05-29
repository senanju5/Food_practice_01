package com.example.food_practice_01.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.food_practice_01.R
import com.example.food_practice_01.adapter.RecipeListViewAdapter
import com.example.food_practice_01.databinding.FragmentFoodListBinding
import com.example.food_practice_01.presentation.viewmodel.MainViewModel
import com.example.food_practice_01.utils.Constants.Companion.API_KEY


class FoodListFragment : Fragment() {
    var _binding: FragmentFoodListBinding? = null
    val binding get() = _binding!!
   private lateinit var  adapter: RecipeListViewAdapter
    private val viewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFoodListBinding.inflate(inflater, container, false)
        val view = binding.root
        setupRecyclerView()
        viewModel.getFoodRecipes(getQuery())
        viewModel.foodRecipes.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        return view
    }

    private fun setupRecyclerView (){
        binding.foodListView.layoutManager = LinearLayoutManager(requireContext())
        adapter = RecipeListViewAdapter{position ->
            val bundle = Bundle()
            bundle.putInt("position", position)
            findNavController().navigate(R.id.action_foodListFragment_to_foodDetailFragment, bundle)
        }
        binding.foodListView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.foodListView.addItemDecoration(dividerItemDecoration)
    }

   private fun getQuery (): HashMap<String, String> {
        val query:HashMap<String, String> = HashMap()
        query["number"] = "10"
        query["apiKey"] = API_KEY
        query["type"] = "snack"
        query["addRecipeInformation"] = "true"
        query["fillIngredients"] = "true"
        return query
    }

}