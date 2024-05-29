package com.example.food_practice_01.data.network.model


import com.google.gson.annotations.SerializedName

data class RemoteFoodRecipe(
    @SerializedName("number")
    val number: Int, // 1
    @SerializedName("offset")
    val offset: Int, // 0
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("totalResults")
    val totalResults: Int // 687
)