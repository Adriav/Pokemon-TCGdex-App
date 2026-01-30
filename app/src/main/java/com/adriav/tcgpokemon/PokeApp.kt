package com.adriav.tcgpokemon

import android.app.Application
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.adriav.tcgpokemon.navigation.NavigationWrapper
import com.adriav.tcgpokemon.objects.CenteredProgressIndicator
import com.adriav.tcgpokemon.ui.theme.TCGPokemonTheme
import com.adriav.tcgpokemon.ui.theme.ThemeViewModel
import com.adriav.tcgpokemon.views.ForceUpdateScreen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokeApp : Application() {
    @Composable
    fun AppRoot(mustUpdate: Boolean) {
        val themeViewModel: ThemeViewModel = hiltViewModel()
        val systemDarkTheme = isSystemInDarkTheme()
        LaunchedEffect(Unit) {
            themeViewModel.initTheme(systemDarkTheme)
        }

        val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

        if (isDarkTheme == null) {
            CenteredProgressIndicator()
        } else {
            AnimatedContent(
                targetState = isDarkTheme,
                transitionSpec = {
                    fadeIn(animationSpec = tween(300)) togetherWith
                            fadeOut(animationSpec = tween(300))
                },
                label = "ThemeTransition"
            ) { darkTheme ->
                TCGPokemonTheme(darkTheme = darkTheme!!) {
                    Scaffold { paddingValues ->
                        if (mustUpdate) {
                            ForceUpdateScreen()
                        } else {
                            NavigationWrapper(
                                darkTheme,
                                paddingValues
                            ) { themeViewModel.toggleTheme() }
                        }
                    }
                }
            }
        }
    }
}
