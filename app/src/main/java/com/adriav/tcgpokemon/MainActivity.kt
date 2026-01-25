package com.adriav.tcgpokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.adriav.tcgpokemon.models.AppVersionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val versionViewModel: AppVersionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        versionViewModel.checkVersion()
        enableEdgeToEdge()
        setContent {
            val mustUpdate by versionViewModel.mustUpdate.collectAsState()
            PokeApp().AppRoot(mustUpdate)
        }
    }
}