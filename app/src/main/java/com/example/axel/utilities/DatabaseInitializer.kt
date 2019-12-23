package com.example.axel.utilities

import android.content.Context
import android.util.Log
import com.example.axel.adapters.RealmListJsonAdapterFactory
import com.example.axel.data.Headline
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.realm.Realm
import java.io.IOException
import java.io.InputStream

class DatabaseInitializer(
    private val context: Context
) : Realm.Transaction  {

    internal object MoshiFactory {
        private val moshi : Moshi =  Moshi.Builder().add(KotlinJsonAdapterFactory())
            .add(RealmListJsonAdapterFactory())

            .build()
        fun getInstance() = moshi
    }

    private fun getHeadlineJSON(fileName : String = DATA_FILENAME): String {
        Log.i("MOSHI", "HE")
        val inputStream = getInputStreamFromJsonFile(fileName)
        return inputStream.bufferedReader().use { it.readText() }
    }

    @Throws(IOException::class)
    fun getInputStreamFromJsonFile(fileName: String): InputStream {
        return  context.assets.open(fileName)
    }

    override fun execute(realm: Realm) {
        realm.deleteAll()

        val headlineJson = getHeadlineJSON()
        val adapter:JsonAdapter<Headline> = MoshiFactory.getInstance().adapter(Headline::class.java)
        val headline = adapter.fromJson(headlineJson)
        realm.headlineDao().insertHeadline(headline!!)
    }

}