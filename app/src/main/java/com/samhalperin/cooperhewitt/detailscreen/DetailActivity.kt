package com.samhalperin.cooperhewitt.detailscreen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.samhalperin.cooperhewitt.aboutscreen.AboutActivity
import com.samhalperin.cooperhewitt.application.CooperHewittApplication
import com.samhalperin.cooperhewitt.R
import com.samhalperin.cooperhewitt.application.BaseActivity
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject
import com.samhalperin.cooperhewitt.data.repository.Repository
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : BaseActivity(), DetailContract.View {
    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter= DetailPresenter(this, Repository(this))

        val objectId = intent?.extras?.getString(CooperHewittApplication.EXTRA_ITEM_ID_KEY)

        if (objectId != null) {
            presenter.loadDetailObject(objectId)
            share_fab.setOnClickListener {
                presenter.shareDetailObject(objectId)
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.action_about -> startActivity(Intent(this, AboutActivity::class.java))
        }
        return true
    }

    //region Implement DetailContract.View Interface
    override fun displayDetailObject(detailObject: DetailObject) {
        detail_view.displayDetailObject(detailObject)
    }

    override fun shareDetailObject(detailObject: DetailObject) {
        val link = detailObject.getObject().url
        val text = "$link (Brought to you by Moderne for Android)"
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(shareIntent)
    }
    //endregion

}
