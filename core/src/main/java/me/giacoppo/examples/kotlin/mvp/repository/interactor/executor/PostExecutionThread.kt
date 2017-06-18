package me.giacoppo.examples.kotlin.mvp.repository.interactor.executor

import io.reactivex.Scheduler

/**
 * Created by Peppe on 17/06/2017.
 */
interface PostExecutionThread {
    fun getScheduler(): Scheduler
}