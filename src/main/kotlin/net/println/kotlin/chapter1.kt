package net.println.kotlin

/**
 * Created by Administrator on 2017/6/13.
 */

var aInt: Int = 8
var anotherInt = 234
var aLong: Long = 12344334555
var anotherLong: Long = Long.MAX_VALUE
var theLong: Long = Math.pow(2.0,64.0).toLong() - 1
var aDouble: Double = 233.9
var anotherDouble: Double = 232324.34
var achar: Char = '\''
var aName: String = "小明\$\\\t你好"


fun main(args: Array<String>) {
    println("helloworld")

    println(aInt)
    println(anotherInt)
    println(aLong)
    println(anotherLong)
    println(theLong)
    println(aDouble)
    println(anotherDouble)
    println(achar)
    println(aName)
    println("Hello,$aName")

}