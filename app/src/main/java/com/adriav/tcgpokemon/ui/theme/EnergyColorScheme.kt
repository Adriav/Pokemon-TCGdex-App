package com.adriav.tcgpokemon.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.adriav.tcgpokemon.objects.PokemonEnergy

fun energyLightScheme(energy: PokemonEnergy) = when (energy) {
    PokemonEnergy.FIRE -> lightColorScheme(
        primary = Color(0xFFE53935),
        secondary = Color(0xFFFFCDD2),
        background = Color(0xFFFFF3E0)
    )
    PokemonEnergy.WATER -> lightColorScheme(
        primary = Color(0xFF1E88E5),
        secondary = Color(0xFFBBDEFB),
        background = Color(0xFFE3F2FD)
    )
    PokemonEnergy.GRASS -> lightColorScheme(
        primary = Color(0xFF43A047),
        secondary = Color(0xFFC8E6C9),
        background = Color(0xFFE8F5E9)
    )
    PokemonEnergy.ELECTRIC -> lightColorScheme(
        primary = Color(0xFFFDD835),
        secondary = Color(0xFFFFF9C4),
        background = Color(0xFFFFFDE7)
    )
    else -> lightColorScheme()
}

fun energyDarkScheme(energy: PokemonEnergy) = when (energy) {
    PokemonEnergy.FIRE -> darkColorScheme(
        primary = Color(0xFFEF5350),
        background = Color(0xFF1C0D0D)
    )
    PokemonEnergy.WATER -> darkColorScheme(
        primary = Color(0xFF64B5F6),
        background = Color(0xFF0D1B2A)
    )
    PokemonEnergy.GRASS -> darkColorScheme(
        primary = Color(0xFF81C784),
        background = Color(0xFF0D1F12)
    )
    PokemonEnergy.ELECTRIC -> darkColorScheme(
        primary = Color(0xFFFFEE58),
        background = Color(0xFF1F1A00)
    )
    else -> darkColorScheme()
}
