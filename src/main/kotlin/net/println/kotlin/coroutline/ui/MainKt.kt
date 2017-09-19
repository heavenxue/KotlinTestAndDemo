package net.println.kotlin.coroutline.ui

import net.println.kotlin.coroutline.basic.我要开始加载图片啦
import net.println.kotlin.coroutline.basic.我要开始协程啦
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
        我要开始协程啦 {
            log("协程开始")
            val imageData = 我要开始加载图片啦(LOGO_URL)
            frame.setLogo(imageData)
            log("协程之后")
        }
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
