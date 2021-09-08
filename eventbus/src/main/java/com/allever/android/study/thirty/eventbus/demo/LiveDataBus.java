package com.allever.android.study.thirty.eventbus.demo;

import androidx.lifecycle.Observer;

public class LiveDataBus {
    public static class Holder {
        private static final LiveDataBus INS = new LiveDataBus();
    }

    public static LiveDataBus getIns() {
        return Holder.INS;
    }

    public <T> void register(Object subscriber, Observer<T> observer) {

    }

    public void unRegister(Object subscriber) {

    }

    public void post(Object event) {

    }
}
