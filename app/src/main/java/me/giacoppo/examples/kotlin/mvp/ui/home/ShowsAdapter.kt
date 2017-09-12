package me.giacoppo.examples.kotlin.mvp.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_show.view.*
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.ui.callbacks.ClickListener

class ShowsAdapter(private val clickListener: ClickListener<Show>) : RecyclerView.Adapter<ShowsAdapter.ViewHolder>() {
    private val shows: MutableList<Show> by lazy { ArrayList<Show>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Show, idx: Int, clickListener: ClickListener<Show>) {
            if (idx % 2 == 0)
                itemView.setBackgroundResource(R.color.primary_light_bg)
            else
                itemView.setBackgroundResource(R.color.secondary_light_bg)

            itemView.name.setText(item.title)
            itemView.short_desc.setText(item.description)
            Glide.with(itemView.cover.context).load(item.posterUrl).into(itemView.cover)

            itemView.setOnClickListener({v -> clickListener.onClick(v,item)})
        }

    }
}