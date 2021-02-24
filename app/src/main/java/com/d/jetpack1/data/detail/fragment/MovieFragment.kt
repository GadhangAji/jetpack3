package com.d.jetpack1.data.detail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.d.jetpack1.R
import com.d.jetpack1.adapter.MovieAdapter
import com.d.jetpack1.data.MovieEntity
import com.d.jetpack1.model.MovieViewModel
import com.d.jetpack1.utils.DetailMovie
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(MovieViewModel::class.java)
        adapter = MovieAdapter(viewModel.getMovie(), this::goToDetailMovies)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movie.layoutManager = LinearLayoutManager(context)
        rv_movie.setHasFixedSize(true)
        rv_movie.adapter = adapter
    }

    private fun goToDetailMovies(model: MovieEntity) {
        startActivity(requireActivity() DetailMovie (model))
    }
}