package com.github.libretube.ui.fragments.tv

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class HomeFragment : BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup header
        title = "Home"

        // Create rows adapter
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        adapter = rowsAdapter

        // Add content rows (trending, recent, etc)
        loadContent(rowsAdapter)
    }

    private fun loadContent(rowsAdapter: ArrayObjectAdapter) {
        val cardPresenter = VideoCardPresenter()

        // Trending row
        val trendingAdapter = ArrayObjectAdapter(cardPresenter)
        // TODO: Add your video items here
        // trendingAdapter.add(videoItem)
        rowsAdapter.add(ListRow(HeaderItem("Trending"), trendingAdapter))

        // Recent row
        val recentAdapter = ArrayObjectAdapter(cardPresenter)
        rowsAdapter.add(ListRow(HeaderItem("Recent"), recentAdapter))
    }
}