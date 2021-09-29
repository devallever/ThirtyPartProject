package com.allever.android.study.thirty.coil.demo

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import coil.load

class CoilDemoActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageView =  ImageView(this)
        imageView.load("")

    }
}