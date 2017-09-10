package me.giacoppo.examples.kotlin.mvp.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.executor.UIThread
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBRetrofitService
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBShowsRepository
import me.giacoppo.examples.kotlin.mvp.repository.interactor.GetShow
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.JobExecutor
import me.giacoppo.examples.kotlin.mvp.ui.contract.ShowContract

class DetailActivity : Activity(), ShowContract.View {
    val SHOW_ID: String by lazy { SHOW_ID }

    private lateinit var presenter: ShowContract.Presenter

    private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var desc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getShowUseCase = GetShow(
                TMDBShowsRepository(TMDBRetrofitService.instance.getService()),
                JobExecutor.instance,
                UIThread.instance)

        presenter = ShowPresenter(this, getShowUseCase)

        poster = findViewById(R.id.poster)
        title = findViewById(R.id.title)
        desc = findViewById(R.id.description)

        presenter.findShow(intent.extras.getInt(SHOW_ID))
    }

    companion object {
        val SHOW_ID = "SHOW_ID"
        fun getIntent(ctx: Context, item: Show): Intent {
            val i = Intent(ctx, DetailActivity::class.java)
            i.putExtra(SHOW_ID, item.id)
            return i
        }
    }


    override fun showTVShow(item: Show) {
        title.setText(item.title)
        desc.setText(item.description)
    }

    override fun showLoading() {

    }

    override fun showError() {
        Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
    }

}
