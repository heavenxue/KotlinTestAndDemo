package net.println.kotlin.coroutline.async

import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext


/**
 * Created by Administrator on 2017/9/20.
 */
class UiContinuationWrapper<T>(val continuation: Continuation<T>): Continuation<T> {
//    override val context = EmptyCoroutineContext
    override val context = continuation.context

    override fun resume(value: T) {
        //在resume中把线程给切了
        SwingUtilities.invokeLater { continuation.resume(value) }
    }

    override fun resumeWithException(exception: Throwable) {
        //同理
        SwingUtilities.invokeLater { continuation.resumeWithException(exception) }
    }

}