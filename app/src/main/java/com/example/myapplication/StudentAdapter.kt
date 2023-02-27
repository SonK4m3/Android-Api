package com.example.myapplication

import android.R.*
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class StudentAdapter(private var _student: MutableList<Student>?,private var mContext: Context?): RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    companion object{
        const val TYPE1 = 0
        const val TYPE2 = 1
        const val VIEW_TYPE_LOADING = 2
    }

    fun getStudent() : MutableList<Student>? {
        return _student
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val itemview: View
        var studentname: TextView
        var birthyear: TextView
        var detail_button: Button

        init {
            itemview = itemView
            studentname = itemView.findViewById(R.id.studentname)
            birthyear = itemView.findViewById(R.id.birthyear)
            detail_button = itemView.findViewById(R.id.detail_button)

            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener() {
                Toast.makeText(
                    itemView.context,
                    studentname.text.toString() + " | "
                            + " Demo function", Toast.LENGTH_SHORT
                ).show()
            }
            this.itemview.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            Toast.makeText(itemview.context, "View clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    private class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var progressBar: ProgressBar

        init {
            progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (_student?.get(position) == null) VIEW_TYPE_LOADING else (if(position % 2 == 0) TYPE1 else TYPE2)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val context: Context = p0.context
        val inflater: LayoutInflater = LayoutInflater.from(context)
        return when(p1){
            TYPE1 -> {
                ViewHolder(inflater.inflate(R.layout.student_item, p0, false))
            }
            TYPE2 -> {
                ViewHolder(inflater.inflate(R.layout.student_item_2, p0, false))
            }
            else -> {
                ViewHolder(inflater.inflate(R.layout.item_loading, p0, false))
            }
        }

    }

    private fun showLoadingView(viewHolder: LoadingViewHolder, position: Int) {
        //ProgressBar would be displayed
    }

    private fun populateItemRows(viewHolder: StudentAdapter.ViewHolder, position: Int) {
        val item: String = _student?.get(position)!!.getmName()
        viewHolder.studentname.setText(item)
    }

    override fun getItemCount(): Int {
        return _student!!.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val student: Student? = _student?.get(p1)

        p0.studentname.setText(student?.getmName())
        p0.birthyear.setText(student?.birthYear.toString() + "")
    }

    fun updateListStudent(listStudent: List<Student>){
        val diffCallback = this._student?.let { StudentDiffCallback(it, listStudent) }
        val diffResult = diffCallback?.let { DiffUtil.calculateDiff(it) }
        this._student?.clear()
        this._student?.addAll(listStudent)

        diffResult?.dispatchUpdatesTo(this)
    }
}