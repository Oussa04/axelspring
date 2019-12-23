package com.example.axel

import android.app.Application
import com.example.axel.utilities.DATABASE_NAME
import com.example.axel.utilities.DatabaseInitializer
import io.realm.Realm
import io.realm.RealmConfiguration

class AxelApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        Realm.setDefaultConfiguration(
            RealmConfiguration.Builder()
                .name(DATABASE_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .initialData(DatabaseInitializer(this))
                .build())
    }
}