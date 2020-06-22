package com.cuursoft.filmsubmittwo


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*


class ListMovieAdapter : RecyclerView.Adapter<ListMovieAdapter.CardViewViewHolder> {
    private var movie: Movie? = null
    private var lisMovies: ArrayList<Movie>? = null
    val listMovies: ArrayList<Movie>?
        get() = lisMovies

    constructor(list: ArrayList<Movie>?) {
        lisMovies = list
    }

    constructor(movie: Movie) {
        this.movie = movie
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CardViewViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_movie, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CardViewViewHolder,
        position: Int
    ) {
        val movie: Movie = lisMovies!![position]
        Glide.with(holder.itemView.context)
            .load(movie.foto)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPoster)
        holder.tvTitle.text = movie.judul
        holder.tvRuntime.text = movie.deskripsi
    }

    override fun getItemCount(): Int {
        return lisMovies!!.size
    }

    inner class CardViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var imgPoster: ImageView
        var tvTitle: TextView
        var tvRuntime: TextView
        override fun onClick(view: View) {
            val position = adapterPosition
            val movie: Movie = listMovies!![position]

            val intent = Intent(itemView.context, DetailMovie::class.java)
            intent.putExtra(DetailMovie.EXTRA_MOVIE, movie)
            view.context.startActivity(intent)
        }

        init {
            imgPoster = itemView.findViewById(R.id.img_item_foto)
            tvTitle = itemView.findViewById(R.id.tv_item_judul)
            tvRuntime = itemView.findViewById(R.id.tv_item_deskripsi)
            itemView.setOnClickListener(this)
        }
    }
}