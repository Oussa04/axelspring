package com.example.axel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.axel.data.Teaser
import com.example.axel.ui.HeadlineFragment
import com.example.axel.ui.TeaserDetailFragment

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            val fragment = HeadlineFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, "headline").commit()
        }
    }

    fun show(teaser: Teaser) {

        val recipeFragment = TeaserDetailFragment.forTeaser(teaser.id)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("headline")
            .setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
            .replace(R.id.fragment_container,
                recipeFragment, null)
            .commit()
    }
}
