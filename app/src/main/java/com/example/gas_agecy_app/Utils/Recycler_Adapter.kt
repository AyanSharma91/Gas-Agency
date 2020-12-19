package com.example.gas_agecy_app.Utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gas_agecy_app.Activities.NewSupplierDetail
import com.example.gas_agecy_app.Models.User
import com.example.gas_agecy_app.R
import org.w3c.dom.Text

class Recycler_Adapter(val context: Context, val arr: ArrayList<User>) : RecyclerView.Adapter<Recycler_Adapter.DashboardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_row_recycler_view, parent, false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arr.size
    }


    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = arr[position]
        holder.name.text = book.name
        holder.date.text = book.date
        holder.nos_delivered.text = book.nos_delivered
        holder.phoneNumber.text = book.phoneNumber
        holder.nos_given.text = book.nos_given
        holder.amount_per_cylinder.text = book.amount_per_cylinder
        holder.nos_returned.text= book.nos_returned
        holder.total_amount.text= book.total_amount
        holder.remarks.text = book.remarks
        holder.parent_layout.setOnClickListener{

            var intent = Intent(context,NewSupplierDetail::class.java)
            intent.putExtra("name",holder.name.text)
            intent.putExtra("date",holder.date.text)
            intent.putExtra("nos_delivered", holder.nos_delivered.text)
            intent.putExtra("phoneNumber", holder.phoneNumber.text)
            intent.putExtra("nos_given",  holder.nos_given.text)
            intent.putExtra("amount_per_cylinder", holder.amount_per_cylinder.text)
            intent.putExtra("nos_returned", holder.nos_returned.text)
            intent.putExtra("total_amount",holder.total_amount.text)
            intent.putExtra("remarks", holder.remarks.text)
            context.startActivity(intent)



        }

    }

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById<TextView>(R.id.name)
        var phoneNumber = view.findViewById<TextView>(R.id.phoneNumber)
        var nos_given = view.findViewById<TextView>(R.id.nos_given)
        var date = view.findViewById<TextView>(R.id.date)
        var nos_delivered = view.findViewById<TextView>(R.id.nos_delivered)
        var nos_returned = view.findViewById<TextView>(R.id.nos_returned)
        var amount_per_cylinder = view.findViewById<TextView>(R.id.amount_per_cylinder)
        var total_amount = view.findViewById<TextView>(R.id.total_amount)
        var  remarks = view.findViewById<TextView>(R.id.remarks)
        var parent_layout = view.findViewById<CardView>(R.id.parent_layout)
    }
}


