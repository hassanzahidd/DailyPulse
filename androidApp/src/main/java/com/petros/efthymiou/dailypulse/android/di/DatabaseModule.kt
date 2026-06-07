package com.petros.efthymiou.dailypulse.android.di

import app.cash.sqldelight.db.SqlDriver
import com.petros.efthymiou.dailypulse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import petros.efthymiou.dailypulse.db.DailyoulseDatabase

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()
    }
    single<DailyoulseDatabase> {
        DailyoulseDatabase(get<SqlDriver>())    }
}