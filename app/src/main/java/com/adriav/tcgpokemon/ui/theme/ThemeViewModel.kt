package com.adriav.tcgpokemon.ui.theme

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adriav.tcgpokemon.objects.PokemonEnergy
import com.adriav.tcgpokemon.objects.ThemePreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val context: Context
) : ViewModel() {
    private val _isDarkTheme = MutableStateFlow<Boolean?>(null)
    val isDarkTheme = _isDarkTheme.asStateFlow()

    private val _energyTheme = MutableStateFlow<PokemonEnergy?>(null)
    val energyTheme = _energyTheme.asStateFlow()


    init {
        observeTheme()
    }

    private fun observeTheme() {
        viewModelScope.launch {
            combine(
                ThemePreferences.isDarkTheme(context),
                ThemePreferences.energyTheme(context)
            ) { dark, energy ->
                Pair(dark, energy)
            }.collect { (dark, energy) ->
                if (dark != null) _isDarkTheme.value = dark
                if (energy != null) _energyTheme.value = energy
            }
        }
    }

    fun initTheme(isSystemDark: Boolean) {
        if (_isDarkTheme.value == null) {
            _isDarkTheme.value = isSystemDark
            viewModelScope.launch {
                ThemePreferences.setDarkTheme(context, isSystemDark)
            }
        }
        if (_energyTheme.value == null) {
            _energyTheme.value = PokemonEnergy.COLORLESS
            viewModelScope.launch {
                ThemePreferences.setEnergyTheme(context, PokemonEnergy.COLORLESS)
            }
        }

    }

    fun toggleDarkTheme() {
        val newValue = !(_isDarkTheme.value ?: false)
        _isDarkTheme.value = newValue
        viewModelScope.launch {
            ThemePreferences.setDarkTheme(context, newValue)
        }
    }

    fun setEnergyTheme(energy: PokemonEnergy) {
        _energyTheme.value = energy
        viewModelScope.launch {
            ThemePreferences.setEnergyTheme(context, energy)
        }
    }
}