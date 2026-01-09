package com.adriav.tcgpokemon.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.adriav.tcgpokemon.R
import com.adriav.tcgpokemon.objects.PokemonEnergy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToAllSeries: () -> Unit,
    navigateToAllSets: () -> Unit,
    navigateToMyCollection: () -> Unit,
    navigateToSearchScreen: () -> Unit,
    onToggleTheme: () -> Unit,
    onEnergySelect: (PokemonEnergy) -> Unit,
    isDarkMode: Boolean,
    selectedEnergy: PokemonEnergy
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Pokemon TCG Dex") },
                actions = {
                    IconButton(onClick = onToggleTheme) {
                        Icon(
                            imageVector = if (isDarkMode)
                                Icons.Default.DarkMode
                            else Icons.Default.LightMode,
                            contentDescription = "Toggle Dark Mode"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            EnergySelector(selectedEnergy) { energy ->
                onEnergySelect(energy)
            }
            HomeButton("All Series", navigateToAllSeries)
            HomeButton("All Sets", navigateToAllSets)
            HomeButton("Search Cards", navigateToSearchScreen)
            HomeButton("My Collection", navigateToMyCollection)
        }
    }
}

@Composable
fun HomeButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape
    ) {
        Text(text, style = MaterialTheme.typography.titleMedium)
    }
}

@Composable
fun EnergySelector(
    selectedEnergy: PokemonEnergy,
    onSelect: (PokemonEnergy) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        items(PokemonEnergy.entries.toTypedArray()) { energy ->
            EnergyFilterChip(
                energy = energy,
                selected = energy == selectedEnergy,
                onClick = {
                    onSelect(energy)
                }
            )
        }
    }
}


@Composable
fun EnergyFilterChip(
    energy: PokemonEnergy,
    selected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = {
            Text(energy.name)
        },
        leadingIcon = {
            Image(
                painter = painterResource(
                    id = energyToDrawable(energy)
                ),
                contentDescription = energy.name,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}

fun energyToDrawable(energy: PokemonEnergy): Int {
    return when (energy) {
        PokemonEnergy.COLORLESS -> R.drawable.colorless
        PokemonEnergy.FIRE -> R.drawable.fire
        PokemonEnergy.WATER -> R.drawable.water
        PokemonEnergy.GRASS -> R.drawable.grass
        PokemonEnergy.ELECTRIC -> R.drawable.lightning
        PokemonEnergy.PSYCHIC -> R.drawable.psychic
        PokemonEnergy.FIGHTING -> R.drawable.fighting
        PokemonEnergy.DARKNESS -> R.drawable.darkness
        PokemonEnergy.METAL -> R.drawable.metal
        PokemonEnergy.FAIRY -> R.drawable.fairy
        PokemonEnergy.DRAGON -> R.drawable.dragon
    }
}
