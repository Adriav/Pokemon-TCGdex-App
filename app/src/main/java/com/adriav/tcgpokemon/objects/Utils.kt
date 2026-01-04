package com.adriav.tcgpokemon.objects

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppHeader(text: String = "Todas las ...") {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)

    ) {
        Text(
            text = text,
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxSize()
        )
    }
    HorizontalDivider(Modifier.padding(bottom = 4.dp))
}

@Composable
fun CenteredProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(width = 100.dp, height = 100.dp),
            color = Color(0xFF2D6BE0),
            strokeWidth = 8.dp
        )
    }
}

@SuppressLint("LocalContextResourcesRead")
@Composable
fun GetTypeColor(colorName: String): Color {
    val context = LocalContext.current

    val colorResId = context.resources.getIdentifier(
        colorName,
        "color",
        context.packageName
    )

    return if (colorResId != 0) {
        colorResource(id = colorResId)
    } else {
        Color.Gray // fallback
    }
}