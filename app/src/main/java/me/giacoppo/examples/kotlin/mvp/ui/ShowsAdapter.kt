package me.giacoppo.examples.kotlin.mvp.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_show.view.*
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show

/**
 * Created by Peppe on 10/09/2017.
 */
class ShowsAdapter : RecyclerView.Adapter<ShowsAdapter.ViewHolder>() {
    private val shows: MutableList<Show> by lazy { ArrayList<Show>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shows[position])
    }

    fun addAll(items: List<Show>): Unit {
        shows.clear()
        shows.addAll(items)
        notifyDataSetChanged()
    }

    fun clear(): Unit {
        shows.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Show) = with(itemView) {
            itemView.name.setText(item.title)
        }

    }
}