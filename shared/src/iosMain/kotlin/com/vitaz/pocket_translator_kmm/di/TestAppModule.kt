package com.vitaz.pocket_translator_kmm.di

import com.vitaz.pocket_translator_kmm.testing.FakeHistoryDataSource
import com.vitaz.pocket_translator_kmm.testing.FakeTranslateClient
import com.vitaz.pocket_translator_kmm.testing.FakeVoiceToTextParser
import com.vitaz.pocket_translator_kmm.translate.domain.translate.Translate

class TestAppModule: AppModule {
    override val historyDataSource = FakeHistoryDataSource()
    override val client = FakeTranslateClient()
    override val translateUseCase = Translate(client, historyDataSource)
    override val voiceParser = FakeVoiceToTextParser()
}