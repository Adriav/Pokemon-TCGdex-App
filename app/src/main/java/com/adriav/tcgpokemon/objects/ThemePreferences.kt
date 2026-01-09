package com.adriav.tcgpokemon.objects

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

private val ENERGY_KEY = stringPreferencesKey("energy")

object ThemePreferences {
    private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")

    fun isDarkTheme(context: Context): Flow<Boolean?> =
        context.dataStore.data.map { prefs ->
            prefs[DARK_THEME_KEY]
        }

    suspend fun setDarkTheme(context: Context, isDark: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[DARK_THEME_KEY] = isDark
        }
    }

    fun energyTheme(context: Context): Flow<PokemonEnergy?> =
        context.dataStore.data.map { preferences ->
            preferences[ENERGY_KEY]?.let { PokemonEnergy.valueOf(it) }
        }

    suspend fun setEnergyTheme(context: Context, energy: PokemonEnergy) {
        context.dataStore.edit { preferences ->
            preferences[ENERGY_KEY] = energy.name
        }
    }
}

