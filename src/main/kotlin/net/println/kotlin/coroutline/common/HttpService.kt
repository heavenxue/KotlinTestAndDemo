package net.println.kotlin.coroutline.common

import okhttp3.ResponseBody

/**
 * Created by Administrator on 2017/9/19.
 */
object HttpService {

    val service by lazy{
        val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("http://www.imooc.com")
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()

        retrofit.create(net.println.kotlin.coroutline.common.Service::class.java)
    }

}

interface Service{

    @retrofit2.http.GET
    fun getLogo(@retrofit2.http.Url fileUrl: String): retrofit2.Call<ResponseBody>

}