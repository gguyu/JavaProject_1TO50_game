package com.example.javaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TipActivity : AppCompatActivity() {
    lateinit var okButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip)

        // 확인 버튼 ==> 누르면 타이틀 화면으로 다시 이동
        okButton = findViewById(R.id.okButton)
        okButton.setOnClickListener {
            finish()
        }

    }


}