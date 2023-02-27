package com.example.myapplication

data class Student(private var mName: String, var birthYear: Int) {

    var id: Int? = null

    fun getmName(): String {
        return mName
    }

    fun setmName(s: String) {
        this.mName = s
    }
}