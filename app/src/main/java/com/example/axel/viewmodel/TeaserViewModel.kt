package com.example.axel.viewmodel

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseMethod
import androidx.lifecycle.ViewModel
import com.example.axel.dao.TeaserDao
import com.example.axel.utilities.headlineDao
import com.example.axel.utilities.teaserDao
import io.realm.Realm

class TeaserViewModel(id: String)  : ViewModel() {

    val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    val teaser = realm.teaserDao().getTeaserById(id)

    override fun onCleared() {
        realm.close()
        super.onCleared()
    }
}