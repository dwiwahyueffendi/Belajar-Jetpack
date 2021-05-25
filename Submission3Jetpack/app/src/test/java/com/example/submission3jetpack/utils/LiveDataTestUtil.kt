package com.example.submission3jetpack.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch

object LiveDataTestUtil {
    fun <T> getValue(liveData: LiveData<T>): T {
        val data = arrayOfNulls<Any>(1)
        val latch = CountDownLatch(1)

        val observer = object : Observer<T> {
            override fun onChanged(o: T) {
                data[0] = o
                latch.countDown()
                liveData.removeObserver(this)
            }
        }

        liveData.observeForever(observer)

        try {
            latch.await(2, java.util.concurrent.TimeUnit.SECONDS)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return data[0] as T

    }
}