package com.example.gas_agecy_app.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.gas_agecy_app.Models.User
import com.example.gas_agecy_app.R
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class NewSupplierDetail : AppCompatActivity() {


     lateinit var name  :EditText
     lateinit var number : EditText
     lateinit var date  : EditText
     lateinit var  cylinder_given : EditText
     lateinit var  amount_per_cylinders  : EditText
     lateinit var  remarks  : EditText
     lateinit var  nos_delivered  : EditText
     lateinit var  total_amounts : EditText
     lateinit var  nos_returned : EditText
    lateinit var save_btn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_supplier_detail)


        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        date = findViewById(R.id.date)
        cylinder_given = findViewById(R.id.cylinder_given)
        amount_per_cylinders = findViewById(R.id.amount_per_cylinders)
        remarks = findViewById(R.id.remarks)
        nos_delivered = findViewById(R.id.nos_delivered)
        total_amounts = findViewById(R.id.total_amounts)
        nos_returned = findViewById(R.id.nos_returned)
        save_btn= findViewById(R.id.save_btn)


        if(intent.getStringExtra("name")!==null)
        {
            name.setText(intent.getStringExtra("name"))
            number.setText(intent.getStringExtra("phoneNumber"))
            date.setText(intent.getStringExtra("date"))
            cylinder_given.setText(intent.getStringExtra("nos_given"))
            amount_per_cylinders.setText(intent.getStringExtra("amount_per_cylinder"))
            remarks.setText(intent.getStringExtra("remarks"))
            nos_delivered.setText(intent.getStringExtra("nos_delivered"))
            total_amounts.setText(intent.getStringExtra("total_amount"))
            nos_returned.setText(intent.getStringExtra("nos_returned"))

        }



        save_btn.setOnClickListener{

            if(intent.getStringExtra("name")!==null)
            {
                _update_data()
            }
            else
            {
                _save_to_Firebase()
            }

        }





    }

    private fun _update_data() {

            var db = FirebaseFirestore.getInstance()
            var snapshot=  db.collection("Distribution").document(intent.getStringExtra("name")!!)

        var user = User(name.text.toString(),
            number.text.toString(),
            cylinder_given.text.toString(),
            date.text.toString(),
            nos_delivered.text.toString(),
            nos_returned.text.toString(),
            amount_per_cylinders.text.toString(),
            total_amounts.text.toString(),
            remarks.text.toString()
        )

        snapshot.set(user).addOnSuccessListener{
            var intent = Intent(this@NewSupplierDetail,Distribution_Record::class.java)
            startActivity(intent)
        }



    }

    private fun _save_to_Firebase() {
        var user = User(name.text.toString(),
            number.text.toString(),
            cylinder_given.text.toString(),
            date.text.toString(),
            nos_delivered.text.toString(),
            nos_returned.text.toString(),
            amount_per_cylinders.text.toString(),
            total_amounts.text.toString(),
            remarks.text.toString()
        )

        var db = FirebaseFirestore.getInstance()
        db.collection("Distribution").document(name.text.toString()).set(user).addOnSuccessListener{
            var intent = Intent(this@NewSupplierDetail,Distribution_Record::class.java)
            startActivity(intent)
        }
    }
}