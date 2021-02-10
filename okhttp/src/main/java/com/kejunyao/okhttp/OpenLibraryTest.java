package com.kejunyao.okhttp;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * $类描述$
 *
 * @author kejunyao
 * @since 2021年01月27日
 */
public class OpenLibraryTest {
    private static void testOkHttp() throws IOException {

        // 创建OkHttpClient,构建者模式
        OkHttpClient httpClient = new OkHttpClient.Builder().build();

        // 创建Request,构建者模式
        Request request = new Request.Builder()
                .get()
                .url("https://www.baidu.com").build();

        // 创建一个Call
        Call realCall = httpClient.newCall(request);
        // 同步方法
        // Response response = realCall.execute();
        // String string = response.body().string();
        // Log.d(TAG, string);

        realCall.execute();

        // 异步请求接口
        realCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 请求失败
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 请求成功
                // 打印响应的内容
                String string = response.body().string();
                Log.d("MainActivity_onResponse", string);
            }
        });

    }
}
