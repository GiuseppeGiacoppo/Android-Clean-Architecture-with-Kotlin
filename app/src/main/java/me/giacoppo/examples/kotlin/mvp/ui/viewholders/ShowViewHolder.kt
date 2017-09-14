package me.giacoppo.examples.kotlin.mvp.ui.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_show.view.*
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show


class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Show, idx: Int, clickListener: (View, Show) -> Unit) {
        with(itemView) {
            val bgColor: Int

            if (idx % 2 == 0)
                bgColor = R.color.primary_light_bg
            else
                bgColor = R.color.secondary_light_bg

            setBackgroundResource(bgColor)

            name.setText(item.title)
            short_desc.setText(item.description)
            Glide.with(cover.context).load(item.posterUrl).into(cover)

            setOnClickListener({ v -> clickListener.invoke(v, item) })
        }
    }

}