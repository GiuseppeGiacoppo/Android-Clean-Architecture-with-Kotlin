package me.giacoppo.examples.kotlin.mvp.ui.contract

import me.giacoppo.examples.kotlin.mvp.bean.Show

/**
 * Created by Peppe on 10/09/2017.
 */
interface ShowContract {
    interface View {
        fun showTVShow(item: Show)
        fun showLoading()
        fun showError()
    }

    interface Presenter {
        fun findShow(id: Int)
    }
}