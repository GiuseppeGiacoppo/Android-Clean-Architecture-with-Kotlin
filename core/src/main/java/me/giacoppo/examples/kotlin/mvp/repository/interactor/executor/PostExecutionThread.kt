package me.giacoppo.examples.kotlin.mvp.repository.interactor.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler(): Scheduler
}