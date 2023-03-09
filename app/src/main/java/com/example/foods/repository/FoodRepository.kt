package com.example.foods.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foods.api.FoodApi
import com.example.foods.models.Yogurt
import javax.inject.Inject

class FoodRepository @Inject constructor(private val foodApi: FoodApi) {

    private val _foodLiveData = MutableLiveData<Yogurt>()
    val foodLiveData: LiveData<Yogurt>
    get() = _foodLiveData

    suspend fun getFoods(queryFood: String) {
        val response = foodApi.getFoods(queryFood)
        if (response?.body() != null) {
            _foodLiveData.postValue(response.body())
        }
    }
}