package com.example.myapplication

import android.icu.util.Calendar
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RecycleViewActivity: AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var adapter: StudentAdapter? = null
    var students: ArrayList<Student>? = null
    var linearLayoutManager: LinearLayoutManager? = null

    var page = 1
    var isLoading = false
    var limit = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        // khoi tao tap du lieu
        recyclerView = findViewById(R.id.studentsList);
        students = ArrayList()
//        for (i in 1..50) {
//            students!!.add(Student("Student Name$i", 1995 + i % 2))
//        }
        //gan du lieu vao hien thi view
        adapter = StudentAdapter(students, this)
        //goi lop hien thi tung phan tu
        linearLayoutManager = LinearLayoutManager(this)
//        val linearLayoutManager = GridLayoutManager(this, 2)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = linearLayoutManager
        getPage()


        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    val visibleItemCount = linearLayoutManager?.childCount
                    val pastVisibleItem =
                        linearLayoutManager?.findFirstCompletelyVisibleItemPosition()
                    val total = adapter?.itemCount
                    if (!isLoading) {
                        if ((visibleItemCount!! + pastVisibleItem!!) >= total!!) {
                            page++
                            getPage()
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun getPage() {
        if (students!!.size > 50) {
            Toast.makeText(baseContext, "Can't not loading more", Toast.LENGTH_SHORT).show()
            return
        }
        Log.d("AAA", "more")
        isLoading = true
//        R.id.progressBar
        val start = (page - 1) * limit
        val end = (page) * limit
        for(i in start..end){
            val newStudent = Student(

                ("SINH VI??N " + (i + 1).toString() + ":"
                        + Calendar.getInstance().getTimeInMillis()), 1990
            )
            students?.add(i, newStudent)
        }
        Handler(Looper.getMainLooper()).postDelayed({
            adapter!!.notifyDataSetChanged()
            isLoading = false
        }
            , 5000
        )

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_modify_3 -> {
                //S???a ph???n t??? s??? 3
                val student = students!![2]
                student.setmName(
                    "T??N M???I S??? 3: "
                            + Calendar.getInstance().getTimeInMillis()
                )
                student.birthYear = 2000
                adapter!!.notifyItemChanged(2)
                return true
            }
            R.id.menu_insert_2 -> {
                //Th??m m???t sinh vi??n m???i v??o v??? tr?? s??? 2
                val newStudent = Student(

                    ("SINH VI??N 2:"
                            + Calendar.getInstance().getTimeInMillis()), 1990
                )
                students!!.add(1, newStudent)
                adapter!!.notifyItemInserted(1)
                return true
            }
            R.id.menu_remove_first -> {
                //X??a sinh vi??n ??? v??? tr?? ?????u ti??n
                students!!.removeAt(0)
                adapter!!.notifyItemRemoved(0)
                return true
            }
            R.id.menu_new_7 -> {
                //Danh s??ch 7 sinh vi??n m???i
                students!!.clear() //X??a b??? danh s??ch c??

                //Th??m 7 sinh vi??n m???i
                var i = 1
                while (i <= 7) {
                    students!!.add(Student("SV M???i $i", 1990 + i))
                    i++
                }

                //Th??ng b??o to??n b??? d??? li???u thay ?????i
                adapter!!.notifyDataSetChanged()
                return true
            }
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }
}