package me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.mapper

import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.TVShow

class TVShowMapper : (TVShow) -> Show {
    override fun invoke(model: TVShow): Show {
        with(model) {
            return Show(id, name ?: "", overview ?: "", originalLanguage ?: "", "https://image.tmdb.org/t/p/w500/" + (backdropPath ?: ""), "https://image.tmdb.org/t/p/w500/" + (posterPath ?: ""))
        }
    }
}