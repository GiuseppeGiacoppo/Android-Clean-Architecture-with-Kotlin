package me.giacoppo.examples.kotlin.mvp.repository.interactor

import io.reactivex.Observable
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.repository.ShowsRepository
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.PostExecutionThread
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.ThreadExecutor

/**
 * Created by Peppe on 17/06/2017.
 */
class GetPopularTVShows: UseCase<List<Show>,Unit> {
    private val repository: ShowsRepository

    constructor(repository: ShowsRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread): super(threadExecutor,postExecutionThread){
        this.repository = repository
    }

    override fun buildUseCaseObservable(params: Unit): Observable<List<Show>> {
        return repository.populars();
    }

}