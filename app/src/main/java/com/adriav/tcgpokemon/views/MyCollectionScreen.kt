package com.adriav.tcgpokemon.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.adriav.tcgpokemon.models.MyCollectionViewModel
import com.adriav.tcgpokemon.objects.AppHeader
import com.adriav.tcgpokemon.objects.CenteredProgressIndicator

@Composable
fun MyCollectionScreen(viewModel: MyCollectionViewModel) {
    // Scroll Helper
    val scrollState = rememberScrollState()
    // Cards from Database
    val myCards by viewModel.cards.observeAsState(null)
    viewModel.loadCards()

    if (myCards == null) {
        CenteredProgressIndicator()
    } else {
        Column(Modifier.verticalScroll(scrollState, enabled = true, reverseScrolling = false)) {
            if (myCards!!.isEmpty()) {
                AppHeader("NO CARDS YET")
            } else {
                Column {
                    myCards!!.forEach { card ->
                        Text(text = card.name)
                    }
                }
            }
        }
    }
}