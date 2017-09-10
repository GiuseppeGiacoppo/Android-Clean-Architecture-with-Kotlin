package me.giacoppo.examples.kotlin.mvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.executor.UIThread
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBRetrofitService
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBShowsRepository
import me.giacoppo.examples.kotlin.mvp.repository.interactor.GetPopularTVShows
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.JobExecutor
import me.giacoppo.examples.kotlin.mvp.ui.contract.PopularContract
import java.util.*


class MainActivity : AppCompatActivity(), PopularContract.View {
    private lateinit var text: TextView
    private lateinit var presenter : PopularContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getPopularUseCase = GetPopularTVShows(
                TMDBShowsRepository(TMDBRetrofitService.instance.getService()),
                JobExecutor.instance,
                UIThread.instance)

        presenter = PopularPresenter(this,getPopularUseCase)
        text = findViewById(R.id.result) as TextView

        presenter.findPopularShows()
    }

    override fun showResults(results: List<Show>) {
        text.setText(Arrays.deepToString(results.toTypedArray()))
    }

    override fun showNoResults() {
        text.setText("No results found")
    }

    override fun showLoader() {
        text.setText("Loading")
    }

    override fun showError() {
        text.setText("Error finding shows")
    }
}
