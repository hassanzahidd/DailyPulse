package com.petros.efthymiou.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.petros.efthymiou.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module
import petros.efthymiou.dailypulse.db.DailyoulseDatabase

val DatabaseModule = module {
    single<SqlDriver>{
        DatabaseDriverFactory().createDriver()
    }
    single {
        DailyoulseDatabase(get<SqlDriver>())
    }
}