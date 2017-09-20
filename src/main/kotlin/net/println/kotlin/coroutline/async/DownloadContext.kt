package net.println.kotlin.coroutline.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by Administrator on 2017/9/20.
 */
class DownloadContext(val url: String): AbstractCoroutineContextElement(Key){
    companion object Key: CoroutineContext.Key<DownloadContext>
}