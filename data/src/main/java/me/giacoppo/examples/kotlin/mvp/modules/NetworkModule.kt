package me.giacoppo.examples.kotlin.mvp.modules

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class NetworkModule {
    private object Holder {
        private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        private val tmdbInterceptor: TMDBInterceptor
        init {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            tmdbInterceptor = TMDBInterceptor()
        }

        val client = OkHttpClient.Builder()
                .addInterceptor(tmdbInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
    }

    companion object {
        val client: OkHttpClient by lazy { Holder.client }
    }

    private class TMDBInterceptor : Interceptor {
        val API_KEY_PARAM = "api_key"
        val API_KEY = "164690508d8fb0ef9183587d7ff0bd51"

        override fun intercept(chain: Interceptor.Chain?): Response {
            val originalRequest = chain!!.request()
            val originalUrl = originalRequest.url()
            val url = originalUrl.newBuilder().addQueryParameter(API_KEY_PARAM, API_KEY).build()

            val requestBuilder = originalRequest.newBuilder().url(url)
            val request = requestBuilder.build()
            return chain.proceed(request)
        }
    }
}