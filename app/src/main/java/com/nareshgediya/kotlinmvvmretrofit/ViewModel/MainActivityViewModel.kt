package com.nareshgediya.kotlinmvvmretrofit.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nareshgediya.kotlinmvvmretrofit.Model.AllProduct
import com.nareshgediya.kotlinmvvmretrofit.Model.Product
import com.nareshgediya.kotlinmvvmretrofit.Model.UserDataInfo

import com.nareshgediya.kotlinmvvmretrofit.Network.RecyclerList
import com.nareshgediya.kotlinmvvmretrofit.Network.RecyclerUserList
import com.nareshgediya.kotlinmvvmretrofit.Network.RetroInstance
import com.nareshgediya.kotlinmvvmretrofit.Network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivityViewModel : ViewModel() {

    lateinit var recyclerListlivedata :MutableLiveData<RecyclerList>
    lateinit var recyclerUserList: MutableLiveData<RecyclerUserList>
    lateinit var userInfoListInfo: MutableLiveData<UserDataInfo>
    lateinit var allProduct: MutableLiveData<AllProduct>


    init {
        recyclerListlivedata = MutableLiveData()
        recyclerUserList = MutableLiveData()
        userInfoListInfo = MutableLiveData()
        allProduct= MutableLiveData()
    }

     fun getrecyclerListObserever():MutableLiveData<RecyclerList>{

         return recyclerListlivedata
     }
     fun getAllProductObserver():MutableLiveData<AllProduct>{
         return allProduct
     }

    fun getUsersrecyclerListObserever():MutableLiveData<RecyclerUserList>{

         return recyclerUserList
     }

    fun getUserInfoListObserever():MutableLiveData<UserDataInfo>{

         return userInfoListInfo
     }


        fun makeApiCall(searchText :String){
            viewModelScope.launch (Dispatchers.IO){
                val retroInstance = RetroInstance.getRetrofitInstnace().create(RetroService::class.java)
                val response = retroInstance.getDataFromApi(searchText)
                recyclerListlivedata.postValue(response)
            }
        }

        fun makeApiCallAllProduct(userId :Int){
            viewModelScope.launch (Dispatchers.IO){
                val retroInstance = RetroInstance.getRetrofitInstnace().create(RetroService::class.java)
                val response = retroInstance.getAllPoduct(userId,"old_to_new")
                allProduct.postValue(response)
            }
        }

//        fun makeApiCallUserInfo(user_id :Int){
//            viewModelScope.launch (Dispatchers.IO){
//                val retroInstance = RetroInstance.getRetrofitInstnace().create(RetroService::class.java)
//                val response = retroInstance.getUserInfo(user_id)
//                userInfoList.postValue(response)
//            }
//        }


        fun makeApiCallUsers(searchText :String){
            viewModelScope.launch (Dispatchers.IO){
                val retroInstance = RetroInstance.getRetrofitInstnace().create(RetroService::class.java)
                val response = retroInstance.getUsersFromApi(searchText)
                recyclerUserList.postValue(response)
            }
        }


}