 package com.example.gas_agecy_app.Activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gas_agecy_app.Models.User
import com.example.gas_agecy_app.R
import com.example.gas_agecy_app.Utils.Recycler_Adapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

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

            if (this.getSharedPreferences("Auth", MODE_PRIVATE).getString("password", null) == null)
            {
                var intent = Intent(this@Distribution_Record,Admin_Verification::class.java)
                startActivity(intent)
            }
            else
            {

                if(this.getSharedPreferences("Auth", MODE_PRIVATE).getString("password", null)=="gas_agency")
                {
                    var intent= Intent(this@Distribution_Record, NewSupplierDetail::class.java)
                    startActivity(intent)
                }

            }






        }

        back_button.setOnClickListener{
            var intent = Intent(this@Distribution_Record,MainActivity::class.java)
            startActivity(intent)
        }

        //Settting the recycler view


         var db = FirebaseFirestore.getInstance()
          db.collection("Distribution").get().addOnSuccessListener{ documents ->
              for( i in documents)
              {
                 var data = i.toObject(User::class.java)
                   list.add(
                       User(
                           data.name,
                           data.phoneNumber,
                           data.nos_given,
                           data.date,
                           data.nos_delivered,
                           data.nos_returned,
                           data.amount_per_cylinder,
                           data.total_amount,
                           data.remarks
                       )
                   )
              }



              progress_layout.visibility= View.GONE
              progress_bar.visibility= View.GONE

              adapter= Recycler_Adapter(this@Distribution_Record, list)
              layout_manger= LinearLayoutManager(this@Distribution_Record)
              recyclerView.adapter= adapter
              recyclerView.layoutManager= layout_manger


          }



    }



}