package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //綁定變數與畫面元件
        val tvRiddle = findViewById<TextView>(R.id.tv_riddle)
        val edAnswer = findViewById<TextView>(R.id.ed_answer)
        val btnRiddle = findViewById<Button>(R.id.btn_riddle)
        val btnAnswer = findViewById<Button>(R.id.btn_answer)
        val btnReAnswer = findViewById<Button>(R.id.btn_reAnswer)
        val btnShowAnswer = findViewById<Button>(R.id.btn_showAnswer)
        val tvResult = findViewById<TextView>(R.id.tv_result)

        var index = 0
        var riddleList = mutableListOf("0000,猜一句成語。:四大皆空","人有他大，天沒他大,猜一個字。:一","台灣女孩，猜一個字。:始","九十九，猜一個字。:白","0+0=1，猜一成語。:無中生有" )

        edAnswer.text = null
        tvResult.text = null
        btnRiddle.setOnClickListener{
            edAnswer.text = null
            tvResult.text = null

            index = Random.nextInt(0,5)
               val countRiddle = riddleList.count()
               val (riddle,answer) = riddleList[index].split(":")
               tvRiddle.text = "謎題:"+riddle
               if (index >= countRiddle)
                  index = 0

            //按答題鍵
            btnAnswer.setOnClickListener{
                if (edAnswer.text.toString() == answer){
                    tvResult.text = "你好棒，您答對了!"

                }
                else{
                    tvResult.text = "沒猜中，再試一下吧!"
                }
            }
            btnReAnswer.setOnClickListener{
                edAnswer.text = null
                tvResult.text = null
            }
            btnShowAnswer.setOnClickListener{
                tvResult.text = "答案是: "+answer
            }
        }
    }
}