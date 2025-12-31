package com.adriav.tcgpokemon.objects

import net.tcgdex.sdk.TCGdex
import javax.inject.Singleton

object TCGdexProvider {
    val tcgdex = TCGdex("en")
}

@Singleton
data class ApiProvider(
    val tcgdex: TCGdex = TCGdex("en")
)