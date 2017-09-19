package net.println.kotlin

/**
 * Created by Administrator on 2017/6/14.
 */
val FINAL_HELLO_WORLD: String = "Hello World"
var helloWorld: String = FINAL_HELLO_WORLD
var nullableHelloWorld: String? = FINAL_HELLO_WORLD
var helloWorldCharArray: CharArray = charArrayOf('H','e','l','l','o','W','o','r','l','d')
var helloWorldArray: Array<Char> = arrayOf('H','e','l','l','o','W','o','r','l','d')
var helloWorldLength: Int = helloWorld.length
var helloWorldLengthLong: Long = helloWorld.length.toLong()


fun main(args: Array<String>) {
    println("final hello world:  " + FINAL_HELLO_WORLD)
    println("assignable hello world:  " + helloWorld)
    println("hello world from nullable type:  " + nullableHelloWorld)
    println("hello world from charArray:  " + String(helloWorldCharArray))
    println("hello world from Array:  " + helloWorldArray.joinToString(""))
    println("class name hello world:  " + HelloWorld::class.java.simpleName)
    println("class name hello world:  " + HelloWorld::class.java.name)
    println("part of class name hello world:  " + HelloWorld::class.java.simpleName.slice(0 until helloWorldLength - 1))
    println("the length of hello world is:  " + helloWorldLength)
    println("the length of hello world is (long):  " + helloWorldLengthLong)

}