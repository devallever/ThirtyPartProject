package com.allever.android.study.thirty.glide.demo

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import java.io.File

/**
1.Glide图片加载的总体流程介绍
2.Glide缓存机制做了哪些优化？
3.Glide做了哪些内存优化？
4.Glide如何管理生命周期?
5.Glide怎么做大图加载?
 */
class GlideDemoActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //https://blog.csdn.net/guolin_blog/category_9268670.html
        val simpleTarget = object : SimpleTarget<Bitmap> () {
            override fun onResourceReady(
                resource: Bitmap?,
                glideAnimation: GlideAnimation<in Bitmap>?
            ) {

            }
        }
        Glide.with(this).load("").into(ImageView(this))
        Glide.with(this).load("").asBitmap().into(simpleTarget)
        Glide.with(this).load("").preload()
        val fileSimpleTarget = object : SimpleTarget<File>(){
            override fun onResourceReady(
                resource: File?,
                glideAnimation: GlideAnimation<in File>?
            ) {

            }
        }
        Glide.with(this).load("").downloadOnly(fileSimpleTarget)
        Glide.with(this).load("").downloadOnly(1, 1);
    }
}