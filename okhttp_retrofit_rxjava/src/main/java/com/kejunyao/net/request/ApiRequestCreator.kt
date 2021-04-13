package com.kejunyao.net.request

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 网络API接口创建器
 *
 * @author kejunyao
 * @since 2021年02月25日
 */
object ApiRequestCreator {
    /** 连接超时时间（单位：毫秒） */
    private const val CONNECT_TIMEOUT_MILLIS = 15 * 1000L // 15s
    /** 资源读取超时时间（单位：毫秒） */
    private const val READ_TIMEOUT_MILLIS = 20 * 1000L    // 20s
    // private var client: OkHttpClient
    private var retrofitBuilder: Retrofit.Builder

    init {
        val client = OkHttpClient().newBuilder()
            .connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .build()

        retrofitBuilder = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
    }


    fun <T> create(clazz: Class<T>, baseUrl: String): T {
        return retrofitBuilder.baseUrl(baseUrl)
            .build()
            .create(clazz)
    }
}