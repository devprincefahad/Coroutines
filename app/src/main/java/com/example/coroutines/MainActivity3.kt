package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity3 : AppCompatActivity() {

    private val TAG: String = "KOTLIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    private suspend fun printFollowers() {

        CoroutineScope(Dispatchers.IO).launch {
            var fb = async { getFbFollowers() }
            var insta = async { getInstaFollowers() }
            Log.d(TAG, "FB - ${fb.await()}, Insta - ${insta.await()}")
        }

        /*  val fb = CoroutineScope(Dispatchers.IO).async {
              getFbFollowers()
          }

          val insta = CoroutineScope(Dispatchers.IO).async {
              getInstaFollowers()
          }

          Log.d(TAG, "FB - ${fb.await()}, Insta - ${insta.await()}")*/

        /*val job = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
            "Hello"
        }
        Log.d(TAG, job.await().toString())
        */


    }

    private suspend fun getFbFollowers(): Int {
        delay(1000)
        return 54
    }

    private suspend fun getInstaFollowers(): Int {
        delay(1000)
        return 113
    }

}