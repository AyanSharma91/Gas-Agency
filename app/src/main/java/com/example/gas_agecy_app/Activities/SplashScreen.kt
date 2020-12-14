package com.example.gas_agecy_app.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.gas_agecy_app.R
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.Exception

class SplashScreen: AppCompatActivity() {




    lateinit var logo : CircleImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen)
        logo = findViewById(R.id.logo)
        logo.alpha=0f


        logo.animate().alpha(1f).duration=2000

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(3000)
                    val intent= Intent(this@SplashScreen,
                        MainActivity::class.java)
                    startActivity(intent)

                }   catch (e: Exception){
                    e.printStackTrace()}
            }

        }
        background.start()
    }
}
