package net.println.kotlin


/**
 * Created by Administrator on 2017/6/16.
 */
open class People{
    var gendar: Boolean = false //true 为女人，默认是男人
    get(){
        println("some one tries to get gendar")
        return field
    }
    set(value) {
        println("some one tries to set gendar")
        field = value
    }
}

class X

class B{
    lateinit var c: String //延迟初始化
    val e: X by lazy {
        println("lazy is by called")
        X()
    }
}

fun main(args: Array<String>) {
    var girl = People()
    girl.gendar = true
    println(girl.gendar)
}