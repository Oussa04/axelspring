package com.example.axel.viewmodel

import androidx.lifecycle.ViewModel
import com.example.axel.dao.HeadlineDao
import com.example.axel.utilities.headlineDao
import io.realm.Realm

class HeadlineViewModel internal constructor(): ViewModel(){

    val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    val headline = realm.headlineDao().getHeadline()


    override fun onCleared() {
        realm.close()
        super.onCleared()
    }

}