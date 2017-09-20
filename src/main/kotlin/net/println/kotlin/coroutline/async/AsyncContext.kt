package net.println.kotlin.coroutline.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor

/**
 * Created by Administrator on 2017/9/20.
 */
//所有的都用ContinuationInterceptor这个一个key
class AsyncContext: AbstractCoroutineContextElement(ContinuationInterceptor),ContinuationInterceptor{

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return UiContinuationWrapper(continuation.context.fold(continuation){
            continuation, element ->
            //如果是自己，并且是这个key才让串改
            if (element != this && element is ContinuationInterceptor){
                element.interceptContinuation(continuation)
            }else continuation
        })
    }

}