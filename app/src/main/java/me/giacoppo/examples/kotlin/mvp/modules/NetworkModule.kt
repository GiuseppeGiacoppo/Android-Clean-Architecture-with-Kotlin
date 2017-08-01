package me.giacoppo.examples.kotlin.mvp.modules

import okhttp3.OkHttpClient

/**
 * Created by Peppe on 30/07/2017.
 */
class NetworkModule {

    fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build();
    }
}