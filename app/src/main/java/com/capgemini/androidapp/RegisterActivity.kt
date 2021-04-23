package com.capgemini.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun cancelClick(view : View){
        //Log.d(TAG,"cancel pressed")
        Toast.makeText(this,"Cancel Clicked", Toast.LENGTH_LONG).show()
        finish()
    }

    fun submitClick(view:View){
        //Log.d(TAG,"submit pressed")
        val Name = NameReg.text.toString()
        val password = passwordReg.text.toString()

        if(Name.isNotEmpty()){
            Toast.makeText(this,"You entered userid: $Name, password: $password",Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(this,"pls enter the data",Toast.LENGTH_LONG).show()

        }
    }
}