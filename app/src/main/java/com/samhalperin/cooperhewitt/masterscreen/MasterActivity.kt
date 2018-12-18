package com.samhalperin.cooperhewitt.masterscreen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.GridLayoutManager

import com.samhalperin.cooperhewitt.aboutscreen.AboutActivity
import com.samhalperin.cooperhewitt.R
import com.samhalperin.cooperhewitt.application.CooperHewittApplication
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject
import com.samhalperin.cooperhewitt.data.repository.Repository
import com.samhalperin.cooperhewitt.application.BaseActivity
import com.samhalperin.cooperhewitt.detailscreen.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList

class MasterActivity : BaseActivity(), AdapterView.OnItemSelectedListener,
        MasterContract.View, View.OnClickListener, PageLoader{

    private lateinit var presenter: MasterPresenter
    private lateinit var adapter: ArtAdapter
    private lateinit var artisticPeriodCodesArray: IntArray
    private lateinit var layoutManager: GridLayoutManager
    private lateinit var endlessScrollListener: EndlessScrollListener

    //region Implement Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup(R.layout.activity_main)

        presenter = MasterPresenter(this, Repository(this))
        adapter = ArtAdapter(this, this, ArrayList())
        artisticPeriodCodesArray = resources.getIntArray(R.array.period_codes_array)
        layoutManager = GridLayoutManager(this, 2)
        endlessScrollListener = EndlessScrollListener(layoutManager,
                CooperHewittApplication.EndlessScrollVisibilityThreshold, this)

        period_spinner.onItemSelectedListener = this
        rv.layoutManager = layoutManager
        rv.adapter = adapter
        rv.setOnScrollListener(endlessScrollListener)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> presenter.navigateToAboutActivity()
        }
        return true
    }
    //endregion

    //region Implement OnItemSelectedListener for Artistic Period Selection Spinner
    override fun onItemSelected(parent: AdapterView<*>, view: View,
                                pos: Int, id: Long) {
        presenter.selectArtisticPeriod(artisticPeriodCodesArray[pos])
        presenter.loadPage(0, true)
    }

    override fun onNothingSelected(adapterView: AdapterView<*>) {}
    //endregion

    //region Implement MasterContract.View Interface
    override fun displayProgressBar() {
        pb.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        pb.visibility = View.GONE
    }

    override fun navigateToAboutActivity() {
        startActivity(Intent(this, AboutActivity::class.java))
    }

    override fun displayPage(objects: List<SearchObject>) { adapter.addAll(objects)
        adapter.notifyDataSetChanged()
    }

    override fun clearResults() {
        adapter.clear()
    }

    override fun navigateToDetailActivity(id: String) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra(CooperHewittApplication.EXTRA_ITEM_ID_KEY, id)
        startActivity(i)
    }
    //endregion


    /* Implement View.OnClick Listener for RV items */
    override fun onClick(view: View) {
        var id = (view as SquareImageViewWithId).mId
        if (id != null) {
            presenter.navigateToDetailActivity(id)
        }
    }
    //endregion

    /* Implement PageLoader interface*/
    override fun loadPage(currentPage: Int, clear:Boolean) {
        presenter.loadPage(currentPage, clear)
    }
}

interface PageLoader {
    fun loadPage(currentPage: Int, clear: Boolean)
}