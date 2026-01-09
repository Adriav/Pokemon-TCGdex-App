package com.adriav.tcgpokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.adriav.tcgpokemon.navigation.NavigationWrapper
import com.adriav.tcgpokemon.objects.CenteredProgressIndicator
import com.adriav.tcgpokemon.objects.PokemonEnergy
import com.adriav.tcgpokemon.ui.theme.ThemeViewModel
import com.adriav.tcgpokemon.ui.theme.energyDarkScheme
import com.adriav.tcgpokemon.ui.theme.energyLightScheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeViewModel: ThemeViewModel = hiltViewModel()
            val systemDarkTheme = isSystemInDarkTheme()

            LaunchedEffect(Unit) {
                themeViewModel.initTheme(systemDarkTheme)
            }

            val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()
            val energyTheme by themeViewModel.energyTheme.collectAsState()

            if (isDarkTheme == null || energyTheme == null) {
                CenteredProgressIndicator()
                return@setContent
            }

            val colorScheme = if (isDarkTheme!!) {
                energyDarkScheme(energyTheme!!)
            } else {
                energyLightScheme(energyTheme!!)
            }

            MaterialTheme(colorScheme = colorScheme) {
                Scaffold { paddingValues ->
                    NavigationWrapper(
                        isDarkTheme!!,
                        paddingValues,
                        selectedEnergy = energyTheme?: PokemonEnergy.COLORLESS,
                        onToggleTheme = { themeViewModel.toggleDarkTheme() },
                        onEnergySelect = { energy ->
                            themeViewModel.setEnergyTheme(energy)
                        }
                    )
                }
            }
        }
    }
}