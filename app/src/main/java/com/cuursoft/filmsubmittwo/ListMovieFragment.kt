package com.cuursoft.filmsubmittwo


import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_movie.*



/**
 * A simple [Fragment] subclass.
 */
class ListMovieFragment : Fragment() {
    companion object {
        private val list = ArrayList<Movie>()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movie, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_movie.setHasFixedSize(true)

        list.addAll(getListMovie())
        showRecyclerList()


    }

    fun getListMovie(): ArrayList<Movie> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataDesk = resources.getStringArray(R.array.data_deskripsi)
        val dataFoto = resources.getStringArray(R.array.data_foto)
        val dataSkor = resources.getStringArray(R.array.data_skor)
        val dataRilis = resources.getStringArray(R.array.data_rilis)


        val listMovie = ArrayList<Movie>()
        for (position in dataJudul.indices) {
            val movie = Movie(
                dataJudul[position],
                dataDesk[position],
                dataFoto[position],
                dataSkor[position],
                dataRilis[position]
            )
            listMovie.add(movie)
        }


        return listMovie

    }


    fun showRecyclerList() {
        tv_movie.layoutManager = LinearLayoutManager(activity)
        val listMovieAdapter = ListMovieAdapter(list)
        tv_movie.adapter = listMovieAdapter
    }
}
