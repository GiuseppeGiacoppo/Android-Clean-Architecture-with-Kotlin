package me.giacoppo.examples.kotlin.mvp.ui

import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.repository.interactor.DefaultObserver
import me.giacoppo.examples.kotlin.mvp.repository.interactor.GetShow
import me.giacoppo.examples.kotlin.mvp.ui.contract.ShowContract

/**
 * Created by Peppe on 10/09/2017.
 */
class ShowPresenter(private val view: ShowContract.View, private val getShowUseCase: GetShow): ShowContract.Presenter {

    override fun findShow(id: Int) {
        getShowUseCase.execute(ShowObserver(this), GetShow.Params(id))
    }

    private class ShowObserver(val presenter: ShowPresenter): DefaultObserver<Show>() {
        override fun onNext(t: Show) {
            presenter.view.showTVShow(t)
        }

        override fun onError(e: Throwable) {
            presenter.view.showError()
        }
    }
}