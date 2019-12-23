package com.example.axel.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.axel.MainActivity
import com.example.axel.R
import com.example.axel.adapters.TeaserRecyclerAdapter
import com.example.axel.data.Teaser
import com.example.axel.viewmodel.HeadlineViewModel
import kotlinx.android.synthetic.main.headline_fragment.*

class HeadlineFragment: Fragment() {

    private lateinit var teaserRecyclerAdapter: TeaserRecyclerAdapter
    private lateinit var headlineViewModel: HeadlineViewModel

    private val headlineClickListener = object : ItemClickListener<Teaser> {
        override fun onClick(item: Teaser) {
            if (!item.isPaid!!)
            (activity as? MainActivity)?.show(item)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = LayoutInflater
            .from(this.context)
            .inflate(R.layout.headline_fragment, container, false)

        teaserRecyclerAdapter = TeaserRecyclerAdapter(headlineClickListener)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view2)
        recyclerView.adapter = teaserRecyclerAdapter
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        headlineViewModel = ViewModelProviders
            .of(this)
            .get(HeadlineViewModel::class.java)

        headlineViewModel.headline.observe(this, Observer { headline ->
            textView_headline_title.text = headline.name
            teaserRecyclerAdapter.submitList(headline.teasers)
        })
    }



}