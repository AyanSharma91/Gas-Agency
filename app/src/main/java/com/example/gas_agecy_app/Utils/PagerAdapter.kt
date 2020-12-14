package com.example.gas_agecy_app.Utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.gas_agecy_app.Models.sliderImages
import com.example.gas_agecy_app.R

import com.squareup.picasso.Picasso


class PagerAdapter(val context: Context, val arr: ArrayList<sliderImages>, viewPager2: ViewPager2) : RecyclerView.Adapter<PagerAdapter.DashboardViewHolder>()
{

    var mViewPager : ViewPager2

    init {
        mViewPager=viewPager2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_page_view_pager, parent, false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arr.size
    }





    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = arr[position]
        // holder.bookImage.setImageResource(book.bookImage)



        Picasso.get().load(book.photos).into(holder.imgBookImage)
        if(position==arr.size-1)
        {
            mViewPager.post(runnable)
        }





    }


    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val imgBookImage = view.findViewById<ImageView>(R.id.photos)

    }

    var runnable = object  :Runnable{
        override fun run() {
            arr.addAll(arr)
            notifyDataSetChanged()
        }
    }

}



