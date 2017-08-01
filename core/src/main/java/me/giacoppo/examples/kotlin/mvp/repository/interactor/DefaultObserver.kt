package me.giacoppo.examples.kotlin.mvp.repository.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Empty Implementation
 */
open class DefaultObserver<T>: DisposableObserver<T>() {
    override fun onNext(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}