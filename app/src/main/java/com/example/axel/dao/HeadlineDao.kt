package com.example.axel.dao

import androidx.lifecycle.LiveData
import com.example.axel.data.Headline
import com.example.axel.data.Teaser
import com.example.axel.utilities.asLiveData
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmResults

class HeadlineDao(val realm: Realm) {

    fun insertHeadline(headline: Headline){
        realm.executeTransactionAsync{
            it.copyToRealmOrUpdate(headline)
        }
    }

    fun getHeadline(): LiveData<Headline> {
        return realm.where(Headline::class.java).findFirstAsync().asLiveData()
    }

    /*companion object {

        // For Singleton instantiation
        @Volatile private var instance: HeadlineDao? = null

        fun getInstance(realm: Realm) =
            instance ?: synchronized(this) {
                instance ?: HeadlineDao(realm).also { instance = it }
            }
    }*/



}