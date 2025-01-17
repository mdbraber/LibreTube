package com.github.libretube.ui.fragments.tv

import android.os.Bundle
import android.view.View
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.VerticalGridPresenter

class TrendingFragment : VerticalGridSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGrid()
        loadContent()
    }

    private fun setupGrid() {
        val gridPresenter = VerticalGridPresenter().apply {
            numberOfColumns = 4
        }
        gridPresenter.setOnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            // Handle video click
        }

        setGridPresenter(gridPresenter)
    }

    private fun loadContent() {
        val adapter = ArrayObjectAdapter(VideoCardPresenter())
        // TODO: Add your trending videos
        // adapter.add(videoItem)
        this.adapter = adapter
    }
}