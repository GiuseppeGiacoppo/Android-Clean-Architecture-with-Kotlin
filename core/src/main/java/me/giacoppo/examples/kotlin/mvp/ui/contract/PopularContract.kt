package me.giacoppo.examples.kotlin.mvp.ui.contract

import me.giacoppo.examples.kotlin.mvp.bean.Show

/**
 * Contract used to find and show popular shows
 *
 * @author Giuseppe Giacoppo
 */
interface PopularContract {
    interface View {
        fun showResults(results: List<Show>)
        fun showNoResults()
        fun showLoader()
        fun showError()
    }

    interface Presenter {
        fun findPopularShows()
        fun presentShows(results: List<Show>)
    }
}