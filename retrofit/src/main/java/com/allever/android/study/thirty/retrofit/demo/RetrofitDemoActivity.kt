package com.allever.android.study.thirty.retrofit.demo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.allever.android.study.thirty.retrofit.Api
import com.allever.android.study.thirty.retrofit.PublicAccount
import com.allever.android.study.thirty.retrofit.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitDemoActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retorfit_demo)

        val baseUrl = "https://www.wanandroid.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(Api::class.java)
        apiService.getPublicAccount().enqueue(object : Callback<PublicAccount> {
            override fun onResponse(call: Call<PublicAccount>, response: Response<PublicAccount>) {
                log("请求成功：" + response.body())
            }

            override fun onFailure(call: Call<PublicAccount>, t: Throwable) {
                log("请求失败：" + t.message)
            }
        })
    }

    private fun log(msg: String) {
        Log.d(TAG, msg)
    }

    companion object {
        val TAG: String = RetrofitDemoActivity::class.java.simpleName
    }
}