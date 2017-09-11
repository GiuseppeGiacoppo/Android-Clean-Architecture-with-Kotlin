package me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.mapper

import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.TVShow

/**
 * Created by Peppe on 18/06/2017.
 */
object TVShowMapper {
    fun transform(model: TVShow): Show {
            return Show(model.id!!,model.name!!,model.overview!!, model.originalLanguage!!,"https://image.tmdb.org/t/p/w500/"+model.backdropPath!!, "https://image.tmdb.org/t/p/w500/"+model.posterPath!!)
    }
}