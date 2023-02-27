package com.example.myapplication

import retrofit.RetrofitActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import tablayout.TabLayoutActivity
import viewpager2.ViewPage2Activity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)

        btn1.setOnClickListener() {
            startActivity(Intent(this, FragmentDemoActivity::class.java))
        }
        btn2.setOnClickListener(){
            startActivity(Intent(this, ListViewDemoActivity::class.java))
        }
        btn3.setOnClickListener(){
            startActivity(Intent(this, RecycleViewActivity::class.java))
        }
        btn4.setOnClickListener(){
            startActivity(Intent(this, ViewPage2Activity::class.java))
        }
        btn5.setOnClickListener(){
            startActivity(Intent(this, TabLayoutActivity::class.java))
        }
        btn6.setOnClickListener(){
            startActivity(Intent(this, RetrofitActivity::class.java))
        }
    }
}