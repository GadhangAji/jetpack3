package com.d.jetpack1.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest{
    private lateinit var viewModel: TvShowViewModel
    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val courseEntities = viewModel.getTvShow()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities.size)
    }
}