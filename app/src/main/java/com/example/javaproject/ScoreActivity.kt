package com.example.javaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {
    // 점수판 구현
    lateinit var tv_easyScore : TextView
    lateinit var tv_commonScore : TextView
    lateinit var tv_hardScore : TextView

    // 확인 버튼
    lateinit var okButton_score : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        // 점수판 기능
        tv_easyScore = findViewById(R.id.tv_easyScore)
        tv_commonScore = findViewById(R.id.tv_commonScore)
        tv_hardScore = findViewById(R.id.tv_hardScore)

        var easyRecord : String? = ""
        var commonRecord : String? = ""
        var hardRecord : String? = ""
        var easyTime : Long = 0
        var commonTime : Long = 0
        var hardTime : Long = 0

        // SharedPreferences 활용
        easyRecord = MyApplication.prefs.getString("easy", easyRecord)
        commonRecord = MyApplication.prefs.getString("common", commonRecord)
        hardRecord = MyApplication.prefs.getString("hard", hardRecord)

        // 점수판
        // 난이도 별로 최단 시간 보여줌
        // 기록이 없으면 00:00:00 으로 보임

        // 쉬움 모드 점수
        if (easyRecord == "") {
            tv_easyScore.text = "00:00:00"
        }else {
            easyTime = easyRecord!!.toLong()
            tv_easyScore.text = "${(easyTime/(100*60))%60}:${(easyTime/100)%60}:${easyTime%100}"
        }

        // 보통 모드 점수
        if (commonRecord == "") {
            tv_commonScore.text = "00:00:00"
        }else {
            commonTime = commonRecord!!.toLong()
            tv_commonScore.text = "${(commonTime/(100*60))%60}:${(commonTime/100)%60}:${commonTime%100}"
        }

        // 하드 모드 점수
        if (hardRecord == "") {
            tv_hardScore.text = "00:00:00"
        }else {
            hardTime = hardRecord!!.toLong()
            tv_hardScore.text = "${(hardTime/(100*60))%60}:${(hardTime/100)%60}:${hardTime%100}"
        }

        // 확인 버튼 ==> 누르면 타이틀 화면으로 다시 이동
        okButton_score = findViewById(R.id.okButton_score)
        okButton_score.setOnClickListener {
            finish()
        }

    }

}