package net.println.kotlin.coroutline.basic

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * Created by Administrator on 2017/9/19.
 */
class BaseContinuation() : Continuation<Unit> {
    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resume(value: Unit) {
    }

    override fun resumeWithException(exception: Throwable) {
    }

}