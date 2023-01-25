package com.vitaz.pocket_translator_kmm.di

import com.vitaz.pocket_translator_kmm.database.TranslateDatabase
import com.vitaz.pocket_translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import com.vitaz.pocket_translator_kmm.translate.data.local.DatabaseDriverFactory
import com.vitaz.pocket_translator_kmm.translate.data.remote.HttpClientFactory
import com.vitaz.pocket_translator_kmm.translate.data.translate.KtorTranslateClient
import com.vitaz.pocket_translator_kmm.translate.domain.history.HistoryDataSource
import com.vitaz.pocket_translator_kmm.translate.domain.translate.Translate
import com.vitaz.pocket_translator_kmm.translate.domain.translate.TranslateClient
import com.vitaz.pocket_translator_kmm.voice_to_text.domain.VoiceToTextParser

interface AppModule {
    val historyDataSource: HistoryDataSource
    val client: TranslateClient
    val translateUseCase: Translate
    val voiceParser: VoiceToTextParser
}

class AppModuleImpl(
    parser: VoiceToTextParser
): AppModule {

    override val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    override val client: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    override val translateUseCase: Translate by lazy {
        Translate(client, historyDataSource)
    }

    override val voiceParser = parser
}