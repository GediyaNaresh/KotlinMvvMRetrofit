package com.nareshgediya.kotlinmvvmretrofit.Adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nareshgediya.kotlinmvvmretrofit.Activities.CategoryProducts
import com.nareshgediya.kotlinmvvmretrofit.Model.Subcategory
import com.nareshgediya.kotlinmvvmretrofit.R

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder>() {

    var allProduct = ArrayList<Subcategory>()


    fun setSubcategorydata(allProduct : ArrayList<Subcategory>){
        this.allProduct = allProduct
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title = view.findViewById<TextView>(R.id.textView_title)
        val desc = view.findViewById<TextView>(R.id.textView_id)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subcategory_list,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = allProduct.get(position).subcategory
        holder.desc.text = allProduct.get(position).subcategory_id

        holder.itemView.setOnClickListener { v->
            val intent = Intent(v.context, CategoryProducts::class.java)
            intent.putExtra("id",allProduct.get(position).subcategory_id)
            v.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
      return allProduct.size
    }
}