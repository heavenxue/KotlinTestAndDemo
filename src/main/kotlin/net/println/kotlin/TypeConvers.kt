package net.println.kotlin

/**
 * Created by Administrator on 2017/9/1.
 */
fun getName(): String?{
    return null
}

fun main(args: Array<String>){
    var name: String = getName() ?: return
    println(name.length)
    var value: String ? = "HelloWorld"
    println(value !!.length)  //双感叹号，表明我确认他肯定不为null
}