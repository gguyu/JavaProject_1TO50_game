package com.example.javaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class GameActivity : AppCompatActivity() {
    // 타이머 기능 구현
    var time : Long = 0
    lateinit var tv_timer : TextView
    lateinit var tv_next : TextView

    // 버튼 배열 선언
    val buttonList = ArrayList<Button>()
    // 타일 숫자 배열
    val numberList1To25 = ArrayList<Int>()
    val numberList26To50 = ArrayList<Int>()
    val numberList51To75 = ArrayList<Int>()
    val numberList76To100 = ArrayList<Int>()
    // 다음 숫자
    var nextNumber = 0

    // 실행
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        // 버튼 배열 초기화
        setButtonList()
        // 랜덤 숫자 받기
        setRandomNumber()
        // 초기 타일 설정
        setFirstTile()

        tv_next = findViewById(R.id.tv_next)

        tv_timer = findViewById(R.id.tv_timer)

        //timer 기능 구현 (3초 딜레이 후 시작: parameter 에 initialDelay=3000 추가)
        timer(period = 10, initialDelay = 3000) {
            var actState = 0
            if (actState == 0) {
                button_action()
            }
            if (nextNumber == 26) {
                cancel()
            }
            time += 1
            runOnUiThread {
                tv_timer.text = "TIME: ${(time/(100*60))%60}:${(time/100)%60}:${time%100}"
                tv_next.text = "Next: $nextNumber"
            }
        }

        // 게임 난이도 선택 시 3초 후에 게임 시작
        // 게임 완료 시 중지 + 로컬 db 저장 (베스트 score 기록)
        // + replay 버튼 or 홈 버튼 (replay 버튼 누르면 타이머 초기화?)

    }

    // ButtonList 에 버튼들 추가
    private fun setButtonList() {
        buttonList.add(findViewById(R.id.bt_1))
        buttonList.add(findViewById(R.id.bt_2))
        buttonList.add(findViewById(R.id.bt_3))
        buttonList.add(findViewById(R.id.bt_4))
        buttonList.add(findViewById(R.id.bt_5))
        buttonList.add(findViewById(R.id.bt_6))
        buttonList.add(findViewById(R.id.bt_7))
        buttonList.add(findViewById(R.id.bt_8))
        buttonList.add(findViewById(R.id.bt_9))
        buttonList.add(findViewById(R.id.bt_10))
        buttonList.add(findViewById(R.id.bt_11))
        buttonList.add(findViewById(R.id.bt_12))
        buttonList.add(findViewById(R.id.bt_13))
        buttonList.add(findViewById(R.id.bt_14))
        buttonList.add(findViewById(R.id.bt_15))
        buttonList.add(findViewById(R.id.bt_16))
        buttonList.add(findViewById(R.id.bt_17))
        buttonList.add(findViewById(R.id.bt_18))
        buttonList.add(findViewById(R.id.bt_19))
        buttonList.add(findViewById(R.id.bt_20))
        buttonList.add(findViewById(R.id.bt_21))
        buttonList.add(findViewById(R.id.bt_22))
        buttonList.add(findViewById(R.id.bt_23))
        buttonList.add(findViewById(R.id.bt_24))
        buttonList.add(findViewById(R.id.bt_25))

    }

    // 버튼에 랜덤 숫자 부여 (1~25)
    // 파라미터로 난이도 받아서 if 문써서 난이도 별로 해주면 될듯
    private fun setRandomNumber() {
        val random = Random()
        var randInt = 0
        var redundantInt = ArrayList<Int>()  // 중복체크
        var i = 0

        while (i < 25) {
            randInt = random.nextInt(25)

            if (!redundantInt.contains(randInt)) {
                redundantInt.add(randInt)
                numberList1To25.add(randInt + 1)
                i++
            }

        }

    }

    // 게임 초기 타일 설정
    private fun setFirstTile() {
        // 다음숫자 바로 1로 초기화
        nextNumber = 1

        // 랜덤하게 버튼 구성하기
        for(i in 0..24) {
            buttonList[i].text = numberList1To25[i].toString()
        }

    }


    // 버튼 클릭 액션 설정
    private fun button_action() {
        for(i in 0..24) {
            buttonList[i].setOnClickListener {
                if (nextNumber == numberList1To25[i]) {
                    nextNumber ++
                    buttonList[i].text = ""
                }

            }

        }
    }







}