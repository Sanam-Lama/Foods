package com.example.foods.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foods.models.Yogurt
import com.example.foods.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val foodRepository: FoodRepository): ViewModel() {

    val foods: LiveData<Yogurt>
    get() = foodRepository.foodLiveData

    fun getFoods() {
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.getFoods("yogurt")
        }
    }
}