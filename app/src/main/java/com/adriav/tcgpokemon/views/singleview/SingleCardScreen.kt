package com.adriav.tcgpokemon.views.singleview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adriav.tcgpokemon.models.SingleCardViewModel
import com.adriav.tcgpokemon.objects.AppHeader
import com.adriav.tcgpokemon.objects.CenteredProgressIndicator
import net.tcgdex.sdk.Extension
import net.tcgdex.sdk.Quality

@Composable
fun SingleCardScreen(viewModel: SingleCardViewModel ,cardID: String) {
    val card by viewModel.card.observeAsState(null)
    viewModel.setCardId(cardID)
    viewModel.loadCard()

    if (card == null) {
        CenteredProgressIndicator()
    } else {
        Column {
            AppHeader(card!!.name)
            DisplayCardImage(card!!.getImageUrl(Quality.HIGH, Extension.WEBP), card!!.name)
        }
    }
}

@Composable
fun DisplayCardImage(imageURL: String, cardName: String) {
    AsyncImage(
        model = imageURL,
        contentDescription = cardName,
        modifier = Modifier.fillMaxWidth()
            .padding(24.dp),
        contentScale = ContentScale.Fit
    )
}