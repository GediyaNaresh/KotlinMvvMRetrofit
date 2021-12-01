package com.nareshgediya.kotlinmvvmretrofit.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nareshgediya.kotlinmvvmretrofit.Adapter.AllProdctAdapter
import com.nareshgediya.kotlinmvvmretrofit.Adapter.RecyclerAdapter
import com.nareshgediya.kotlinmvvmretrofit.Adapter.SubCategoryAdapter
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


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerAdapter
    private lateinit var allProdctAdapter: AllProdctAdapter
    private lateinit var subCategoryAdapter: SubCategoryAdapter
    lateinit var serchText : EditText
    lateinit var button: Button
    private lateinit var recycle : RecyclerView
    val sortBy = "old_to_new"
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     recycle = findViewById(R.id.recyclerView1)
//        serchText = findViewById(R.id.search_text)
        button = findViewById(R.id.search_button)
//

        allProdctAdapter = AllProdctAdapter()
        subCategoryAdapter = SubCategoryAdapter()

      recycle.layoutManager = LinearLayoutManager(this)


//        val decoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
//        recycle.addItemDecoration(decoration)
     //   recycle.adapter = allProdctAdapter
      recycle.adapter = subCategoryAdapter
    //    recycle.adapter = allProdctAdapter



        CoroutineScope(Dispatchers.IO).launch {
            val retroInstance =
                RetroInstance.getRetrofitInstnace().
                create(RetroService::class.java)
            val response = retroInstance.getCategorywiseProduct(10,1,sortBy)
            setList(response.data.subcategory)
        }



        button.setOnClickListener { v->
          subCategoryAdapter.notifyDataSetChanged()
            Log.d(TAG,subCategoryAdapter.itemCount.toString())
        }
        subCategoryAdapter.notifyDataSetChanged()


    }
    fun setList(list: List<Subcategory>){
        val subCategoryList: ArrayList<Subcategory> = ArrayList()
        for (sublist in list){
            subCategoryList.add(sublist)
        }
        subCategoryAdapter.setSubcategorydata(subCategoryList)
        Log.d(TAG,subCategoryList.toString())
    }

    private fun initViewModel() {
       val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.makeApiCallAllProduct(1)
        val list: ArrayList<Product> = ArrayList()
        viewModel.getAllProductObserver().observe(this, {
            if (it != null){
                for (p in it.data.products){
                    list.add(p)
                }
                allProdctAdapter.setAllProductData(list)
                allProdctAdapter.notifyDataSetChanged()

            }else{
                Log.d(TAG,"Error")
            }

        })

//        viewModel.getrecyclerListObserever().observe(this, Observer<RecyclerList>{
//            if (it != null){
//                adapter.setUpdatedData(it.items)
//            }else{
//                Toast.makeText(this, "Error in Getting Data", Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        button.setOnClickListener { v->
//            if (serchText.text.isNotEmpty()){
//                viewModel.makeApiCall(serchText.text.toString())
//            }else{
//                Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//
//        viewModel.getUsersrecyclerListObserever().observe(this, Observer<RecyclerUserList>{
//            if (it.items.size == 0){
//                Toast.makeText(this, "Sorry, No data Found", Toast.LENGTH_SHORT).show()
//            }
//            if (it != null){
//                adapter.setUserUpdatedData(it.items)
//            }
//            else{
//                Toast.makeText(this, "Error in Getting Data", Toast.LENGTH_SHORT).show()
//            }
//        })

        button.setOnClickListener { v->
//            CoroutineScope(Dispatchers.IO).launch {
//                val retroInstance = RetroInstance.getRetrofitInstnace().create(RetroService::class.java)
//                val response = retroInstance.getUserInfo(1)
//                val responseLogin = retroInstance.getLoginUser("valabhavik4696@gmail.com","123456","admin")
//
//              Log.d("TAG",response.data.full_name)
//                Log.d("TAG",response.data.email)
//                Log.d("TAG",response.toString())
//                Log.d("TAG",
//                    "msg:  ${responseLogin.msg} response: ${responseLogin}")
//            }

        }


    }



}