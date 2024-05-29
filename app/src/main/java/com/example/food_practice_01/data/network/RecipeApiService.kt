package com.example.food_practice_01.data.network

import com.example.food_practice_01.data.network.model.RemoteFoodRecipe
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RecipeApiService {
    @GET("/recipes/complexSearch")
    suspend fun getRecipes(@QueryMap query: Map<String, String>): RemoteFoodRecipe
}