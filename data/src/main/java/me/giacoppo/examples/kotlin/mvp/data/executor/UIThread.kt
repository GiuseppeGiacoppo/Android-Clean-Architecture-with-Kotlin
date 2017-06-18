package me.giacoppo.examples.kotlin.mvp.repository.interactor.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers


/**
 * Created by Peppe on 17/06/2017.
 */
class UIThread : PostExecutionThread {
    private var instance : UIThread? = null

    private constructor()

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    fun getInstance() : PostExecutionThread {
        if (instance == null)
            instance = UIThread()

        return instance as PostExecutionThread
    }
}