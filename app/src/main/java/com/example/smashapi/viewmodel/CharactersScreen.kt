package com.example.smashapi.viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.smashapi.data.SmashCharacter

@Composable
fun CharactersScreen(viewModel: CharactersViewModel) {

    val list by viewModel.characters.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { character ->
            CharacterItem(character)
        }
    }
}

@Composable
fun CharacterItem(c: SmashCharacter) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {

        AsyncImage(
            model = c.images.portrait,
            contentDescription = c.name,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = c.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Serie: ${c.series.name}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Orden: ${c.order}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
