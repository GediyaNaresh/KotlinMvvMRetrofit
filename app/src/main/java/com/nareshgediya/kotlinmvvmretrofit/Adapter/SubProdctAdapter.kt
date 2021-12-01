package com.nareshgediya.kotlinmvvmretrofit.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nareshgediya.kotlinmvvmretrofit.Model.AllProduct
import com.nareshgediya.kotlinmvvmretrofit.Model.Product
import com.nareshgediya.kotlinmvvmretrofit.Network.RecylerData
import com.nareshgediya.kotlinmvvmretrofit.Network.RecylerUserData
import com.nareshgediya.kotlinmvvmretrofit.R
import com.squareup.picasso.Picasso

class SubProdctAdapter : RecyclerView.Adapter<SubProdctAdapter.MyViewHolder>() {

    var allProduct = ArrayList<Product>()


    fun setAllProductData(allProduct : ArrayList<Product>){
        this.allProduct = allProduct

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val image2 = view.findViewById<ImageView>(R.id.imageView2)
        val image3 = view.findViewById<ImageView>(R.id.imageView3)
        val title = view.findViewById<TextView>(R.id.textView_title)
        val desc = view.findViewById<TextView>(R.id.textView_desc)



        fun bindUsers(data: Product){

            title.text = data.product_name
            desc.text = "Price ${data.new_price}"

            itemView.setOnClickListener { v->

            }
         //Image base url for retric=ve image   https://shopno.in/gujjustore.in/uploads/product/

            if (data.images.size <= 1){
                Picasso.get()
                    .load("https://shopno.in/gujjustore.in/uploads/product/${data.images.get(0)}")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image)
                image2.visibility = View.INVISIBLE
                image3.visibility = View.INVISIBLE
            }else if (data.images.size <= 2){
                image2.visibility = View.VISIBLE
                Picasso.get()
                    .load("https://shopno.in/gujjustore.in/uploads/product/${data.images.get(0)}")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image)
                Picasso.get()
                    .load("https://shopno.in/gujjustore.in/uploads/product/${data.images.get(1)}")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image2)
                image3.visibility = View.INVISIBLE
            }else if (data.images.size <= 4){
                image3.visibility = View.VISIBLE
                Picasso.get()
                    .load("https://shopno.in/gujjustore.in/uploads/product/${data.images.get(0)}")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image)
                Picasso.get()
                    .load("https://shopno.in/gujjustore.in/uploads/product/${data.images.get(1)}")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image2)
                Picasso.get()
                    .load("https://shopno.in/gujjustore.in/uploads/product/${data.images.get(2)}")
                    .placeholder(R.mipmap.ic_launcher)
                    .into(image3)
            }



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.allproduct_list,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//holder.bind(items.get(position))

holder.bindUsers(allProduct.get(position))

    }

    override fun getItemCount(): Int {
      return allProduct.size
    }
}