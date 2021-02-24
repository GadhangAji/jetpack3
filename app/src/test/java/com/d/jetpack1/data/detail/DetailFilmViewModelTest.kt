package com.d.jetpack1.data.detail

import com.d.jetpack1.data.MovieEntity
import com.d.jetpack1.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailFilmViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private lateinit var movieEntity: MovieEntity

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel()
        movieEntity = MovieEntity(
            DataDummy.title_movies[1],
            DataDummy.img_movie[1],
            DataDummy.movie_overview[1]
        )
    }

    @Test
    fun getMoviesEntity() {
        viewModel.movieEntity = movieEntity
        val model = viewModel.movieEntity
        assertNotNull(model)
        assertEquals(movieEntity.img, model?.img)
        assertEquals(movieEntity.title, model?.title)
        assertEquals(movieEntity.overview, model?.overview)
    }
}