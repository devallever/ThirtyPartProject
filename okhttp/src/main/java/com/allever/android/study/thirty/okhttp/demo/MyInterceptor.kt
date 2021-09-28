package com.allever.android.study.thirty.okhttp.demo

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("TAG", "intercept: MyInterceptor")
        return chain.proceed(chain.request())
    }
}