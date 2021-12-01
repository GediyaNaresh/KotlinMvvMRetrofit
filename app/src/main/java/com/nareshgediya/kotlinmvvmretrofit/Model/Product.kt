package com.nareshgediya.kotlinmvvmretrofit.Model

data class Product(
    val id: String,
    val images: List<String>,
    val new_price: String,
    val old_price: String,
    val product_img1: String,
    val product_name: String,
    val shipping_rate: String,
    val wishlist: Int
)