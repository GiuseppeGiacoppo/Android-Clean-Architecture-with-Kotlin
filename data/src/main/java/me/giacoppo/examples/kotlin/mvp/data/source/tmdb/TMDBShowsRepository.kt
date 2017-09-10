package me.giacoppo.examples.kotlin.mvp.data.source.tmdb

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.mapper.TVShowMapper
import me.giacoppo.examples.kotlin.mvp.repository.ShowsRepository

/**
 * Implementation of ShowsRepository based on Retrofit
 *
 * @author Giuseppe Giacoppo
 */
class TMDBShowsRepository(private val source: TMDBDataSource) : ShowsRepository{

    override fun populars(): Observable<List<Show>> {
        return source.getPopularShows().map{it.results!!.map(TVShowMapper::transform)}
    }

    override fun show(id: Int): Observable<Show> {
        return source.getShow(id).map(TVShowMapper::transform)
    }
}