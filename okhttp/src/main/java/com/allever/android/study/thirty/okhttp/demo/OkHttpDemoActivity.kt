package com.allever.android.study.thirty.okhttp.demo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.allever.android.study.thirty.okhttp.R
import okhttp3.*
import java.io.IOException

/**
 * https://juejin.cn/post/6909445385266135048 - 从一次请求开始，深入探索OkHttp
 */
class OkHttpDemoActivity: Activity(){
    private val TAG = OkHttpDemoActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp_demo)

        val url = "https://www.wanandroid.com/wxarticle/chapters/json"

        val httpClient = OkHttpClient().newBuilder().addInterceptor(MyInterceptor()).build()
        val request = Request.Builder()
            .url(url)
            .build()
        httpClient.newCall(request).execute()
        httpClient.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "请求失败: " + e.printStackTrace())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d(TAG, "请求成功: " + response.body()?.string())
            }

        })
    }
}