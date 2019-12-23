package com.example.axel.dao

import androidx.lifecycle.LiveData
import com.example.axel.data.Teaser
import com.example.axel.utilities.asLiveData
import io.realm.Realm
import io.realm.RealmResults

class TeaserDao(val realm: Realm) {


    fun getTeaserById(id:String): LiveData<Teaser> {
        return realm.where(Teaser::class.java).equalTo("id",id).findFirstAsync().asLiveData()
    }

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: TeaserDao? = null

        fun getInstance(realm: Realm) =
            instance ?: synchronized(this) {
                instance ?: TeaserDao(realm).also { instance = it }
            }
    }
}