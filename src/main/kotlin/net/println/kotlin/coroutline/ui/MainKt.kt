package net.println.kotlin.coroutline.ui

import net.println.kotlin.coroutline.async.*
import net.println.kotlin.coroutline.common.log
import javax.swing.JFrame.EXIT_ON_CLOSE

const val LOGO_URL = "http://www.imooc.com/static/img/index/logo.png?t=1.1"

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true

    frame.onButtonClick {
        log("协程之前")
        我要开始协程啦(DownloadContext(LOGO_URL)) {
            log("协程开始")
//            val imageData = 我要开始加载图片啦(LOGO_URL)
            try {
                val imageData= 我要开始耗时操作了 {
                    //LOGO_URL是从外部获取的，这里是个变量，没啥问题，万一又线程安全的问题就毁了
//                    我要开始加载图片(LOGO_URL)
                    我要开始加载图片(this[DownloadContext]!!.url)
                }
                log("拿到图片")//是在线程池中执行的
                //这个setLogo直接是在IO线程里面进行的操作，在非UI线程中操作了资源，在我要开始加载图片啦方法中改一下
                frame.setLogo(imageData)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        log("协程之后")
    }

//    frame.onButtonClick {
//        HttpService.service.getLogo(LOGO_URL)
//                .enqueue(object : Callback<ResponseBody> {
//                    override fun onResponse(
//                            call: Call<ResponseBody>,
//                            response: Response<ResponseBody>) {
//                        if (response.isSuccessful) {
//                            val imageData = response.body()?.byteStream()?.readBytes()
//                            if (imageData == null) {
//                                throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
//                            } else {
//                                SwingUtilities.invokeLater {
//                                    frame.setLogo(imageData)
//                                }
//                            }
//                        } else {
//                            throw HttpException(response.code())
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                        throw HttpException(HttpError.HTTP_ERROR_UNKNOWN)
//                    }
//
//                })
//    }
}
