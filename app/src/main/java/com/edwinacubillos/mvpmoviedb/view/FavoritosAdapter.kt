package com.edwinacubillos.mvpmoviedb.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.mvpmoviedb.R
import com.edwinacubillos.mvpmoviedb.model.MovieEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

class FavoritosAdapter(movieList: ArrayList<MovieEntity>) :
    RecyclerView.Adapter<FavoritosAdapter.MoviesViewHolder>() {

    private var movieList = ArrayList<MovieEntity>()

    init {
        this.movieList = movieList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.setMovie(movie)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var movie: MovieEntity? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setMovie(movie: MovieEntity) {
            this.movie = movie
            val url_image = "https://image.tmdb.org/t/p/w500"
            itemView.tv_title.text = movie.title
            itemView.tv_releaseDate.text = movie.releaseDate
            itemView.tv_voteAverage.text = movie.voteAverage.toString()
            Picasso.get().load(url_image + movie.posterPath).into(itemView.iv_picture)
        }

        override fun onClick(v: View?) {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("movie", movie)
            itemView.context.startActivity(intent)
        }
    }
}