package com.d.jetpack1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.d.jetpack1.R
import com.d.jetpack1.data.MovieEntity
import com.d.jetpack1.utils.requestOption

class MovieAdapter (var data: MutableList<MovieEntity>, private var listener: (MovieEntity) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MoviesViewHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val model = data[position]
        holder.bind(model)
        holder.itemView.setOnClickListener {
            listener.invoke(model)
        }
    }

    class MoviesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        private val img_poster = binding.findViewById<ImageView>(R.id.img_poster)
        private val tv_item_title = binding.findViewById<TextView>(R.id.tv_item_title)
        fun bind(moviesEntity: MovieEntity) {
            Glide.with(binding.context)
                .load(moviesEntity.img)
                .apply(binding.context requestOption 5)
                .into(img_poster)
            tv_item_title.text = moviesEntity.title
        }
    }
}