package net.println.kotlin.coroutline.async

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * Created by Administrator on 2017/9/19.
 */
class ContextContinuation(override val context: CoroutineContext = EmptyCoroutineContext) : Continuation<Unit> {

    override fun resume(value: Unit) {
    }

    override fun resumeWithException(exception: Throwable) {
    }

}