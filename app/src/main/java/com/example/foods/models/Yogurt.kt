package com.example.foods.models

data class Yogurt(
    val expires: Long,
    val isStale: Boolean,
    val number: Int,
    val offset: Int,
    val processingTimeMs: Int,
    val products: List<Product>,
    val totalProducts: Int,
    val type: String
)