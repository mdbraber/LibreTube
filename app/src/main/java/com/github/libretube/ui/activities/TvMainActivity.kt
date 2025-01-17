package com.github.libretube.ui.activities

// TvMainActivity.kt
import androidx.fragment.app.FragmentActivity
import android.os.Bundle
import com.github.libretube.R

class TvMainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_main)
    }
}