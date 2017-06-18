package me.giacoppo.examples.kotlin.mvp.repository

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.bean.Show

/**
 * Created by Peppe on 17/06/2017.
 */
interface ShowsRepository {
    fun populars(): Observable<List<Show>>
    fun show(id: String): Observable<Show>
}