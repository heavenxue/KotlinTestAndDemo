package net.println.kotlin.coroutline.common

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Administrator on 2017/9/19.
 */
val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(msg: String) = println("${now()} [${Thread.currentThread().name}] $msg")