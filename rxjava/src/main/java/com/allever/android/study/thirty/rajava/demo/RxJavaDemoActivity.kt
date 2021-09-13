package com.allever.android.study.thirty.rajava.demo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.allever.android.study.thirty.rajava.R
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.NewThreadScheduler

class RxJavaDemoActivity: Activity() {

    private val TAG = "RxJavaDemo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java_demo)


        val observable = Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>) {
                emitter.onNext("A")
            }
        })

        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe: ")
            }

            override fun onNext(t: String) {
                Log.d(TAG, "onNext: $t")
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete: ")
            }
        }

        observable.subscribeOn(NewThreadScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

    }
}