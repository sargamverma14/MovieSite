package com.example.api.adaptorviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapi.R
import com.example.movieapi.retrofit.Result
import com.squareup.picasso.Picasso

class rvAdaptor(val context : Context, private val list: List<Result>) : RecyclerView.Adapter<rvAdaptor.MyViewHolder>() {

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val img:ImageView = itemview.findViewById(R.id.img)
        val title:TextView = itemview.findViewById(R.id.movie_title)
        val date:TextView = itemview.findViewById(R.id.movie_release_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rvlayout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = list[position]

        val img = list.backdrop_path
        Picasso.with(context)
            .load(img)
            .into(holder.img)
        holder.title.text = list.title
        holder.date.text = list.release_date


    }




}