package com.capgemini.androidapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_custom.*

class CustomActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    var listOfStudent = mutableListOf<Student>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        listOfStudent.add(Student("Dev",1,75.3))
        listOfStudent.add(Student("John",2,78.3))
        listOfStudent.add(Student("Tom",3,88.3))
        listOfStudent.add(Student("Mark",4,95.3))

        val adapter = StudentAdapter(this,R.layout.student_list,listOfStudent)
        studentL.adapter = adapter
        studentL.setOnItemClickListener(this)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem = listOfStudent[position]
        Toast.makeText(this,"Student Id: ${selectedItem.id} , Name: ${selectedItem.name}", Toast.LENGTH_LONG).show()
    }
}


data class Student(val name:String, val id:Int,val percent:Double)

class StudentAdapter(context:Context,val layoutRes:Int,val data:List<Student>):ArrayAdapter<Student>(context,layoutRes,data){
    override fun getItem(position: Int): Student? {
        return data[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val student = getItem(position)

        lateinit var view:View
        view = convertView ?: LayoutInflater.from(context).inflate(layoutRes,null,false)



        val stName = view.findViewById<TextView>(R.id.studentName)
       val stPercent = view.findViewById<TextView>(R.id.studentPercent)
        val stId = view.findViewById<TextView>(R.id.studentId)

        //stName.setText(student?.name)
        //stPercent.setText(student?.percent)
        //stId.setText(student?.id)

        stId.text = "${student?.id}"
        stPercent.text = "${student?.percent}"
        stName.text = student?.name

        return view
    }
}