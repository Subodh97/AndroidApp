package com.capgemini.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listview.*
import kotlinx.android.synthetic.main.activity_spinner.*

class SpinnerActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    val langList = listOf("Kotlin","Java","C","Ruby","Scala","Python","C++")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,langList)
        spinner.adapter = adapter
        //lv.setOnItemClickListener(this)
        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //Toast.makeText(this,"")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}