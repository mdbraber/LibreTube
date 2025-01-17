package com.github.libretube.ui.fragments.tv

import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class SubscriptionsFragment : BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = "Subscriptions"
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        adapter = rowsAdapter

        loadSubscriptions(rowsAdapter)
    }

    private fun loadSubscriptions(rowsAdapter: ArrayObjectAdapter) {
        val cardPresenter = VideoCardPresenter()
        // TODO: Load subscribed channels
        // For each channel:
        // val channelAdapter = ArrayObjectAdapter(cardPresenter)
        // rowsAdapter.add(ListRow(HeaderItem(channelName), channelAdapter))
    }
}