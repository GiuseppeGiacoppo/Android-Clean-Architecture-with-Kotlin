package me.giacoppo.examples.kotlin.mvp.data.source.tmdb

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.TVResults
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.TVShow
import retrofit2.http.GET

/**
 * TMDB Api Interface
 *
 * @author Giuseppe Giacoppo
 */
interface TMDBDataSource {
    @GET("")
    fun getPopularShows(): Observable<TVResults>

    @GET("")
    fun getShow(id: String): Observable<TVShow>
}