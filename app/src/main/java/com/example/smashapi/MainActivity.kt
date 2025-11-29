package com.example.smashapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import com.example.smashapi.viewmodel.CharactersViewModel
import com.example.smashapi.views.CharacterListScreen

class MainActivity : ComponentActivity() {

    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadCharacters()

        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                val characters = viewModel.characters.collectAsState(initial = emptyList())
                CharacterListScreen(characters = characters.value)
            }
        }
    }
}
