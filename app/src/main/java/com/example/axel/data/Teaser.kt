package com.example.axel.data

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Teaser(
    @PrimaryKey
    var id : String = UUID.randomUUID().toString(),
    var title : String = "",
    var text: String = "",
    var isPaid: Boolean? = false,
    var type:String = "teaser") :RealmObject() {

    override fun toString(): String {
        return "Teaser(id='$id', title='$title', text='$text', isPaid=$isPaid, type='$type')"
    }
}