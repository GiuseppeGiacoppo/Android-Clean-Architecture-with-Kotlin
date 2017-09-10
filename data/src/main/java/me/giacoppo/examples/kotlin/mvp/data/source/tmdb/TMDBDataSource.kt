package me.giacoppo.examples.kotlin.mvp.data.source.tmdb

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.TVResults
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.model.TVShow
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * TMDB Api Interface
 *
 * @author Giuseppe Giacoppo
 */
interface TMDBDataSource {
    @GET("tv/popular")
    fun getPopularShows(): Observable<TVResults>

    @GET("tv/{tv_id}")
    fun getShow(@Path("tv_id") id: String): Observable<TVShow>
}