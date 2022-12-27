package com.vitaz.pocket_translator_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform