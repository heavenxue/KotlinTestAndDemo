package net.println.kotlin.coroutline.basic

import net.println.kotlin.coroutline.common.HttpException
import net.println.kotlin.coroutline.common.HttpService
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Created by Administrator on 2017/9/19.
 */
fun 我要开始协程啦(block: suspend() -> Unit){
    block.startCoroutine(BaseContinuation())
}

//suspendCoroutine是执行耗时操作的地方
suspend fun 我要开始加载图片啦(url: String) = suspendCoroutine<ByteArray> {
    continuation ->
    try {
        val responseBody = HttpService.service.getLogo(url).execute()
        if (responseBody.isSuccessful){
            responseBody.body()?.byteStream()?.readBytes()?.let(continuation::resume)
        }else{
            continuation.resumeWithException(HttpException(responseBody.code()))
        }
    }catch (e: Exception){
        continuation.resumeWithException(e)
    }
}