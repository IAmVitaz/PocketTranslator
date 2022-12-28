package com.vitaz.pocket_translator_kmm.core.domain.util

interface DisposableHandle: kotlinx.coroutines.DisposableHandle

fun DisposableHandle(block: () -> Unit): DisposableHandle {
    return object : DisposableHandle {
        override fun dispose() {
            block()
        }
    }
}