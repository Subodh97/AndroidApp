package com.capgemini.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)



    }
    
    fun buttonClick(view: View){
        val id = view.id
        when(id){
            R.id.radioB ->{
                val i = Intent(this,RadioActivity::class.java)
                startActivity(i)
            }
            R.id.checkB ->{
                val i = Intent(this,CheckBoxActivity::class.java)
                startActivity(i)
            }
            R.id.listB ->{
                val i = Intent(this,ListviewActivity::class.java)
                startActivity(i)
            }
            R.id.spinnerB ->{
                val i = Intent(this,SpinnerActivity::class.java)
                startActivity(i)
            }
            R.id.WebB -> {
                val i = Intent(this,WebviewActivity::class.java)
                startActivity(i)
            }
            R.id.customAdp -> {
                    val i = Intent(this,CustomActivity::class.java)
                    startActivity(i)
            }
        }
    }


}