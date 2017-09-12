package me.giacoppo.examples.kotlin.mvp.repository.interactor

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.repository.ShowsRepository
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.PostExecutionThread
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.ThreadExecutor

class GetShow(private val repository: ShowsRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : UseCase<Show, GetShow.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: GetShow.Params): Observable<Show> {
        return repository.show(params.id)
    }

    class Params( val id: Int)
}