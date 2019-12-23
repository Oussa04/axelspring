package com.example.axel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.axel.dao.HeadlineDao
import com.example.axel.dao.TeaserDao
import com.example.axel.data.Teaser
import com.example.axel.utilities.teaserDao
import io.realm.Realm

class TeaserViewModelFactory(
    private val id: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeaserViewModel(id) as T
    }
}