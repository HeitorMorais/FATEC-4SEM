package com.example.lifecycle

import android.app.Activity
import android.os.Bundle
import android.util.Log

class LifeCycleActivity : Activity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        Log.v("CYCLE", "Activity criada onCreate()")
        setContentView(R.layout.main)
    }

    override fun onStart() {
        super.onStart()
        Log.v("CYCLE", "Activity iniciada onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.v("CYCLE", "Activity está vísivel onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.v("CYCLE", "Activity está pausada onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.v("CYCLE", "Activity está parada onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("CYCLE", "Activity foi destruída onDestroy()")
    }
}