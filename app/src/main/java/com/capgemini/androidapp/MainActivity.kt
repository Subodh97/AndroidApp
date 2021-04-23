package com.capgemini.androidapp

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TaskStackBuilder
import android.app.TimePickerDialog
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.*
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.constraint_layout.*
class MainActivity : AppCompatActivity(), View.OnClickListener,TimePickerDialog.OnTimeSetListener
,DatePickerDialog.OnDateSetListener{

    var firstTimeUser = true
    //lateinit var registerButton : Button
    //lateinit var msgText:TextView
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)
        Log.d(TAG,"onCreate called")
        //registerButton = findViewById(R.id.register)
        //msgText = findViewById(R.id.textView3)
    registerForContextMenu(demoBtn)

        signin.setOnClickListener(this)
        RegisterB.setOnClickListener(this)
        //RegisterB.setOnClickListener {
          //  Toast.makeText(it.context, "${it.id} Clicked",Toast.LENGTH_LONG).show()}
        if(firstTimeUser==false){
            RegisterB.visibility = View.GONE
            textView5.text = "Please Sign IN"
        }


    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG,"onStart called")
    }
    override fun onResume() {
        //load data
        super.onResume()
        Log.d(TAG,"onResume called")

    }

    override fun onPause() {
        //save data
        super.onPause()
        Log.d(TAG,"onPause called")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy called")

    }

    override fun onRestart() {
        super.onRestart()
        firstTimeUser = false
        Log.d(TAG,"onRestart called")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        //if(registerB.onKeyDown()) firstTimeUser = false
        super.onSaveInstanceState(outState)
    }
    var count = 0
    override fun onBackPressed() {
        count++
        if(count==2){
            super.onBackPressed()
        }
        else{
            Toast.makeText(this,"Press Back Again to Exit",Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View?) {
        var id = v!!.id
        when(id){
            R.id.RegisterB -> {//var t = Toast.makeText(this,"Register Button clicked",Toast.LENGTH_LONG).show()
              // val i = Intent(this,RegisterActivity::class.java)
                //startActivity(i)
               val popMenu =  PopupMenu(this,RegisterB)
                val menu = popMenu.menu
                menu.add(0,1,0,"Driver")
                menu.add(0,2,1,"Customer")
                popMenu.show()
                popMenu.setOnMenuItemClickListener {
                    when(it.itemId){
                        1-> {

                            val i = Intent(this,RegisterActivity::class.java)
                            startActivity(i)
                            true
                        }
                        2-> {
                            val i = Intent(this,RegisterActivity::class.java)
                            startActivity(i)
                            true
                        }
                        else -> false
                    }
                }
                 }
            R.id.signin -> {
                //var t = Toast.makeText(this,"Sign In Button clicked",Toast.LENGTH_LONG).show()
                //t.setGravity(Gravity.TOP,10,10)
                //t.show()

              // val snack =  Snackbar.make(parentLyt,"Signing In..",Snackbar.LENGTH_INDEFINITE)
                //snack.setAction("UNDO",View.OnClickListener {
                  //  Snackbar.make(parentLyt,"Action Undone",Snackbar.LENGTH_LONG).show()
                //})
                //snack.show()
                val i = Intent(this,AuthActivity::class.java)
                startActivity(i)
            }
        }


    }
    fun demoClick(view:View){
        val i = Intent(this,DemoActivity::class.java)
        startActivity(i)
    }
    val MENU_LOGIN = 1
    val MENU_REGISTER = 2
    val MENU_EXIT = 3
    val MENU_TIME = 4
    val MENU_DATE = 5
    val MENU_PROGRESS = 6
    val MENU_STOP = 7
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       val loginItem =  menu?.add(0,MENU_LOGIN,0,"LOGIN")
        loginItem?.setIcon(android.R.drawable.ic_dialog_info)
        loginItem?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu?.add(0,MENU_REGISTER,1,"REGISTER")
        menu?.add(0,MENU_EXIT,2,"EXIT")
        menu?.add(0,MENU_DATE,3,"PICK DATE")
        menu?.add(0,MENU_TIME,4,"PICK TIME")
        menu?.add(0,MENU_PROGRESS,5,"START TASK")
        menu?.add(0,MENU_STOP,6,"STOP TASK")

        return super.onCreateOptionsMenu(menu)
    }

    lateinit var pDlg : ProgressDialog
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           MENU_PROGRESS->{
              // pDlg = ProgressDialog.show(this,"Downloading","pls Wait",true,true)
                progressBar.visibility = View.VISIBLE
               progressBar.progress = 25
           }
           MENU_STOP ->{
               progressBar.visibility = View.INVISIBLE
           }

           MENU_LOGIN -> {
               val i = Intent(this,AuthActivity::class.java)
               startActivity(i)
               return true
           }
           MENU_REGISTER -> {
               val dlg = MyDialog()
               //put data
               val bundle = Bundle()

               bundle.putString("bt1","Customer")
               bundle.putString("btn2","Driver")
               dlg.arguments = bundle

               dlg.show(supportFragmentManager,"xyz")
               return true
               //val i = Intent(this,RegisterActivity::class.java)
               //startActivity(i)
               //return true
           }
           MENU_EXIT -> {
               //finish()

               val dlg = MyDialog()
               //put data
               val bundle = Bundle()
               bundle.putString("msg","Do you want to Exit")
            bundle.putInt("type",1)
                dlg.arguments = bundle
               dlg.show(supportFragmentManager,"xyz")

           }
           MENU_TIME -> {
               val dlg = MyDialog()
               val bundle = Bundle()
               bundle.putInt("type",2)
               dlg.arguments = bundle
               dlg.show(supportFragmentManager,"time")

           }
           MENU_DATE ->{
               val dlg = MyDialog()
               val bundle = Bundle()
               bundle.putInt("type",3)
               dlg.arguments = bundle
               dlg.show(supportFragmentManager,"date")
           }

       }
        return super.onOptionsItemSelected(item)
    }

    val MENU_CB =2
    val MENU_RB = 1
    val MENU_LV = 3
    val MENU_SP = 4
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.demoBtn) {
            menu?.add(0, MENU_RB, 0, "Redio Btn Demo")
            menu?.add(0, MENU_CB, 0, "Check Box Btn Demo")
            menu?.add(0, MENU_LV, 0, "List View Demo")
            menu?.add(0, MENU_SP, 0, "Spinner Demo")
        }

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        lateinit var intent : Intent
        when(item.itemId){
            MENU_LV ->{
                intent = Intent(this,ListviewActivity::class.java)
                startActivity(intent)
            }
            MENU_CB->{
                intent = Intent(this,CheckBoxActivity::class.java)
                startActivity(intent)
            }
            MENU_RB ->{
                intent = Intent(this,RadioActivity::class.java)
                startActivity(intent)
            }
            MENU_SP->{
                intent = Intent(this,SpinnerActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onContextItemSelected(item)
    }

    override fun onTimeSet(p1:TimePicker?,p2:Int,p3:Int){
        Toast.makeText(this,"Time: $p2 hrs, $p3 min",Toast.LENGTH_LONG).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(this,"Date: $year-$month-$dayOfMonth",Toast.LENGTH_LONG).show()
    }

}
