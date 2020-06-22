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


class TvMovieAdapter : RecyclerView.Adapter<TvMovieAdapter.CardViewViewHolder> {
    private var tvmovie: TvMovie? = null
    private var lisMovies: ArrayList<TvMovie>? = null
    val listMovies: ArrayList<TvMovie>?
        get() = lisMovies

    constructor(list: ArrayList<TvMovie>?) {
        lisMovies = list
    }

    constructor(tvmovie: TvMovie) {
        this.tvmovie = tvmovie
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CardViewViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_tvmovie, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CardViewViewHolder,
        position: Int
    ) {
        val tvmovie: TvMovie = lisMovies!![position]
        Glide.with(holder.itemView.context)
            .load(tvmovie.foto2)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPoster)
        holder.tvTitle.setText(tvmovie.judul2)
        holder.tvRuntime.setText(tvmovie.deskripsi2)
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
            val tvmovie: TvMovie = listMovies!![position]

            val intent = Intent(itemView.context, TvDetaiMovie::class.java)
            intent.putExtra(TvDetaiMovie.EXTRA_MOVIE, tvmovie)
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