package com.capgemini.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast

class CheckBoxActivity : AppCompatActivity() {
    var cityList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
    }

    fun chechboxClicked(view: View){
        if(view is CheckBox){
            val city = view.text.toString()
            if(view.isChecked)
                cityList.add(city)
            else
                cityList.remove(city)
        }
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Selected cities are $cityList",Toast.LENGTH_LONG).show()

    }
}