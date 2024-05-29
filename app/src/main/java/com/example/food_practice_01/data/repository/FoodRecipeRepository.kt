package com.example.food_practice_01.data.repository

import com.example.food_practice_01.data.model.FoodRecipe
import com.example.food_practice_01.data.network.model.RemoteFoodRecipe
import com.example.food_practice_01.data.remotedata.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FoodRecipeRepository(private val remoteDataSource: RemoteDataSource = RemoteDataSource()) {

    suspend fun getFoodRecipes(queries: Map<String, String>): Flow<List<FoodRecipe>> = flow {
        var foodRecipes: MutableList<FoodRecipe> = mutableListOf()
        val remoteFoodRecipe: RemoteFoodRecipe = remoteDataSource.getRemoteData(queries)
        for (foodRecipe in remoteFoodRecipe.results) {
            foodRecipes.add(FoodRecipe(foodRecipe.id, foodRecipe.image, foodRecipe.title, foodRecipe.summary, foodRecipe.pricePerServing ))
        }

        emit(foodRecipes)

    }.flowOn(Dispatchers.IO)
}