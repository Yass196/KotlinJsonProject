package com.example.kotlinjsonproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinjsonproject.Model.Movie
import com.example.kotlinjsonproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class MovieAdapter(private val context : Context, private val MovieList : MutableList<Movie>):RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_movie_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
    return MovieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
   Picasso.get().load(MovieList[position].imageurl).into(holder.image)
        holder.txt_name.text = MovieList[position].name
        holder.txt_team.text = MovieList[position].team
        holder.txt_createdby.text = MovieList[position].createdby

    }
    

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
var image : ImageView
var txt_name : TextView
var txt_team : TextView
var txt_createdby : TextView
        init {
            image = itemView.image_movie
            txt_name = itemView.txt_name
            txt_team = itemView.txt_team
            txt_createdby = itemView.txt_createdby
        }
    }
}