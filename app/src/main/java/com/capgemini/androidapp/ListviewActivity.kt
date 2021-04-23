package com.capgemini.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listview.*

class ListviewActivity : AppCompatActivity() ,AdapterView.OnItemClickListener{
    val langList = listOf("Kotlin","Java","C","Ruby","Scala","Python","C++")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,langList)
        lv.adapter = adapter
        lv.setOnItemClickListener(this)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = langList[position]
        Toast.makeText(this,"Selected Item: $selectedItem",Toast.LENGTH_LONG).show()
            
    }


}