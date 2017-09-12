package me.giacoppo.examples.kotlin.mvp.data.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.PostExecutionThread

class UIThread : PostExecutionThread {
    private object Holder {
        var instance = UIThread()
    }

    companion object {
        val instance: UIThread by lazy {Holder.instance}
    }

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}