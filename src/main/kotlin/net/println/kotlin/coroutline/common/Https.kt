package net.println.kotlin.coroutline.common

/**
 * Created by Administrator on 2017/9/19.
 */
object HttpError{
    const val HTTP_ERROR_NO_DATA = 999
    const val HTTP_ERROR_UNKNOWN = 998
}

data class HttpException(val code: Int): Exception()