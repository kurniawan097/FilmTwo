package com.cuursoft.filmsubmittwo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_movie.*

/**
 * A simple [Fragment] subclass.
 */
class TvMovieFragment : Fragment() {
    companion object {
        private val list = ArrayList<TvMovie>()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvmovie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_movie.setHasFixedSize(true)

        list.addAll(getListMovie())
        showRecyclerList()
    }

    fun getListMovie(): ArrayList<TvMovie> {
        val dataJudul = resources.getStringArray(R.array.data_judul2)
        val dataDesk = resources.getStringArray(R.array.data_deskripsi2)
        val dataFoto = resources.getStringArray(R.array.data_foto2)
        val dataSkor = resources.getStringArray(R.array.data_skor2)
        val dataRilis = resources.getStringArray(R.array.data_rilis2)


        val listTvMovie = ArrayList<TvMovie>()
        for (position in dataJudul.indices) {
            val tvmovie = TvMovie(
                dataJudul[position],
                dataDesk[position],
                dataFoto[position],
                dataSkor[position],
                dataRilis[position]
            )
            listTvMovie.add(tvmovie)
        }

        return listTvMovie
    }

    fun showRecyclerList() {
        tv_movie.layoutManager = LinearLayoutManager(activity)
        val tvMovieAdapter = TvMovieAdapter(list)
        tv_movie.adapter = tvMovieAdapter
    }


}
