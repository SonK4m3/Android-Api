package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2: Fragment() {

    var sent_context: String? = null

    companion object {
        const val CONTEXT = "context"

        @JvmStatic
        fun newInstance(context: String) = Fragment2().apply {
            arguments = Bundle().apply {
                putString(CONTEXT, context)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            sent_context = it.getString(CONTEXT)
        }
        Log.d("AAA",sent_context.toString())

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view?.findViewById<TextView>(R.id.result)
        val btn = view?.findViewById<Button>(R.id.getBtn)
        val fragmentManager = requireActivity().supportFragmentManager.beginTransaction()

        btn!!.setOnClickListener {
            arguments?.let {
                sent_context = it.getString(CONTEXT)
            }
            Log.d("AAA",sent_context.toString())
            textView?.text = sent_context.toString()
            fragmentManager.remove(this)
        }
    }
}