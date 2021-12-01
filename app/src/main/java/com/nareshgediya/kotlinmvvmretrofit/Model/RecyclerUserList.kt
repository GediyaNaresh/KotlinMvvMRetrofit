package com.nareshgediya.kotlinmvvmretrofit.Network

import kotlin.collections.ArrayList

data class RecyclerUserList(val items: ArrayList<RecylerUserData>)

data class RecylerUserData(val id:Int,val login: String,val avatar_url: String)



