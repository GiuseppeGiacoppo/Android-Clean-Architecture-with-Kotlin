package me.giacoppo.examples.kotlin.mvp.repository

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.bean.Show

interface ShowsRepository {
    fun populars(): Observable<List<Show>>
    fun show(id: Int): Observable<Show>
}