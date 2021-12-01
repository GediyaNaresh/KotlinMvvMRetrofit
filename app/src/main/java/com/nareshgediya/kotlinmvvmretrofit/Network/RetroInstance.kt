package com.nareshgediya.kotlinmvvmretrofit.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{


        private val client = OkHttpClient.Builder().apply {
            addInterceptor(MyInterceptor())
        }.build()

     //   val BaseUrl = "https://api.github.com/search/"
        val BaseUrl = "https://shopno.in/gujjustore.in/api/v1/"

        fun getRetrofitInstnace() :Retrofit{

            return Retrofit.Builder()
            .baseUrl(BaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}