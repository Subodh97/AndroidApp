package com.capgemini.androidapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = "MainActivity"
    val isDataEntered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        //submit.setOnClickListener(this)
        //cancel.setOnClickListener(this)
        //password.setOnKeyListener { v, keyCode, event ->  }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }

  override fun onClick(v: View?) {
        //var id  = v!!.id
        //when(id){
         //R.id.submit -> submitClick(v)
         //R.id.cancel -> cancelClick(v)

        //}

    }

    fun cancelClick(view : View){
       //Log.d(TAG,"cancel pressed")
        Toast.makeText(this,"Cancel Clicked",Toast.LENGTH_LONG).show()
        finish()
    }

    fun submitClick(view:View){
        //Log.d(TAG,"submit pressed")
        val id = userid.text.toString()
        val pswd = password.text.toString()

        if(id.isNotEmpty()){
            Toast.makeText(this,"You entered userid: $id, password: $pswd",Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(this,"pls enter the data",Toast.LENGTH_LONG).show()

        }
    }

    override fun onPause() {
        super.onPause()
        if(!isDataEntered){
            sendNotification()
        }
    }
    fun sendNotification(){
      val notifMngr =   getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        lateinit var builder:Notification.Builder
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("test", "AndroidApp", NotificationManager.IMPORTANCE_HIGH)
            //channel.setShowBadge(false)


            notifMngr.createNotificationChannel(channel)
            builder = Notification.Builder(this,"test")
        }
        else {
            builder = Notification.Builder(this)
        }
            builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.setContentTitle("Authentication")
        builder.setContentText("Please complete Sign-In")
        builder.setAutoCancel(true)

        val tryIntent = Intent(this,MainActivity::class.java)
        val resumeIntent = PendingIntent.getActivity(this,0,tryIntent,0)
    val resumeAction =     Notification.Action.Builder(android.R.drawable.ic_dialog_info,"Try Again",resumeIntent).build()

        builder.addAction(resumeAction)

        val l = layoutInflater.inflate(R.layout.activity_main,null)
        //create  remote view
        //set remote view
        //builder.setCustomContentView(remote view)


        val intent = Intent(this,AuthActivity::class.java)
        val pi = PendingIntent.getActivity(this,0,intent,0)
        builder.setContentIntent(pi)

        val myNotif = builder.build()
        myNotif.flags = Notification.FLAG_AUTO_CANCEL or Notification.FLAG_NO_CLEAR //Not-canceleable


        notifMngr.notify(1,myNotif)
    }

    override fun onResume() {
        super.onResume()
        val nManager = getSystemService(NOTIFICATION_SERVICE)
        //nManager.cancel(1)

    }

}