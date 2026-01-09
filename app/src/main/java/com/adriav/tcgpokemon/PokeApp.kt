package com.adriav.tcgpokemon

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokeApp : Application()
/*
{
    @Composable
    fun AppRoot() {
        val themeViewModel: ThemeViewModel = viewModel()
        val isDarkMode by themeViewModel.isDarkTheme.collectAsState()

        DevicesTheme(darkTheme = isDarkMode) {

        }
    }
}
*/