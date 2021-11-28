package com.example.javaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.timer

class GameActivity : AppCompatActivity() {
    // 타이머 기능 구현
    var time_ms : Long = 0
    var time_sec : Long = 0
    var time_min : Long = 0
    lateinit var tv_timer : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tv_timer = findViewById(R.id.tv_timer)

        //timer 기능 구현
        timer(period = 10) {
            time_ms += 1
            runOnUiThread {
                if (time_ms > 99) {
                    time_ms = 0
                    time_sec += 1
                }
                if (time_sec > 59) {
                    time_sec = 0
                    time_min += 1
                }
                tv_timer.text = "걸린 시간: ${time_min}:${time_sec}:${time_ms}"
            }
        }




    }
}