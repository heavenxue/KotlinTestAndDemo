package net.println.kotlin

/**
 * 常见的高阶函数
 * Created by Administrator on 2017/9/13.
 */
fun main(args: Array<String>){
    println((0..6).joinToString(","))

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
    //foldRight倒着来
    println((0..6).map(::factorial).foldRight(StringBuilder()){i,acc ->
        acc.append(i).append(",")
    })

//    flatList.forEach(::println)

}

fun factorial(n: Int): Int{
    if(n == 0) return 1
    //用reduce来求阶乘(reduce 是化简)，对map集合中的每个元素进行一个lanmda表达式的操作
    return(1..n).reduce{acc,i -> acc * i}
}
