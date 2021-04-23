package com.capgemini.androidapp

import android.app.*
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        lateinit var dlg:Dialog
        val bundle = arguments
        val message = bundle?.getString("msg")
        val btn1_title=bundle?.getString("btn1")
        val btn2_title=bundle?.getString("btn2")
        val dlgType = bundle?.getInt("type")


        val parent = activity!!
        val builder = AlertDialog.Builder(parent)

        when(dlgType){
            1-> {
                builder.setTitle("Confirmation")
                builder.setMessage("Do you want to exit")
                builder.setPositiveButton("Yes",DialogInterface.OnClickListener {
                    dialogInterface, i -> parent.finish() })

                builder.setNegativeButton("No"){
                    dlg, i-> dlg.cancel()
                }

                builder.setNeutralButton("Cancel"){
                    dlg,i -> dlg.cancel()
                }

                dlg = builder.create()
                dlg.setCancelable(false)



            }
            2 -> {//timepicker dialog
              dlg =   TimePickerDialog(parent,parent as TimePickerDialog.OnTimeSetListener,2,25,false)

            }
            3 -> {//datepicker dialog
            dlg = DatePickerDialog(parent,parent as DatePickerDialog.OnDateSetListener,2021,3,3)

            }


        }
        return dlg

        //val v = layoutInflater.inflate(R.layout.constraint_layout,null)
        //builder.setView(R.layout.constraint_layout)

    }


}