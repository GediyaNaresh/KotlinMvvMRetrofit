package com.nareshgediya.kotlinmvvmretrofit.Network

import kotlin.collections.ArrayList

data class RecyclerList(val items: ArrayList<RecylerData>)

data class RecylerData(val name: String,val description: String,val owner:Owner)

data class Owner (val avatar_url:String)


