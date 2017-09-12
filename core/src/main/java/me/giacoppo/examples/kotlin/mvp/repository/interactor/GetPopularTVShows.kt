package me.giacoppo.examples.kotlin.mvp.repository.interactor

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.repository.ShowsRepository
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.PostExecutionThread
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.ThreadExecutor

class GetPopularTVShows(private val repository: ShowsRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : UseCase<List<Show>, Void?>(threadExecutor, postExecutionThread) {
    override fun buildUseCaseObservable(params: Void?): Observable<List<Show>> {
        return repository.populars()
    }
}