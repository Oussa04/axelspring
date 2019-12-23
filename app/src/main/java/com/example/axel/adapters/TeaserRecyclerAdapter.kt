package com.example.axel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.axel.R
import com.example.axel.data.Teaser
import com.example.axel.databinding.TeaserDetailBinding
import com.example.axel.databinding.TeaserListItemBinding
import com.example.axel.ui.HeadlineFragment
import com.example.axel.ui.ItemClickListener
import io.realm.RealmList

class TeaserRecyclerAdapter(private val clickListener: ItemClickListener<Teaser>)
    : RecyclerView.Adapter<TeaserRecyclerAdapter.TeaserViewHolder>() {

    var items: RealmList<Teaser> = RealmList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeaserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil
            .inflate<TeaserListItemBinding>(layoutInflater, R.layout.teaser_list_item, parent, false)

        binding.itemClickListener = clickListener

        return TeaserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TeaserViewHolder, position: Int) {
        holder.binding.teaser = items[position]
        holder.binding.executePendingBindings()
    }

    fun submitList(teasers: RealmList<Teaser>){
        items = teasers
    }

    class TeaserViewHolder(val binding: TeaserListItemBinding) : RecyclerView.ViewHolder(binding.root)

}