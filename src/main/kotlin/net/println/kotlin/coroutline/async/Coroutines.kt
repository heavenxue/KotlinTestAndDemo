package net.println.kotlin.coroutline.async

import net.println.kotlin.coroutline.common.HttpError
import net.println.kotlin.coroutline.common.HttpException
import net.println.kotlin.coroutline.common.HttpService
import net.println.kotlin.coroutline.common.log
import net.println.kotlin.coroutline.ui.LOGO_URL
import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Created by Administrator on 2017/9/19.
 */
fun 我要开始协程啦(context: CoroutineContext = EmptyCoroutineContext, block: suspend() -> Unit){
//    block.startCoroutine(ContextContinuation(AsyncContext()))
    //为了传一个参数，就变成这样了，写到框架代码中也不太好，加个参数
//    block.startCoroutine(ContextContinuation(DownloadContext(LOGO_URL) + AsyncContext()))
    block.startCoroutine(ContextContinuation(context + AsyncContext()))// + 号其实调用了conbinedContext
}

//这里要开始封装了
suspend fun<T> 我要开始耗时操作了(block:CoroutineContext.() -> T)
    = suspendCoroutine<T> {
        continuation ->
        log("异步任务开始前")
        //val uiContinuation = UiContinuationWrapper(continuation)//直接在这写一段代码也不大好，怎么做呢，建立一个AsyncContext
        //在startCoroutine中传入了一个异步的context就OK了
        //在耗时操作这我们就要这么调用
        AsyncTask{
            log("耗时操作，下载图片")
            try {
                continuation.resume(block(continuation.context))
            }catch (e: Exception){
//            uiContinuation.resumeWithException(e)
                continuation.resumeWithException(e)
            }
        }.execute()
}

fun 我要开始加载图片(url: String): ByteArray {
    log("异步任务开始前")
    val responseBody = HttpService.service.getLogo(url).execute()
    if (responseBody.isSuccessful){
        responseBody.body()?.byteStream()?.readBytes()?.let{
           return it
        }
        throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
    }else{
        throw HttpException(responseBody.code())
    }
}

//suspendCoroutine是执行耗时操作的地方
suspend fun 我要开始加载图片啦(url: String) = suspendCoroutine<ByteArray> {
    continuation ->
    log("异步任务开始前")
    //val uiContinuation = UiContinuationWrapper(continuation)//直接在这写一段代码也不大好，怎么做呢，建立一个AsyncContext
    //在startCoroutine中传入了一个异步的context就OK了
    //在耗时操作这我们就要这么调用
    AsyncTask{
        log("耗时操作，下载图片")
        try {
            val responseBody = HttpService.service.getLogo(url).execute()
            if (responseBody.isSuccessful){
                responseBody.body()?.byteStream()?.readBytes()?.let{
                    //把线程切回来
                    //这么多地方用到了SwingUtilities，怎么优化一下呢，创建一个UiContinuation
//                    uiContinuation.resume(it)
                    continuation.resume(it)
                }
            }else{
//                uiContinuation.resumeWithException(HttpException(responseBody.code()))
                continuation.resumeWithException(HttpException(responseBody.code()))
            }
        }catch (e: Exception){
//            uiContinuation.resumeWithException(e)
            continuation.resumeWithException(e)
        }
    }.execute()
}