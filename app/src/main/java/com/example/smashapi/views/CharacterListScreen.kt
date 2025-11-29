package com.example.smashapi.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.smashapi.data.SmashCharacter
import kotlinx.coroutines.delay

@Composable
fun CharacterListScreen(characters: List<SmashCharacter>) {
    var searchQuery by remember { mutableStateOf("") }
    var displayedCharacters by remember { mutableStateOf(listOf<SmashCharacter>()) }

    LaunchedEffect(characters) {
        displayedCharacters = emptyList()
        for (char in characters) {
            displayedCharacters = displayedCharacters + char
            delay(50)
        }
    }

    val filteredCharacters = displayedCharacters.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(8.dp)
    ) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Buscar personaje...", color = Color.Red) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle(color = Color.Blue)
        )

        if (displayedCharacters.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                CircularProgressIndicator(color = Color(0xFFFFD700))
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filteredCharacters) { character ->
                    CharacterItem(character = character)
                }
            }
        }
    }
}
