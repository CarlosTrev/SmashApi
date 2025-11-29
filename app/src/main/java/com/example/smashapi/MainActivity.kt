package com.example.smashapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.smashapi.viewmodel.CharactersScreen
import com.example.smashapi.viewmodel.CharactersViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadCharacters()

        setContent {
            CharactersScreen(viewModel)
        }
    }
}
