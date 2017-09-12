package me.giacoppo.examples.kotlin.mvp.data.source.tmdb

import me.giacoppo.examples.kotlin.mvp.modules.NetworkModule
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Provider of TMDBDataSource
 *
 * @author Giuseppe Giacoppo
 */
class TMDBRetrofitService {

    private object Holder {
        val instance = TMDBRetrofitService()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(NetworkModule.client)
                .build()
    }

    fun getService(): TMDBDataSource {
        return instance.getRetrofit().create(TMDBDataSource::class.java)
    }

    companion object {
        val instance: TMDBRetrofitService by lazy { Holder.instance }
    }
}