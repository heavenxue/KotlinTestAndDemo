package net.println.kotlin

/**
 * Created by Administrator on 2017/9/6.
 */
fun main(args: Array<String>){
    args.forEach(::println) // 包级函数

    args.filter (String::isEmpty) //直接用类名引用的函数

    val helloword = Hello::world

    val str = "dfdf"
    str.isEmpty()

    var pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)//kotlin1.1开始支持的
    getVaule()
}

fun add2(x: Int,y: Int): Int{
    return x + y
}

//body 是一个函数，这个operate就是高阶函数
fun operate(x: Int = 0,y: Int = 0,body: (Int,Int) -> Int){
    println("this result is " + body(x,y))
}

fun getVaule(){
    //函数参数传入一个函数
    operate (3,7, ::add2)
    operate (3,7,{x , y -> x + y}) //函数参数传入一个lambda表达式
    //函数参数做为函数的最后一个参数，并且传入的是一个lambda表达式，可以在圆括号外指定
    operate (3,7){
        x,y -> x+y
    }
}

class PdfPrinter{
    fun println(any: Any){
        println(any)
    }
}

class  Hello{
    fun world(){
        println("Hello World")
    }
}