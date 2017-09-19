package net.println.kotlin

/**
 * Created by Administrator on 2017/9/1.
 */

class Girl: People() {
    init {
        println("new 了一个${this.javaClass.simpleName}")
    }
}

fun main(args: Array<String>){
    val 妹子: Girl = Girl()
    println(妹子)

    val latitude = Latitude.ofDouble(20.3)
}

fun sum(arg1: Int,arg2: Int) = arg1 + arg2
//如果有一个变量接受一个函数，那么这个函数可以不写名字
var toLong = fun(x : Int):Long{
    return x.toLong()
}

class Latitude private constructor(val value: Double){
    companion object{
        fun  ofDouble(double: Double) : Latitude{
            return Latitude(double)
        }
    }
}
