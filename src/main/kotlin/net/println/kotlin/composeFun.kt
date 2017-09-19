package net.println.kotlin

/**
 * Created by Administrator on 2017/9/13.
 */
val add5 = {i: Int -> i + 5}
val multiplyBy2 = {i: Int -> i * 2}
val sub = {i : Int -> i -3}

fun isOdd(x: Int) = x % 2 != 0
fun length(s: String) = s.length

/**
 * g: A->B
 * f: B->C
 * h: A->C
 * g(A)=B
 * h(A) = f(B) = f(g(A)) = C
 *
 * 代码中写法:
 * h=compose( f, g )
 * h=compose( f(g(A)), g(A) )
 *
 * **/
fun <A, B, C> compose2(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun main (args: Array<String>){
    //调用一下
    println(multiplyBy2(add5(8))) //就相当于是 （8 + 5） * 2
    //multiplyBy2(add5(8))一层套了一层，还挺麻烦，那么我们能不能复合一下呢
    val add5AndMultiplyBy2 = add5 andThen multiplyBy2
    println(add5AndMultiplyBy2(8))  // m(x) = f(g(x))
    val add5ComposeMultiplyBy2 = add5 compose  multiplyBy2
    println(add5ComposeMultiplyBy2(8)) // m(x) = g(f(x))

    val add5AndSub3 = add5 addSub sub
    println(add5AndSub3(8))

    val oddLength = compose2(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))
}
/**
 * h(P1) = P2
 * f(P2) = R
 * g(P1) = R
 *
 * g(P1) = f(P2) = f(h(P1)) = R
 * */
infix fun<P1,P2,R> Function1<P1,P2>.addSub(function: Function1<P2,R>): Function1<P1,R>{
    return fun (p1: P1): R{
        return function.invoke(this.invoke(p1))
    }
}

//andThen是个扩展方法  Function1是传入的参数 infix是复合的意思
infix fun <P1,P2,S> Function1<P1,P2>.andThen(function: Function1<P2,S>):Function1<P1,S>{
    return fun(p1: P1):S{
        return function.invoke(this.invoke(p1))
    }
}

infix fun <P1,P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R>{
    return fun(p1: P1): R{
        return this.invoke(function.invoke(p1))
    }
}
