package com.example.axel.ui

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.axel.R
import com.example.axel.databinding.TeaserDetailBinding
import com.example.axel.viewmodel.TeaserViewModel
import com.example.axel.viewmodel.TeaserViewModelFactory
import kotlinx.android.synthetic.main.teaser_detail.*



class TeaserDetailFragment : Fragment() {

    private lateinit var binding: TeaserDetailBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.teaser_detail,
            container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val factory = TeaserViewModelFactory(arguments?.getString(TEASER_ID_KEY) ?: "0")

        val viewModel = ViewModelProviders
            .of(this, factory)
            .get(TeaserViewModel::class.java)

        viewModel.teaser.observe(this, Observer { teaser ->
            binding.teaser = teaser
        })
        toolbar.navigationIcon?.setColorFilter(resources.getColor(android.R.color.white,resources.newTheme()),PorterDuff.Mode.SRC_ATOP)
        toolbar.setNavigationOnClickListener { activity?.supportFragmentManager?.popBackStack() }
    }

    companion object {

        private val TEASER_ID_KEY = "teaser_id"

        fun forTeaser(teaserId: String): TeaserDetailFragment {
            val fragment = TeaserDetailFragment()
            val args = Bundle()
            args.putString(TEASER_ID_KEY, teaserId)
            fragment.arguments = args
            return fragment
        }
    }
}