package me.giacoppo.examples.kotlin.mvp.ui

import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.repository.interactor.DefaultObserver
import me.giacoppo.examples.kotlin.mvp.repository.interactor.GetPopularTVShows
import me.giacoppo.examples.kotlin.mvp.ui.contract.PopularContract

/**
 * Created by Peppe on 30/07/2017.
 */
class PopularPresenter(private val view: PopularContract.View, private val getPopularTVShowsUseCase: GetPopularTVShows) : PopularContract.Presenter {
    override fun presentShows(results: List<Show>) {
        if (results.isEmpty())
            view.showNoResults()
        else
            view.showResults(results)
    }

    override fun findPopularShows() {
        view.showLoader();
        getPopularTVShowsUseCase.execute(PopularTVShowsObserver(this), null)
    }

    private class PopularTVShowsObserver(private val presenter: PopularPresenter) : DefaultObserver<List<Show>>() {
        override fun onNext(t: List<Show>) {
            presenter.presentShows(t)
        }

        override fun onError(e: Throwable) {
            presenter.view.showError()
        }
    }
}