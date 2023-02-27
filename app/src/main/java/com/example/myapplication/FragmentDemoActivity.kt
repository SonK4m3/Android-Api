package com.example.myapplication

import android.os.Bundle
import android.R.*
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity

class FragmentDemoActivity: AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_demo_layout)
    }
}