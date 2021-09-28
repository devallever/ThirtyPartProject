package com.allever.android.study.thirtypartproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AndroidSourceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_source)

        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            handleClick()
        }
    }

    private fun handleClick() {
        val intent = Intent(this, OtherActivity::class.java)
        startActivity(intent)
    }
}