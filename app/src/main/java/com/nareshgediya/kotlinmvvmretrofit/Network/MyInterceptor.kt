package com.nareshgediya.kotlinmvvmretrofit.Network

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("Authorization","Basic YXZhZGh0X3RleHRpbGU6MjAkdGdic3YwOShxYXZzdQ==")
            .build()

        return chain.proceed(request)
    }
}