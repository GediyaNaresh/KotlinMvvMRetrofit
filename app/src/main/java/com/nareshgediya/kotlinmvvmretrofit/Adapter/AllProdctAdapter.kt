package com.nareshgediya.kotlinmvvmretrofit.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nareshgediya.kotlinmvvmretrofit.Network.RecylerData
import com.nareshgediya.kotlinmvvmretrofit.Network.RecylerUserData
import com.nareshgediya.kotlinmvvmretrofit.R
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var items = ArrayList<RecylerData>()
    var itemsUserList = ArrayList<RecylerUserData>()

    fun setUpdatedData(items : ArrayList<RecylerData>){
        this.items = items
        notifyDataSetChanged()
    }

    fun setUserUpdatedData(items : ArrayList<RecylerUserData>){
        this.itemsUserList= items
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val title = view.findViewById<TextView>(R.id.textView_title)
        val desc = view.findViewById<TextView>(R.id.textView_desc)

//        fun bind(data: RecylerData){
//            title.text = data.name
//            desc.text = data.description
//
//            val url = data.owner.avatar_url
//            Picasso.get()
//                .load(url)
//                .into(image)
//        }

        fun bindUsers(data: RecylerUserData){
            title.text = data.login
            desc.text = data.id.toString()

            itemView.setOnClickListener { v->
                Toast.makeText(v.context, "Name: "+data.login, Toast.LENGTH_SHORT).show()
            }
            Picasso.get()
                .load(data.avatar_url)
                .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//holder.bind(items.get(position))
holder.bindUsers(itemsUserList.get(position))

    }

    override fun getItemCount(): Int {
      return itemsUserList.size
    }
}