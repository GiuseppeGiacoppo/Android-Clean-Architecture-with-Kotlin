package me.giacoppo.examples.kotlin.mvp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import me.giacoppo.examples.kotlin.mvp.R
import me.giacoppo.examples.kotlin.mvp.bean.Show
import me.giacoppo.examples.kotlin.mvp.data.executor.UIThread
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBRetrofitService
import me.giacoppo.examples.kotlin.mvp.data.source.tmdb.TMDBShowsRepository
import me.giacoppo.examples.kotlin.mvp.repository.interactor.GetShow
import me.giacoppo.examples.kotlin.mvp.repository.interactor.executor.JobExecutor
import me.giacoppo.examples.kotlin.mvp.ui.contract.ShowContract

class DetailActivity : AppCompatActivity(), ShowContract.View {
    private lateinit var presenter: ShowContract.Presenter

    private lateinit var content: View
    private lateinit var progress : View
    private lateinit var message: TextView
    private lateinit var cover: ImageView
    private lateinit var desc: TextView

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getShowUseCase = GetShow(
                TMDBShowsRepository(TMDBRetrofitService.instance.getService()),
                JobExecutor.instance,
                UIThread.instance)

        presenter = ShowPresenter(this, getShowUseCase)

        content = findViewById(R.id.content)
        progress = findViewById(R.id.progress)
        message = findViewById(R.id.message)
        cover = findViewById(R.id.cover)
        desc = findViewById(R.id.description)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        presenter.findShow(intent.extras.getInt("SHOW_ID"))
    }

    companion object {
        fun getIntent(ctx: Context, item: Show): Intent {
            val i = Intent(ctx, DetailActivity::class.java)
            i.putExtra("SHOW_ID", item.id)
            return i
        }
    }

    override fun showTVShow(item: Show) {
        setTitle(item.title)
        desc.setText(item.description)
        Glide.with(cover.context).load(item.coverUrl).into(cover)

        setState(1)
    }

    override fun showLoading() {
        setState(0)
    }

    override fun showError() {
        Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
        setState(2)
    }


    /**
     * 0: loading
     * 1: show results
     * 2: show a message
     */
    private fun setState(state: Int) {
        when (state) {
            0 -> {
                progress.visibility = View.VISIBLE
                message.visibility = View.GONE
                content.visibility = View.GONE
            }

            1 -> {
                progress.visibility = View.GONE
                message.visibility = View.GONE
                content.visibility = View.VISIBLE
            }

            2 -> {
                progress.visibility = View.GONE
                message.visibility = View.VISIBLE
                content.visibility = View.GONE
            }
        }
    }
}
