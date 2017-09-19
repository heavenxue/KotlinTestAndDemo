package net.println.kotlin.StatisticStrDemo

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * 统计某个文件中的字符串的个数，这里的例子“hello.txt”
 * Created by Administrator on 2017/9/15.
 */
fun main(args: Array<String>){

//    println(countStrCount("我是中国人"))
    println(countFileStr("hello.txt"))

    //统计文件中的文本，某个字符出现的个数
//    val map = HashMap<Char, Int>()
//    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace)
//            .forEach{
//                val count = map[it]
//                if (count == null) map[it] = 1
//                else map[it] = count + 1
//            }
//    map.forEach(::println)
//
    val map = HashMap<Char, Int>()
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace)
            .groupBy { it }.map {
        it.key to it.value.size
    }.forEach(::println)
}

fun countStrCount(str: String):Int{
    return str.length
}

fun countFileStr(fileName: String): Int{
    var fileSb : StringBuilder = StringBuilder()
    var fileStr : String = ""
    //读文件
    BufferedReader(FileReader(fileName)).use{
        var line: String?
        while (true){
            line = it.readLine()?: break
            if (!line.isNullOrEmpty()){
                fileStr = fileSb.append(line).toString()
            }else
                fileStr = ""
        }
    }
    return fileStr.length
}