package com.example.javaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.timer

class GameActivity : AppCompatActivity() {
    // 타이머 기능 구현
    var time : Long = 0
    lateinit var tv_timer : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        tv_timer = findViewById(R.id.tv_timer)

        //timer 기능 구현 (3초 딜레이 후 시작: parameter 에 initialDelay=3000 추가)
        timer(period = 10) {
            time += 1
            runOnUiThread {
                tv_timer.text = "TIME: ${(time/(100*60))%60}:${(time/100)%60}:${time%100}"
            }
        }

        // 게임 난이도 선택 시 3초 후에 게임 시작
        // 게임 완료 시 중지 + 로컬 db 저장 (베스트 score 기록)
        // + replay 버튼 or 홈 버튼 (replay 버튼 누르면 타이머 초기화?)



    }
}