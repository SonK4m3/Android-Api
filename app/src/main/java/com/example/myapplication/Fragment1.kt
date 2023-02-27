package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class Fragment1: Fragment() {
    private val bundle = Bundle()

    companion object {
        const val CONTEXT = "context"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentManager = requireActivity().supportFragmentManager.beginTransaction()

        val btn = view?.findViewById<Button>(R.id.sendBtn)
        val editText = view?.findViewById<EditText>(R.id.editText)

        btn?.setOnClickListener(){
            val text = editText?.text.toString()
            Log.d("AAA", text)
            val dashboardFragment = Fragment2.newInstance(text)
            fragmentManager.replace(R.id.fragment_activity, dashboardFragment)
            fragmentManager.commit()

        }
    }
}