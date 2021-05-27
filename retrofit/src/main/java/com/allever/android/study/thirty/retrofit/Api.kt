package com.allever.android.study.thirty.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {

@GET("wxarticle/chapters/json")
fun getPublicAccount(): Call<PublicAccount>

}