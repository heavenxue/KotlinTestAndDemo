package net.println.kotlin

/**
 * 扩展方法，属性
 * Created by Administrator on 2017/6/27.
 */
fun String.multity(int: Int): String{
    val stringBuilder = StringBuilder()
    for (i in 0 until int)
        stringBuilder.append(this)
    return stringBuilder.toString()
}

//此类方法等同于上面的multity方法
operator fun String.times(int: Int): String{
    val stringBuilder = StringBuilder()
    for (i in 0 until int)
        stringBuilder.append(this)
    return stringBuilder.toString()
}

val String.a: String
    get() = "abc"

var String.b: Int
    set(value) {

    }
    get() = 5


fun main(args: Array<String>) {
    println("abc" * 16)//相当于调用了operator times方法

    val str = "abc"
    println(str.multity(16))

    println(str.a)
    str.b = 10
    println(str.b)
}