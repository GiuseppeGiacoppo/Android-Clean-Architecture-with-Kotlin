package me.giacoppo.examples.kotlin.mvp.repository.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Empty Implementation
 */
open class DefaultObserver<T>: DisposableObserver<T>() {
    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {
    }

}