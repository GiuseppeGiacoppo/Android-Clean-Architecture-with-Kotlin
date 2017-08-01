package me.giacoppo.examples.kotlin.mvp.data.source.tmdb

import retrofit2.Retrofit

/**
 * Provider of TMDBDataSource
 *
 * @author Giuseppe Giacoppo
 */
class TMDBRetrofitService {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("")
                .build()
    }
    fun getService(): TMDBDataSource {
        return getRetrofit().create(TMDBDataSource::class.java)
    }
}