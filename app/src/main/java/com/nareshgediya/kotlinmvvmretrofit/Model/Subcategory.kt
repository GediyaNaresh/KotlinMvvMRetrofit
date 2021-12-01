package com.nareshgediya.kotlinmvvmretrofit.Model

data class Subcategory(
    val products: List<Product>,
    val subcategory: String,
    val subcategory_id: String
)