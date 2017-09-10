package me.giacoppo.examples.kotlin.mvp.ui.callbacks

import android.view.View

/**
 * Created by Peppe on 10/09/2017.
 */
interface ClickListener<T> {
    fun onClick(v: View, item: T): Unit
}