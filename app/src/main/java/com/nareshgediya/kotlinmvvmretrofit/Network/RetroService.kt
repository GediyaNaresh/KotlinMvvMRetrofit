package com.nareshgediya.kotlinmvvmretrofit.Network


import com.nareshgediya.kotlinmvvmretrofit.Model.*
import retrofit2.Call
import retrofit2.http.*

interface RetroService {
    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String): RecyclerList

    @GET("users")
    suspend fun getUsersFromApi(@Query("q") query: String): RecyclerUserList

    @FormUrlEncoded
    @POST("user_info")
    suspend fun getUserInfo(@Field("user_id") user_id: Int): UserDataInfo

    @FormUrlEncoded
    @POST("view_all_product")
    suspend fun getAllPoduct(@Field("user_id") user_id: Int,
                             @Field("sort_by") sort_by: String): AllProduct

    @FormUrlEncoded
    @POST("category_wise_product")
    suspend fun getCategorywiseProduct(  @Field("cid") cid: Int,
                                         @Field("user_id") user_id: Int,
                                         @Field("sort_by") sort_by: String): CategoryWiseProduct


    @FormUrlEncoded
    @POST("subcategory_wise_product")
    suspend fun getSubCategorywiseProduct(  @Field("sid") cid: String): SubcategoryWiseProduct

    @FormUrlEncoded
    @POST("subcategory_wise_product")
     fun getSubCategoryProduct(  @Field("sid") cid: String): Call<SubcategoryWiseProduct>

    @FormUrlEncoded
    @POST("user_login")
    suspend fun getLoginUser(@Field("email") email :String,
                             @Field("pass") pass :String,
                             @Field("type") type :String,
                             ): LoginUser


}