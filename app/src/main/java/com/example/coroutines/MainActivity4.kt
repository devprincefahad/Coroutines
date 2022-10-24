package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity4 : AppCompatActivity() {

    private val TAG: String = "KOTLIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        GlobalScope.launch(Dispatchers.Main) {
            execute()
        }


    }

    private suspend fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Parent started")

            val childJob = launch(Dispatchers.IO) {
                Log.d(TAG, "Child job started")
                delay(5000)
                Log.d(TAG, "Child job ended")
            }
            delay(3000)
            Log.d(TAG, "Child job cancelled")
            childJob.cancel()
            Log.d(TAG, "Parent ended")
        }
        parentJob.join()
        Log.d(TAG, "Parent Completed")
    }
}