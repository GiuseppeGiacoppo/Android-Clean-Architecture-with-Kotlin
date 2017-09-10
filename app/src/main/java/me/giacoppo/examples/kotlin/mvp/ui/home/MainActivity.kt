package me.giacoppo.examples.kotlin.mvp.ui.home

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.executor.UIThread
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBRetrofitService
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBShowsRepository
import me.giacoppo.examples.kotlin.mvp.repository.interactor.GetPopularTVShows
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.JobExecutor
import me.giacoppo.examples.kotlin.mvp.ui.DetailActivity
import me.giacoppo.examples.kotlin.mvp.ui.PopularPresenter
import me.giacoppo.examples.kotlin.mvp.ui.callbacks.ClickListener
import me.giacoppo.examples.kotlin.mvp.ui.contract.PopularContract


class MainActivity : Activity(), PopularContract.View, ClickListener<Show> {
    private lateinit var showsList: RecyclerView
    private lateinit var message: TextView
    private lateinit var progress: View

    private lateinit var presenter: PopularContract.Presenter
    private lateinit var adapter: ShowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getPopularUseCase = GetPopularTVShows(
                TMDBShowsRepository(TMDBRetrofitService.instance.getService()),
                JobExecutor.instance,
                UIThread.instance)

        //init presenter
        presenter = PopularPresenter(this, getPopularUseCase)

        //init views
        showsList = findViewById(R.id.result)
        message = findViewById(R.id.message)
        progress = findViewById(R.id.progress)

        adapter = ShowsAdapter(this)
        showsList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        showsList.adapter = adapter

        //query
        presenter.findPopularShows()
    }

    override fun showResults(results: List<Show>) {
        adapter.addAll(results)
        setState(1)
    }

    override fun showNoResults() {
        adapter.clear()
        message.setText("No shows found")
        setState(2)
    }

    override fun showLoader() {
        setState(0)
    }

    override fun showError() {
        message.setText("Error finding shows")
        setState(2)
    }

    override fun onClick(v: View, item: Show) {
        startActivity(DetailActivity.getIntent(this, item))
    }

    /**
     * 1: loading
     * 2: show results
     * 3: show a message
     */
    private fun setState(state: Int) {
        when (state) {
            0 -> {
                progress.visibility = View.VISIBLE
                message.visibility = View.GONE
                showsList.visibility = View.GONE
            }

            1 -> {
                progress.visibility = View.GONE
                message.visibility = View.GONE
                showsList.visibility = View.VISIBLE
            }

            2 -> {
                progress.visibility = View.GONE
                message.visibility = View.VISIBLE
                showsList.visibility = View.GONE
            }
        }
    }
}
