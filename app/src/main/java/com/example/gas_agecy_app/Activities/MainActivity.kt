package com.example.gas_agecy_app.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.gas_agecy_app.Models.sliderImages
import com.example.gas_agecy_app.Utils.PagerAdapter
import com.example.gas_agecy_app.R
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var view_pager : ViewPager2
    lateinit var timer : Timer
    lateinit var runnable : Runnable
    var handler =  Handler()
    var imageList = ArrayList<sliderImages>()

    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1= findViewById(R.id.btn1)
        btn2= findViewById(R.id.btn2)
        btn3= findViewById(R.id.btn3)

        view_pager= findViewById(R.id.view_pager2)
        timer= Timer()


        imageList.add(sliderImages(R.drawable.cylinder_image_one))
        imageList.add((sliderImages(R.drawable.cylinder_image_two)))
        imageList.add((sliderImages(R.drawable.cylinder_image_three)))
        imageList.add((sliderImages(R.drawable.cylinder_image_four)))


        var adapter = PagerAdapter(this@MainActivity, imageList, view_pager)
        view_pager.adapter = adapter



        view_pager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 5000)

            }
        })

        runnable = object : Runnable {
            override fun run() {

                view_pager.setCurrentItem(view_pager.currentItem + 1)

            }
        }



        btn1.setOnClickListener {
            var intent = Intent(this@MainActivity, Distribution_Record::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener{
            var intent = Intent(this@MainActivity,Transactions_Details_Activity::class.java)
            startActivity(intent)
        }




    }
}