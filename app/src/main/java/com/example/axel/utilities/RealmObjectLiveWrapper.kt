package com.example.axel.utilities

import androidx.lifecycle.LiveData
import io.realm.*
import io.realm.kotlin.addChangeListener
import io.realm.kotlin.removeChangeListener

class RealmObjectLiveWrapper <T : RealmModel>(private val realmResult: T) : LiveData<T>() {

    private val listener = RealmChangeListener<T> { result -> value = result }

    override fun onActive() {
        realmResult.addChangeListener(listener)
    }

    override fun onInactive() {
        realmResult.removeChangeListener(listener)
    }

}