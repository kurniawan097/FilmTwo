package com.cuursoft.filmsubmittwo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_movie.view.*
import me.biubiubiu.justifytext.library.JustifyTextView

class TvDetaiMovie : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tvdetai_movie)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvJudul: TextView = findViewById(R.id.tv_item_judul)
        val tvDesk: JustifyTextView = findViewById(R.id.tv_item_deskripsi)
        val tvFoto: ImageView = findViewById(R.id.img_item_foto)
        val tvSkor: TextView = findViewById(R.id.tv_item_skor)
        val tvRilis: TextView = findViewById(R.id.tv_item_rilis)


        val tvmovie = intent.getParcelableExtra<TvMovie>(EXTRA_MOVIE)
        //val foto = movie.foto
        val judul = tvmovie.judul2
        val deskripsi = tvmovie.deskripsi2
        val skor= tvmovie.skor2
        val rilis = tvmovie.rilis2

        Glide.with(this)
            .load(tvmovie.foto2)
            .apply(RequestOptions().override(150, 230))
            .into(tvFoto)
        tvJudul.text = judul
        tvDesk.text = deskripsi
        tvSkor.text = skor
        tvRilis.text = rilis

    }

}