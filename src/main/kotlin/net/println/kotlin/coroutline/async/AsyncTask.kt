package net.println.kotlin.coroutline.async

import java.util.concurrent.Executors

/**
 * Created by Administrator on 2017/9/20.
 */
//来一个线程池，私有的别人不能用到
private val pool by lazy{
    Executors.newCachedThreadPool()
}
class AsyncTask(val block:() -> Unit){
    fun execute() = pool.execute(block)
}