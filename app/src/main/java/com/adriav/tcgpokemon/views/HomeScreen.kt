package com.adriav.tcgpokemon.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriav.tcgpokemon.models.HomeViewModel

@Composable
fun HomeScreen(navigateToAllSeries: () -> Unit, navigateToAllSets: () -> Unit, viewModel: HomeViewModel) {
    val searchText : String by viewModel.searchText.observeAsState("")
    val searchEnabled : Boolean by viewModel.searchEnabled.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Barra de búsqueda
        Text(text = "Buscar una carta", fontSize = 24.sp)
        TextField(
            value = searchText,
            onValueChange = { viewModel.onSearchChange(it) },
            placeholder = { Text(text = "Buscar una carta") },
            singleLine = true,
            maxLines = 1)
        Button(onClick = {}, modifier = Modifier.fillMaxWidth(), enabled = searchEnabled) {
            Text(text = "Buscar")
        }
        HorizontalDivider(Modifier.padding(top = 8.dp, bottom = 64.dp))

        // Visualizar mis cartas
        Button(
            onClick = {},
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) { Text(text = "Mis cartas", fontSize = 16.sp) }

        // Ver todas las SERIES
        Button(
            onClick = { navigateToAllSeries() },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) { Text(text = "Todas las series", fontSize = 16.sp) }

        // Ver todos los SETS
        Button(
            onClick = { navigateToAllSets() },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
        ) { Text(text = "Todos los sets", fontSize = 16.sp) }
    }
}