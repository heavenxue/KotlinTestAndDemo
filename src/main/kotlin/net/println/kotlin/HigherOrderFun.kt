package net.println.kotlin

import java.io.BufferedReader
import java.io.FileReader

/**
 * 常见的高阶函数
 * Created by Administrator on 2017/9/13.
 */
fun main(args: Array<String>){
    //集合映射map
    val list = listOf(1,2,3,4,5)
    val newList = list.map{
        it * 2 + 3
    }
    //输出newlist中的所有元素
    newList.forEach(::println)

    //0..6的阶乘
    (0..6).map(::factorial).forEach(::println)

    val list2 = listOf(1..20,2..5,100..322)
    //flatMap 集合的集合
    val flatList = list2.flatMap {intRag ->
        intRag.map{intElmt ->
            "No.$intElmt"
        }
    }
    //简化flatMap的写法
    val flatList2 = list2.flatMap {
        it.map{
            it
        }
    }
//    flatList2.forEach(::println)
    //求整数的和 accumulator积累的意思 47277
    println(flatList2.reduce{it,i ->  it + i})
    //0..6阶乘，数学里面定义的0！=1（0的阶乘=1）
    println((0..6).map(::factorial))
    //foldRight倒着来，把阶乘的结果中每个数用字符串连接串给‘倒着’连接起来
    println((0..6).map(::factorial).foldRight(StringBuilder()){i,acc ->
        acc.append(i).append(",")
    })
    //这就是正着给链接起来了
    println((0..6).map(::factorial).fold(StringBuilder()){acc,i ->
        acc.append(i).append(",")
    })
    /**上面字符串链接，也可以简单的实现如下**/
    println((0..6).joinToString(","))
    //把奇数留下来(过滤)
    println((0..6).filter { it % 2 == 1 })
    //拿到偶数位置的结果
    println((0..6).filterIndexed{index, i ->  index % 2 == 0})
    //遇到第一个奇数就停止（从第一个开始取，符合条件的，只要遇到不符合条件的就取数据就终止了）
    println((0..6).takeWhile { it % 2 == 0 })

    /**下面看run let with use的用法**/
    //调用run函数块。返回值为函数块最后一行，或者指定return表达式。
    val a = run {
        println("runing a")
        return@run 2
    }
    //调用某对象的run函数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。
    val b = "HelloKotlin".run {
        println(this)
        3
    }
    println(a)
    println(b)
    //调用某对象的let函数，则该对象为函数的参数。在函数块内可以通过 it 指代该对象。返回值为函数块的最后一行或指定return表达式。
    val c = "HelloKotlin".let {
        println(it)
        4
    }
    println(c)
    val person = findRen()
    //直接把人的成员变量打印出来
    println(person?.name)
    println(person?.age)
    //下面同等输出
    findRen()?.let { person ->
        person.work()
        println(person.age)
        println(person.name)
    }
    //下面等同输出
    findRen()?.let {
        it.work()
        println(it.name)
        println(it.age)
    }
    //等价于下面用apply表示(调用某对象的apply函数，在函数块内可以通过 this 指代该对象。返回值为该对象自己。)
    findRen()?.apply {
        work()
        println(age)
        println(name)
    }
    //with,它是将对象作为函数的参数，在函数块内可以用过this指代该对象。返回值为函数块的最后一行或指定return表达式
    val d = with("with param"){
        println(this)
        5
    }
    println(d)
    //取文件中的数据，也可用with，实例如下
    val br = BufferedReader(FileReader("hello.txt"))
    with(br){
        var line: String?
        while(true){
            line = readLine()?: break
            println(line)
        }
        close()
    }
    //其实读文件很简单
    BufferedReader(FileReader("hello.txt")).readText()
    //每次都调用close那么麻烦，啥的怎么弄呢，简单一点，如下  use传的就是closeable的
    BufferedReader(FileReader("hello.txt")).use{
        var line: String?
        while(true){
            line = it.readLine()?: break
            println(line)
        }
    }


}

fun factorial(n: Int): Int{
    if(n == 0) return 1
    //用reduce来求阶乘(reduce 是化简)，对map集合中的每个元素进行一个lanmda表达式的操作
    return(1..n).reduce{acc,i -> acc * i}
}

data class Ren(val name: String,val age: Int){
    fun work(){
        println("$name is working!!")
    }
}

//找到一个空对象人
fun findRen(): Ren?{
    return null
}
