package com.example.axel.adapters


import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

import java.io.IOException

import io.realm.RealmList
import io.realm.RealmObject

internal class RealmListAdapter<T : RealmObject>(private val elementAdapter: JsonAdapter<T>) :
    JsonAdapter<RealmList<T>>() {
    override fun toJson(writer: JsonWriter, value: RealmList<T>?) {
        writer.beginArray()
        for (element in value!!) {
            elementAdapter.toJson(writer, element)
        }
        writer.endArray()
    }


    @Throws(IOException::class)
    override fun fromJson(reader: JsonReader): RealmList<T>? {
        val result = RealmList<T>()
        reader.beginArray()
        while (reader.hasNext()) {
            result.add(elementAdapter.fromJson(reader))
        }
        reader.endArray()
        return result
    }
}