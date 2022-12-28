package com.vitaz.pocket_translator_kmm.translate.data.local

import com.squareup.sqldelight.db.SqlDriver
import io.ktor.client.*

expect class DatabaseDriverFactory {
    fun create(): SqlDriver
}