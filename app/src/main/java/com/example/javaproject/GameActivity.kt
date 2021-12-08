package com.example.javaproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.javaproject.MyApplication.Companion.prefs
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class GameActivity : AppCompatActivity() {
    // 타이머 기능 구현
    var time : Long = 0
    lateinit var tv_timer : TextView
    lateinit var tv_next : TextView
    // best record 기능 구현
    lateinit var tv_best : TextView
    lateinit var tv_record : TextView
    // 버튼 배열 선언
    val buttonList = ArrayList<Button>()
    // 타일 숫자 배열
    val numberList1To25 = ArrayList<Int>()
    val numberList26To50 = ArrayList<Int>()
    val numberList51To75 = ArrayList<Int>()
    val numberList76To100 = ArrayList<Int>()
    // 다음 숫자, 끝나는 숫자
    var nextNumber = 0
    var endNumber = 0
    // 그만하기, 다시하기 버튼
    lateinit var stopButton : TextView
    lateinit var retryButton : TextView
    // 난이도 변수 (easy: 1 , common: 2, hard: 3)
    var difficulty = 0

    // 실행
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        // 그만하기 버튼 ==> 게임 난이도 선택으로 이동
        stopButton = findViewById(R.id.bt_home)
        stopButton.setOnClickListener {
            finish()
        }

        // 다시하기 버튼 ==> 같은 난이도 게임 재시작
        retryButton = findViewById(R.id.bt_retry)
        retryButton.setOnClickListener {
            val intent = Intent(this@GameActivity, GameActivity::class.java)
            intent.putExtra("difficulty", difficulty)
            startActivity(intent)
            finish()
        }

        // 버튼 배열 초기화
        setButtonList()
        // 난이도 설정
        setDifficulty()
        // 랜덤 숫자 받기
        setRandomNumber()
        // 초기 타일 설정
        setFirstTile()
        // 상단 텍스트뷰
        tv_next = findViewById(R.id.tv_next)
        tv_timer = findViewById(R.id.tv_timer)
        // 베스트 레코드 표시
        tv_record = findViewById(R.id.tv_record)
        tv_best = findViewById(R.id.tv_best)

        var bestRecord : String? = ""
        var record_time : Long = Long.MAX_VALUE

        if (difficulty == 1) {
            bestRecord = prefs.getString("easy", bestRecord)
        }else if (difficulty == 2) {
            bestRecord = prefs.getString("common", bestRecord)
        }else if (difficulty == 3) {
            bestRecord = prefs.getString("hard", bestRecord)
        }
        if (bestRecord == "") {
            tv_record.text = "00:00:00"
        }else {
            record_time = bestRecord!!.toLong()
            tv_record.text = "${(record_time/(100*60))%60}:${(record_time/100)%60}:${record_time%100}"
        }

        // 3초 딜레이 시간
        var readyTime = 0
        timer(period = 1000) {
            readyTime += 1
            runOnUiThread {
                if (readyTime == 1) {
                    // 3 표시
                    tv_timer.text = "READY 3"
                    tv_next.text = "Next: 1"
                }else if (readyTime == 2) {
                    // 2 표시
                    tv_timer.text = "READY 2"
                }else if (readyTime == 3) {
                    // 1 표시
                    tv_timer.text = "READY 1"
                }else if (readyTime == 3) {
                    // 아무표시 안함
                    cancel()
                }
            }
        }

        //timer 기능 구현 (3초 딜레이 후 시작: parameter 에 initialDelay=3000 추가)
        var actState = 0
        timer(period = 10, initialDelay = 3000) {
            if (actState == 0) {
                button_action()
                actState++
            }

            if (nextNumber == endNumber) {
                cancel()

                // best score 와 비교해서 난이도별 최단 시간만 저장
                if (time < record_time ) {
                    tv_best.text = "Very Well! New Record!!!"
                    tv_best.setTextColor(getColor(R.color.purple_200))

                    if (difficulty == 1) {
                        prefs.edit().putString("easy", time.toString()).commit()
                    }else if (difficulty == 2) {
                        prefs.edit().putString("common", time.toString()).commit()
                    }else if (difficulty == 3) {
                        prefs.edit().putString("hard", time.toString()).commit()
                    }
                }
            }
            time += 1
            runOnUiThread {
                tv_timer.text = "TIME: ${(time/(100*60))%60}:${(time/100)%60}:${time%100}"
                if (nextNumber < endNumber) {
                    tv_next.text = "Next: $nextNumber"
                }else {
                    tv_next.text = "DONE!"
                }
            }
        }

        // 게임 완료 시 중지 + 로컬 db 저장 (각 난이도별 최단 시간만 기록)

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

    // 난이도 설정
    private fun setDifficulty() {
        // 난이도 변수 (easy: 1 , common: 2, hard: 3)
        val difficultyInt = intent.extras?.get("difficulty").toString().toInt()
        difficulty = difficultyInt

        // 난이도 별 끝나는 숫자 설정
        if (difficulty == 1) {
            endNumber = 26
        }else if (difficulty == 2) {
            endNumber = 51
        }else if (difficulty == 3) {
            endNumber = 101
        }

    }

    // 버튼에 랜덤 숫자 부여 (1~25)
    private fun setRandomNumber() {
        val random = Random()
        var randInt = 0
        var redundantInt = ArrayList<Int>()  // 중복 체크 용도
        var i = 0
        // 자바의 case 문 ==> 코틀린의 when 문
        // 랜덤으로 뽑아올 때 0부터 뽑아오므로 원하는 숫자를 가져오기 위해 1, 26, 51, 76 더해서 저장
        when(difficulty) {
            3->{ // 하드 난이도일 때, 랜덤 숫자 25개씩 4개 배열에 저장
                while (i < 25) {
                    randInt = random.nextInt(25)

                    if (!redundantInt.contains(randInt)) {  // 랜덤으로 숫자 뽑아올 때 중복 방지
                        redundantInt.add(randInt)
                        numberList76To100.add(randInt + 76)
                        i++
                    }
                }
                i = 0
                redundantInt.clear()

                while (i < 25) {
                    randInt = random.nextInt(25)

                    if (!redundantInt.contains(randInt)) {  // 랜덤으로 숫자 뽑아올 때 중복 방지
                        redundantInt.add(randInt)
                        numberList51To75.add(randInt + 51)
                        i++
                    }
                }
                i = 0
                redundantInt.clear()

                while (i < 25) {
                    randInt = random.nextInt(25)

                    if (!redundantInt.contains(randInt)) { // 랜덤으로 숫자 뽑아올 때 중복 방지
                        redundantInt.add(randInt)
                        numberList26To50.add(randInt + 26)
                        i++
                    }
                }
                i = 0
                redundantInt.clear()

                while (i < 25) {
                    randInt = random.nextInt(25)

                    if (!redundantInt.contains(randInt)) { // 랜덤으로 숫자 뽑아올 때 중복 방지
                        redundantInt.add(randInt)
                        numberList1To25.add(randInt + 1)
                        i++
                    }
                }
                i = 0
                redundantInt.clear()

            }
            2->{ // 보통 난이도일 때 랜덤 숫자 25개씩 2개 배열에 저장
                while (i < 25) {
                    randInt = random.nextInt(25)

                    if (!redundantInt.contains(randInt)) { // 랜덤으로 숫자 뽑아올 때 중복 방지
                        redundantInt.add(randInt)
                        numberList26To50.add(randInt + 26)
                        i++
                    }
                }
                i = 0
                redundantInt.clear()

                while (i < 25) {
                    randInt = random.nextInt(25)

                    if (!redundantInt.contains(randInt)) { // 랜덤으로 숫자 뽑아올 때 중복 방지
                        redundantInt.add(randInt)
                        numberList1To25.add(randInt + 1)
                        i++
                    }
                }
                i = 0
                redundantInt.clear()

            }
            1->{ // 쉬움 난이도일 때 랜덤 숫자 25개 배열에 저장
                while (i < 25) {
                    randInt = random.nextInt(25)

                    if (!redundantInt.contains(randInt)) { // 랜덤으로 숫자 뽑아올 때 중복 방지
                        redundantInt.add(randInt)
                        numberList1To25.add(randInt + 1)
                        i++
                    }
                }
                i = 0
                redundantInt.clear()

            }
            else->{ // 혹시 모를 예외를 대비한 default 설정
                difficulty = 2  // default를 보통 난이도로 설정
                // 다시 랜덤 숫자 부여 (보통 난이도로)
                setRandomNumber()
            }
        }


    }

    // 게임 초기 타일 설정
    private fun setFirstTile() {
        // 다음숫자 바로 1로 초기화
        nextNumber = 1

        // 랜덤하게 버튼 구성하기 (초기 타일이므로 1부터 25까지)
        for(i in 0..24) {
            buttonList[i].text = numberList1To25[i].toString()
        }

    }

    // 버튼 클릭 액션 설정
    private fun button_action() {
        // 쉬움 + 보통 + 하드
        for(i in 0..24) {
            buttonList[i].setOnClickListener {
                // 각 난이도 별로 버튼을 눌렀을 때 다음 나와야할 숫자나 공백 설정
                if (difficulty == 1) { // 쉬움 난이도
                    if (nextNumber == numberList1To25[i]) {
                        nextNumber ++
                        buttonList[i].text = ""
                        buttonList[i].setBackgroundColor(Color.LTGRAY)
                    }
                }else if (difficulty == 2) { // 보통 난이도
                    if (nextNumber == numberList1To25[i]) {
                        nextNumber ++
                        buttonList[i].text = numberList26To50[i].toString()
                    }
                    if (nextNumber == numberList26To50[i]) {
                        nextNumber ++
                        buttonList[i].text = ""
                        buttonList[i].setBackgroundColor(Color.LTGRAY)
                    }
                }else if (difficulty == 3) { // 하드 난이도
                    if (nextNumber == numberList1To25[i]) {
                        nextNumber ++
                        buttonList[i].text = numberList26To50[i].toString()
                    }
                    if (nextNumber == numberList26To50[i]) {
                        nextNumber ++
                        buttonList[i].text = numberList51To75[i].toString()
                    }
                    if (nextNumber == numberList51To75[i]) {
                        nextNumber ++
                        buttonList[i].text = numberList76To100[i].toString()
                    }
                    if (nextNumber == numberList76To100[i]) {
                        nextNumber ++
                        buttonList[i].text = ""
                        buttonList[i].setBackgroundColor(Color.LTGRAY)
                    }
                }

            }

        }

    }



}