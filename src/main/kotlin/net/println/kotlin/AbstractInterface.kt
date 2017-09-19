package net.println.kotlin

/**
 * Created by Administrator on 2017/9/4.
 */
//抽象类
abstract class Person(open val age :  Int){
    abstract fun work()
}

class MaNong(age: Int) : Person(age){
    override val age: Int
        get() = 0
    override fun work() {
        println("我是码农，我在写代码")
    }
}

class Doctor(age: Int): Person(age){
    override fun work() {
        println("我是医生，我在给病人看病")
    }
}

fun main(args: Array<String>){
    val person: Person = MaNong(23)
    person.work()
    println(person.age)

    val person2 : Person = Doctor(40)
    person2.work()
    println(person2.age)

    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.dirve()
    seniorManager.write()


    println(D(3).x())
    println(D(-10).x())
    println(D(-110).x())
    println(D(-10000).x())
}

//下面是接口
interface  Driver{
    fun dirve()
}
interface Writter{
    fun write()
}
class CarDriver: Driver{
    override fun dirve() {
        println("开车呢")
    }
}
class PPTWriter: Writter{
    override fun write() {
        println("做ppt呢")
    }
}

class Manager: Driver,Writter{
    override fun write() {
    }

    override fun dirve() {
    }
}

class SeniorManager(val driver: Driver,val writter: Writter): Driver by driver,Writter by writter


//针对冲突
abstract class A{
    open fun x(): Int = 5
}

interface BB{
    fun x(): Int = 1 //默认返回1
}

interface C{
    fun x(): Int = 0
}

class D(var y: Int = 0): A(), BB, C{

    override fun x(): Int {
        println("call x(): Int in D")
        if(y > 0){
            return y
        }else if(y < -200){
            return super<C>.x()//根据泛型，来表明是输出谁
        }else if(y < -100){
            return super<BB>.x()
        }else{
            return super<A>.x()
        }
    }
}

