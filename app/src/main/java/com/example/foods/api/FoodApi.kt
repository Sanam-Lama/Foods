package com.example.foods.api

import com.example.foods.models.Product
import com.example.foods.models.Yogurt
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.spoonacular.com/food/products/search?query=yogurt&apiKey=631f839e8ebd45a9b1fc48f886a8d953

const val API_KEY = "631f839e8ebd45a9b1fc48f886a8d953"
interface FoodApi {

    @GET("products/search?apiKey=$API_KEY")
    suspend fun getFoods(@Query ("query") query: String) : Response<Yogurt>
}