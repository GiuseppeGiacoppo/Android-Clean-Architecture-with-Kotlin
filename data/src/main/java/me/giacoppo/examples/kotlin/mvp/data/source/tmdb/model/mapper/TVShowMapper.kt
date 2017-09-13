package me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.mapper

import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.TVShow

class TVShowMapper: (TVShow) -> Show {
    override fun invoke(model: TVShow): Show {
        return Show(model.id,model.name!!,model.overview!!, model.originalLanguage!!,"https://image.tmdb.org/t/p/w500/"+model.backdropPath!!, "https://image.tmdb.org/t/p/w500/"+model.posterPath!!)
    }
}