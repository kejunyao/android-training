package com.kejunyao.net.request

import com.google.gson.annotations.SerializedName

/**
 * 网络API协议基类
 *
 * @author kejunyao
 * @since 2021年02月25日
 */
class BaseResponse<T> {

    companion object {
        const val CODE    = "code"
        const val MSG     = "msg"
        const val DATA    = "data"
        const val SUCCESS = 200
    }

    /** 接口状态码 */
    @SerializedName(CODE)
    var code = 0
    /** 接口状态码对应的message */
    @SerializedName(MSG)
    var message = ""
    @SerializedName(DATA)
    /** 接口返回的数据 */
    var data: T? = null

    /**
     * 接口是否请求成功
     * @return true，请求成功；false，请求失败
     */
    fun isSuccessful(): Boolean {
        return code == SUCCESS
    }
}