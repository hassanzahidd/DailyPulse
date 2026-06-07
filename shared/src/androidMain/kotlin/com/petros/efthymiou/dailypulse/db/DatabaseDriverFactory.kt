package com.petros.efthymiou.dailypulse.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import petros.efthymiou.dailypulse.db.DailyoulseDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver() : SqlDriver =
        AndroidSqliteDriver(
            schema = DailyoulseDatabase.Schema,
            context = context,
            name = "DailyPulse.Database.db"
        )

}