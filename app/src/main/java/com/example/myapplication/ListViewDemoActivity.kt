package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListViewDemoActivity: AppCompatActivity() {

    val listSubject: List<String> = listOf("SE", "AI", "WEB", "SI")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_layout)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listSubject)
    }
}