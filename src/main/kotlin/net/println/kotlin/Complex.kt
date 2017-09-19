package net.println.kotlin

/**
 * Created by Administrator on 2017/6/14.
 */
class Complex(var real: Double,var imaginary: Double){
    operator fun plus(other: Complex):Complex{
        return Complex(real + other.real,imaginary + other.imaginary)
    }

    override fun toString(): String {
        return "$real + $imaginary"
    }
}

fun main(args: Array<String>) {
    var c1 = Complex(3.0 , 4.0)
    var c2 = Complex(2.0 , 7.5)
    println(c1 + c2)
}