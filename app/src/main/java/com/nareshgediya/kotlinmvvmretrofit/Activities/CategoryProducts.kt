package com.nareshgediya.kotlinmvvmretrofit.Activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nareshgediya.kotlinmvvmretrofit.Adapter.AllProdctAdapter
import com.nareshgediya.kotlinmvvmretrofit.Adapter.RecyclerAdapter
import com.nareshgediya.kotlinmvvmretrofit.Adapter.SubCategoryAdapter
import com.nareshgediya.kotlinmvvmretrofit.Adapter.SubProdctAdapter
import com.nareshgediya.kotlinmvvmretrofit.Model.Product
import com.nareshgediya.kotlinmvvmretrofit.Model.Subcategory
import com.nareshgediya.kotlinmvvmretrofit.Model.SubcategoryWiseProduct
import com.nareshgediya.kotlinmvvmretrofit.Network.RetroInstance
import com.nareshgediya.kotlinmvvmretrofit.Network.RetroService
import com.nareshgediya.kotlinmvvmretrofit.R
import com.nareshgediya.kotlinmvvmretrofit.ViewModel.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryProducts: AppCompatActivity() {


    private lateinit var adapter: SubProdctAdapter
    lateinit var serchText : EditText
    lateinit var tv1 : TextView
    lateinit var button: Button
    private lateinit var recycle : RecyclerView
    val sortBy = "old_to_new"
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_product)
        val id = intent.getStringExtra("id")!!

        recycle = findViewById(R.id.recyclerView1)
        tv1 = findViewById(R.id.tv)
        button = findViewById(R.id.search_button)
//
     adapter = SubProdctAdapter()
        recycle.adapter = adapter
        recycle.layoutManager = LinearLayoutManager(this)



        CoroutineScope(Dispatchers.IO).launch {
            val retroInstance =
                RetroInstance.getRetrofitInstnace().
                create(RetroService::class.java)
            val response = retroInstance.getSubCategorywiseProduct(id)
          //  setList(response.data.products)
        }
        val retroInstance =
            RetroInstance.getRetrofitInstnace().
            create(RetroService::class.java)
        retroInstance.getSubCategoryProduct(id).enqueue(object : Callback<SubcategoryWiseProduct> {
            override fun onResponse(
                call: Call<SubcategoryWiseProduct>,
                response: Response<SubcategoryWiseProduct>
            ) {
                if (response.isSuccessful){
                    val subCategoryList: ArrayList<Product> = ArrayList()
                    if (response.body()!!.data.products.size == 0){
                        tv1.visibility=View.VISIBLE
                    }else {
                        tv1.visibility = View.INVISIBLE
                        for (sublist in response.body()!!.data.products) {
                            subCategoryList.add(sublist)
                        }
                        adapter.setAllProductData(subCategoryList)
                        Log.d(TAG, subCategoryList.toString())
                        adapter.notifyDataSetChanged()
                    }
                }else{
                    Log.d(TAG,response.message())
                }
            }

            override fun onFailure(call: Call<SubcategoryWiseProduct>, t: Throwable) {
                Log.d(TAG,t.localizedMessage)
            }


        })
        button.setOnClickListener { v->
            adapter.notifyDataSetChanged()
            Log.d(TAG,adapter.itemCount.toString())
        }
        adapter.notifyDataSetChanged()
    }
    fun setList(list: List<Product>){
        val subCategoryList: ArrayList<Product> = ArrayList()
        for (productlist in list){
            subCategoryList.add(productlist)
        }

    }




}