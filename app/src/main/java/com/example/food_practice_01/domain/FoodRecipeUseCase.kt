package com.example.food_practice_01.domain

import com.example.food_practice_01.data.model.FoodRecipe
import com.example.food_practice_01.data.repository.FoodRecipeRepository
import kotlinx.coroutines.flow.Flow

class FoodRecipeUseCase(private val foodRecipeRepository: FoodRecipeRepository = FoodRecipeRepository()) {
    suspend  fun getFoodRecipe(queries: Map<String, String>) : Flow<List<FoodRecipe>> {
        return foodRecipeRepository.getFoodRecipes(queries)
    }

}