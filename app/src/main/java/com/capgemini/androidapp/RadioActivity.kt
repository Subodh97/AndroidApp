package com.capgemini.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

class RadioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)
    }

    fun radioClicked(view: View){
        if(view is RadioButton){
            val isChecked = view.isChecked
            if(isChecked){
                var selectedCity = view.text.toString()
           Toast.makeText(this,"Selected City is $selectedCity",Toast.LENGTH_LONG).show()
            }
        }
    }
}