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
import com.d.jetpack1.model.TvShowViewModel
import com.d.jetpack1.utils.DetailMovie
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(TvShowViewModel::class.java)
        adapter = MovieAdapter(viewModel.getTvShow(), this::goToDetailMovies)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_tv_show.layoutManager = LinearLayoutManager(context)
        rv_tv_show.setHasFixedSize(true)
        rv_tv_show.adapter = adapter
    }

    private fun goToDetailMovies(model: MovieEntity) {
        startActivity(requireActivity() DetailMovie (model))
    }

}