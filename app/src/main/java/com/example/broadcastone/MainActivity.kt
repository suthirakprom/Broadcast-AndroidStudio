package com.example.broadcastone

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var br:BroadcastReceiver   //  create a broadcastReceiver globally
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)

        var br = object: BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?)   //  this onReceive is not sure which action is happening
            {
                Toast.makeText(this@MainActivity, p1?.action, Toast.LENGTH_LONG).show() //  this toast will show which action is happening
            }

        }
        registerReceiver(br,intentFilter)
    }

    override fun onDestroy() {
        unregisterReceiver(br)  //pass your broadcast here, the broadcast will be destroyed when the application is closed
        super.onDestroy()
    }

}
