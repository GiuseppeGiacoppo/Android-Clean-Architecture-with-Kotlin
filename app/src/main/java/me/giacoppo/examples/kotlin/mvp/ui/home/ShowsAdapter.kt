package me.giacoppo.examples.kotlin.mvp.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.ui.viewholders.ShowViewHolder

class  ShowsAdapter(private val clickListener: (View, Show) -> Unit) : RecyclerView.Adapter<ShowViewHolder>() {
    private val shows: MutableList<Show> by lazy { ArrayList<Show>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        return ShowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false))
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        holder.bind(shows[position], position, clickListener)
    }

    fun addAll(items: List<Show>) {
        shows.clear()
        shows.addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        shows.clear()
        notifyDataSetChanged()
    }
}