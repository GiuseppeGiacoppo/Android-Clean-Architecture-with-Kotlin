package me.giacoppo.examples.kotlin.mvp.ui.callbacks

import android.view.View

interface ClickListener<T> {
    fun onClick(v: View, item: T)
}