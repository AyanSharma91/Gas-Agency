package com.example.gas_agecy_app.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.gas_agecy_app.Models.User
import com.example.gas_agecy_app.R
import com.example.gas_agecy_app.Utils.Recycler_Adapter
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_distribution_record.*

class Distribution_Record : AppCompatActivity() {

    lateinit var title : TextView
    lateinit var adapter : Recycler_Adapter

    var list = ArrayList<User>()
     lateinit var  progress_layout : RelativeLayout
    lateinit var  progress_bar : ProgressBar
    lateinit var layout_manger : LinearLayoutManager
    lateinit var recyclerView : RecyclerView
    lateinit var back_button : ImageView
    lateinit var fab : FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distribution_record)
        title= findViewById(R.id.title_new)
        recyclerView = findViewById(R.id.recycler_view)
        back_button= findViewById(R.id.back_button)
        progress_bar= findViewById(R.id.progress_bar)
        progress_layout= findViewById(R.id.progress_layout)
        progress_layout.visibility= View.VISIBLE
        progress_bar.visibility= View.VISIBLE
        fab= findViewById(R.id.fab)

        //Changing the title
        title.text= "Distribution Record"



        fab.setOnClickListener{
            var intent= Intent(this@Distribution_Record,NewSupplierDetail::class.java)
            startActivity(intent)

        }

        back_button.setOnClickListener{
            finish()
        }

        //Settting the recycler view


         var db = FirebaseFirestore.getInstance()
          db.collection("Distribution").get().addOnSuccessListener{ documents ->
              for( i in documents)
              {
                 var data = i.toObject(User::class.java)
                   list.add(User(data.name,data.phoneNumber,data.nos_given,data.date,data.nos_delivered,data.nos_returned,data.amount_per_cylinder,data.total_amount,data.remarks))
              }



              progress_layout.visibility= View.GONE
              progress_bar.visibility= View.GONE

              adapter= Recycler_Adapter(this@Distribution_Record, list)
              layout_manger= LinearLayoutManager(this@Distribution_Record)
              recyclerView.adapter= adapter
              recyclerView.layoutManager= layout_manger


          }
//        for(i in 1..10)
//        {
//            list.add(User("Ayan Sharma","7300284441","10","23/4/20","4","6","900","8000","Payment is due to the date"))
//        }


    }



}