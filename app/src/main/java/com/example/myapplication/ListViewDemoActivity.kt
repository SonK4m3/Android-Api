package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.http.Url

class ListViewDemoActivity: AppCompatActivity() {

    val listSubject: List<String> = listOf("SE", "AI", "WEB", "SI")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_layout)
    }

}