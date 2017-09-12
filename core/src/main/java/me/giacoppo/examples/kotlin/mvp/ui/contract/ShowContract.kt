package me.giacoppo.examples.kotlin.mvp.ui.contract

import me.giacoppo.examples.kotlin.mvp.bean.Show

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