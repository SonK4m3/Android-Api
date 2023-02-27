package com.example.myapplication

import androidx.recyclerview.widget.DiffUtil


class StudentDiffCallback(var oldList: List<Student>,var newList: List<Student>): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList?.size!!
    }

    override fun getNewListSize(): Int {
        return newList?.size!!
    }

    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        return oldList?.get(p0)?.id === newList?.get(p1)?.id
    }

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        return (oldList!![p0].getmName() === newList!![p1].getmName())
    }

}