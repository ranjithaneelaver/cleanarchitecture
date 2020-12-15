package com.cleanarchimpl.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cleanarchimpl.R
import com.cleanarchimpl.presentar.viewmodel.DataViewModel
import com.cleanarchimpl.domain.interfacelist.GetData
import com.cleanarchimpl.domain.module.MovieData


class MovieListAdapter(var list: List<MovieData>, var context: Context, var listener: GetData) :
    RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var image: ImageView = view.findViewById(R.id.image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_movie_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = list.get(position)
        val viewModel = DataViewModel(item)
        holder.title.setText(viewModel.title)

        Glide.with(context).load(viewModel.image).into(holder.image)

        holder.image.setOnClickListener {
            listener.getData(item);
        }

    }

}