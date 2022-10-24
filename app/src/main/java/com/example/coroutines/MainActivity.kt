package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var counterText: TextView
    private val TAG: String = "KOTLIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        counterText = findViewById(R.id.counterText)

        Log.d(TAG, "${Thread.currentThread().name}")

    }

    fun updateCounter(view: android.view.View) {
            counterText.text = "${counterText.text.toString().toInt() + 1}"
            Log.d(TAG, "${Thread.currentThread().name}")
    }

    fun doAction(view: android.view.View) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "1-${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "2-${Thread.currentThread().name}")
        }
        MainScope().launch(Dispatchers.Default) {
            Log.d(TAG, "3-${Thread.currentThread().name}")
        }
    }

    private fun executeLongRunningTask() {
        for (i in 1..10000000000L) {

        }
    }

}
