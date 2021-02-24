package com.d.jetpack1.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieViewModelTest{
    private lateinit var viewModel: MovieViewModel
    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val courseEntities = viewModel.getMovie()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities.size)
    }
}