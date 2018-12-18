package com.samhalperin.cooperhewitt.masterscreen

import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessScrollListener(private val layoutManager: GridLayoutManager, private val visibleThreshold: Int, private val pageLoader:PageLoader) : RecyclerView.OnScrollListener() {
    private var previousTotal = 0
    private var loading = true
    internal var firstVisibleItem: Int = 0
    private var currentPage = 1

    override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(rv, dx, dy)

        firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (loading) {
            if (layoutManager.itemCount > previousTotal) {
                loading = false
                previousTotal = layoutManager.itemCount
            }
        } else {
            if (layoutManager.itemCount - rv.childCount <= firstVisibleItem + visibleThreshold) {
                currentPage++
                onLoadMore(currentPage)
                loading = true
            }
        }
    }

    fun onLoadMore(currentPage: Int) {
        Log.d("Endless Scroll", "fetching new page")
        pageLoader.loadPage(currentPage, false)
    }

}
