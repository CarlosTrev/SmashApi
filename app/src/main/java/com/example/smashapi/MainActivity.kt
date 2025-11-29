package com.example.smashapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.smashapi.viewmodel.CharactersViewModel
import com.example.smashapi.views.CharacterListScreen

class MainActivity : ComponentActivity() {

    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadCharacters()

        setContent {
            val characters = viewModel.characters.collectAsState()
            CharacterListScreen(characters = characters.value)
        }
    }
}
