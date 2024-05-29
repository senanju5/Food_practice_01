package com.example.food_practice_01.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food_practice_01.data.model.FoodRecipe
import com.example.food_practice_01.domain.FoodRecipeUseCase
import kotlinx.coroutines.launch
import retrofit2.http.Query

class MainViewModel(private val foodRecipeUseCase: FoodRecipeUseCase = FoodRecipeUseCase()): ViewModel() {

    val foodRecipes = MutableLiveData<List<FoodRecipe>>()

    fun getFoodRecipes(queries: Map<String, String>) {
        viewModelScope.launch {
            foodRecipeUseCase.getFoodRecipe(queries).collect{
                foodRecipes.value = it
            }
        }
    }

}