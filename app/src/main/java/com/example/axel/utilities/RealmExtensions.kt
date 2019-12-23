@file:JvmName("RealmUtils")


package com.example.axel.utilities

import com.example.axel.dao.HeadlineDao
import com.example.axel.dao.TeaserDao
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults

fun <T: RealmModel> RealmResults<T>.asLiveData() = RealmResultsLiveDataWrapper<T>(this)
fun <T: RealmModel> T.asLiveData() = RealmObjectLiveWrapper<T>(this)

fun Realm.headlineDao(): HeadlineDao = HeadlineDao(this)
fun Realm.teaserDao(): TeaserDao = TeaserDao(this)
