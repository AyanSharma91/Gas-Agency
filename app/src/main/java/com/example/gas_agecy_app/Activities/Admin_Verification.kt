package com.example.gas_agecy_app.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.gas_agecy_app.R

class Admin_Verification : AppCompatActivity() {

 // declaring ALl the variables
     lateinit var  password_btn  : Button
     lateinit var back_button : ImageView
     lateinit var passwords : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin__verification)

        password_btn= findViewById(R.id.password_btn)
        passwords= findViewById(R.id.passwords)
        back_button= findViewById(R.id.back_button)
        back_button.setOnClickListener{
            finish()
        }


        password_btn.setOnClickListener{
            if(passwords.text.toString()=="gas_agency")
            {
                this.getSharedPreferences("Auth", Context.MODE_PRIVATE).edit().putString("password", "gas_agency").apply();
                var intent= Intent(this@Admin_Verification,Distribution_Record::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@Admin_Verification,"Password InCorrect",Toast.LENGTH_LONG).show()
            }
        }
    }
}