package com.edwinacubillos.mvpmoviedb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.mvpmoviedb.R
import com.edwinacubillos.mvpmoviedb.model.MovieEntity
import com.edwinacubillos.mvpmoviedb.model.Repository
import kotlinx.android.synthetic.main.fragment_favorites.view.*

class FavoritesFragment : Fragment() {

    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_favorites, container, false)

        root.recyclerView.setHasFixedSize(true)
        root.recyclerView.layoutManager = LinearLayoutManager(
            activity!!.applicationContext,
            RecyclerView.VERTICAL,
            false
        )

        getMovies()
        return root
    }

    private fun getMovies() {
        val repository = Repository()
        repository.getFavoritesMovies().observe(this, Observer{
            root.recyclerView.adapter = FavoritosAdapter(it as ArrayList<MovieEntity>)
        })
    }
}