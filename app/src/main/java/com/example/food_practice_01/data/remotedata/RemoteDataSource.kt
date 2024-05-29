package com.example.food_practice_01.data.remotedata

import com.example.food_practice_01.data.network.model.RemoteFoodRecipe
import com.example.food_practice_01.data.network.RetrofitClient

class RemoteDataSource {

    suspend fun getRemoteData(queies:Map<String, String>): RemoteFoodRecipe {
        return RetrofitClient.recipeApiService.getRecipes(queies)
    }
}