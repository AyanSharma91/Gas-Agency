package com.example.gas_agecy_app.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.gas_agecy_app.Models.User
import com.example.gas_agecy_app.R
import com.example.gas_agecy_app.Utils.Recycler_Adapter
import kotlinx.android.synthetic.main.activity_distribution_record.*

class Distribution_Record : AppCompatActivity() {

    lateinit var title : TextView
    lateinit var adapter : Recycler_Adapter
    var list = ArrayList<User>()
    lateinit var layout_manger : LinearLayoutManager
    lateinit var recyclerView : RecyclerView
    lateinit var back_button : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distribution_record)
        title= findViewById(R.id.title_new)
        recyclerView = findViewById(R.id.recycler_view)
        back_button= findViewById(R.id.back_button)

        //Changing the title
        title.text= "Distribution Record"

        back_button.setOnClickListener{
            finish()
        }

        //Settting the recycler view

        for(i in 1..10)
        {
            list.add(User("Ayan Sharma","7300284441","10","23/4/20","4"))
        }

        adapter= Recycler_Adapter(this@Distribution_Record, list)
        layout_manger= LinearLayoutManager(this@Distribution_Record)
        recyclerView.adapter= adapter
        recyclerView.layoutManager= layout_manger



    }
}