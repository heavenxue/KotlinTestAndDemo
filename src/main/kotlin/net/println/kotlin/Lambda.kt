package net.println.kotlin

/**
 * lambda表达式，其实就是匿名函数
 * Created by Administrator on 2017/6/16.
 */
fun main(args: Array<String>) {
    val sum = {arg1: Int,arg2: Int -> arg1 + arg2}//标准的lambda表达式
    val printHello = {
        println("Hello")
    }

    println(sum(1,3)) //这里的sum(1,3)等同于sum.invoke(1,3) -----lambda表达式的调用-----

    //对于一个函数来说，如果最后一个参数是Lambda表达式，我们就可以把它移到小括号外面去，当然，挪完后，小括号就可以省略了，如果
    //传入的函数和需要接收的类型是一致的，那么就可以携程最简化的方式
    args.forEach ({ println(it) })
    args.forEach() { println(it) }
    args.forEach { println(it)  }
    args.forEach(::println)

    //给lambda表达式起个名字，跳出的时候只跳出此lambda表达式
//    args.forEach ForEach@{
//        if (it == "q")
//            return ForEach@
//        println(it)
//    }
//    println("the end")
    transform()
    transform2()
    println(transform4())
    println(4.sum(3))

}

//body是一个函数参数，传入一个String参数，返回一个String参数
fun upCase(str: String,body: (String) -> String): String{
    return body(str)
}
//如果lambda表达式只有一个参数，kotlin可以自己计算出签名，它允许我们不声明唯一的参数，并且隐含的为我们声明其名称为it：
fun transform(){
    //函数字面值只有一个参数，可以省略参数声明，其名称是it
    upCase("HelloKotlin"){
        it.toUpperCase()
    }.forEach(:: println)
}

fun String.upper(body:(String) -> String): String{
    return body(this)
}
//如果lambda表达式是调用的唯一参数，则调用中的圆括号可以完全省略：
fun transform2(){
    //lambda是调用的唯一参数，则调用的圆括号可以省略
    println("HelloKotlin".upper { it.toUpperCase() })
}

fun transform3(){
    "HelloKotlin".upper { it.toUpperCase() }//lambda是调用的唯一参数，则调用的圆括号可以省略
    //将匿名函数作为一个函数参数传入
    "HelloKotlin".upper(fun(str: String): String{
        return str.toUpperCase()
    })
}
//lambda表达式与匿名函数的另一个区别是非局部返回的行为。一个不带标签的return语句总是在用fun关键字声明的函数中返回。
//这意味着lambda表达式中的return将从包含它的函数返回，而匿名函数中的return将从匿名函数自身返回
val ints = intArrayOf(1,2,0,4,5)
fun foo(){
    ints.forEach{
        if (it == 0) return //这个return表达式从最直接包围它的函数即foo中返回
        print(it)
    }
}

//值得注意的是：这种非局部的返回只支持传给内联函数的 lambda 表达式。
//如果我们需要从 lambda 表达式中返回，我们必须给它加标签并用以限制 return。
fun transform4(){
    "HelloKotln".upper {
        print(it.toUpperCase())
        return@upper it.toUpperCase() //返回必须加标签限制
    }
    "HelloKotlin".upper(fun (str: String): String{
        return str.toUpperCase()//从匿名函数返回
    })
}

/**
 * Kotlin提供了指定的接收者调用函数字面值的功能。在函数字面值的函数体中，可以调用该接收者对象上的方法而无需任何额外的限定符。
 * 这样的函数字面值的类型是一个带有接收者的函数类型：
 * sum : Int.(other: Int) -> Int
 * 该函数字面值可以这样调用，就像它是接收者对象上的一个方法一样：
 * 1.sum(2)
 * 匿名函数语法允许你直接指定函数字面值的接收者类型。 如果你需要使用带接收者的函数类型声明一个变量，并在之后使用它，这将非常有用。
 *
 * **/
val sum = fun Int.(other: Int): Int = this + other
