package net.println.kotlin


/**
 * Created by Administrator on 2017/9/1.
 */

enum class State{
    IDLE,BUFFERING,PLAYING,PAUSED
}

//vararg 可变参数(变长参数)
fun hello(double: Double,vararg ints: Int, string: String = "Hello"){
   println(double)
    ints.forEach(:: println)
    println(string)
}

fun main(args: Array<String>){
    var state: State = State.PAUSED
    when(state){
        State.IDLE -> println("hello,$state")
    }
    val array = intArrayOf(1,3,4,6)
    hello(3.0,*array)
}