package com.nareshgediya.kotlinmvvmretrofit.Adapter

//class Generics(private  val array: Array<Int>){
//
//    fun findElement(element:Int, foundElement: (index :Int, element :Int?)-> Unit){
//        for (i in array.indices){
//            if (array[i] == element){
//                foundElement(i,array[i])
//                return
//            }
//        }
//        foundElement(-1,null)
//        return
//    }
//
//}
//fun main(){
//    val item = Generics(arrayOf(1,2,3,4,5,6,7,8,9,10))
//    item.findElement(8,{index, element ->
//        println("$index   ,$element")
//    })
//}

//here This is for Any type of class you can use T or any charchter u like
class Generics<T>(private  val array: Array<T>){

    fun findElement(element:T, foundElement: (index :Int, element :T?)-> Unit){
        for (i in array.indices){
            if (array[i] == element){
                foundElement(i,array[i])
                return
            }
        }
        foundElement(-1,null)
        return
    }

}
fun main(){
    val item = Generics(arrayOf(1,2,3,4,5,6,7,8,9,10))

    val itemString = Generics(arrayOf("A","B","C","D"))


//    item.findElement(8,{index, element ->
//        println("$index   $element")
//    })
//
//    itemString.findElement("C"){index, element ->
//        println("$index   $element")
//    }

//
for (i in 1..10 ){
    for (j in 1..i){
        print(" $j")
    }
    println()
}

//for (i in 9 downTo 1){
//    for (j in i downTo 1){
//        print("$j")
//    }
//    println()
//    for (k in i downTo 1){
//        print("_")
//    }
//    println()
//}


}