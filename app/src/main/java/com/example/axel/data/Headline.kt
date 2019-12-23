package com.example.axel.data

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Headline(
    @PrimaryKey
    var name:String = "",
    var teasers: RealmList<Teaser> = RealmList()):RealmObject() {

    override fun toString(): String {
        return "Headline(name='$name', teasers=$teasers)"
    }

}