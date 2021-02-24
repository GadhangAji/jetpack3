package com.d.jetpack1.model

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.d.jetpack1.data.MovieEntity
import com.d.jetpack1.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovie(): ObservableArrayList<MovieEntity> {
        val title = DataDummy.title_movies
        val image = DataDummy.img_movie
        val overview = DataDummy.movie_overview
        val data = ObservableArrayList<MovieEntity>()
        title.forEachIndexed { index, s ->
            val resourceId = image[index]
            val model = MovieEntity(s, resourceId, overview[index])
            data.add(model)
        }
        return data
    }
}