package com.github.libretube.ui.activities

// TvMainActivity.kt
import androidx.fragment.app.FragmentActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.libretube.R
import androidx.leanback.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.github.libretube.ui.fragments.tv.*

class TvMainActivity : FragmentActivity() {
    private lateinit var tabContainer: HorizontalGridView
    private lateinit var container: BrowseFrameLayout

    private val tabs = listOf(
        "Home", "Trending", "Subscriptions", "Library" // Match your app's sections
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_main)

        // Initialize views
        tabContainer = findViewById(R.id.tabContainer)
        container = findViewById(R.id.container)

        // Set up search and settings buttons
        findViewById<SearchOrbView>(R.id.search_button).apply {
            setOnClickListener {
                // Launch search
            }
            // Set initial focus
            requestFocus()
        }

        findViewById<SearchOrbView>(R.id.settings_button).setOnClickListener {
            // Launch settings
        }

        // Set up tab navigation
        setupTabs()
    }

    private fun setupTabs() {
        object : RecyclerView.Adapter<TabViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_tv_tab, parent, false)
                return TabViewHolder(view)
            }

            override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
                holder.bind(tabs[position])
                holder.itemView.setOnClickListener {
                    switchTab(position)
                }
            }

            override fun getItemCount() = tabs.size
        }.also { tabContainer.adapter = it }

        // Add focus highlight effect
        tabContainer.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Optional: Animate or update UI when tabs get focus
            }
        }
    }

    private fun switchTab(position: Int) {
        // Create and show the appropriate fragment
        val fragment = when (position) {
            0 -> HomeFragment()
            1 -> TrendingFragment()
            2 -> SubscriptionsFragment()
            //3 -> LibraryFragment()
            else -> HomeFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    class TabViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView = view as TextView

        fun bind(title: String) {
            textView.text = title

            // Add TV-specific focus animation
            textView.setOnFocusChangeListener { v, hasFocus ->
                v.animate()
                    .scaleX(if (hasFocus) 1.1f else 1.0f)
                    .scaleY(if (hasFocus) 1.1f else 1.0f)
                    .setDuration(200)
                    .start()
            }
        }
    }

    // Handle back navigation
    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}