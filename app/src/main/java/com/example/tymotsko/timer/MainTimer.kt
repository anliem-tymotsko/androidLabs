package com.example.tymotsko.timer


import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

open class MainTimer(lifecycle: Lifecycle) : LifecycleObserver {

    var secondsCount = 0

    var handler = Handler()
    lateinit var runnable: Runnable

    init {
        lifecycle.addObserver(this)
    }

    open fun startTimer() {}

    open fun stopTimer() {}
}
