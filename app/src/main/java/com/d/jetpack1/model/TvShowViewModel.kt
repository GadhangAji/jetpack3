package com.d.jetpack1.model

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.d.jetpack1.data.MovieEntity
import com.d.jetpack1.utils.DataDummy

class TvShowViewModel : ViewModel(){
    fun getTvShow(): ObservableArrayList<MovieEntity> {
        val title = DataDummy.title_tvshow
        val image = DataDummy.img_tvshow
        val overview = DataDummy.tvshow_overview
        val data = ObservableArrayList<MovieEntity>()
        title.forEachIndexed { index, s ->
            val resourceId = image[index]
            val model = MovieEntity(s, resourceId, overview[index])
            data.add(model)
        }
        return data
    }
}