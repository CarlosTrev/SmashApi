package com.example.smashapi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smashapi.views.CharacterDetailScreen
import com.example.smashapi.views.CharacterListScreen
import com.example.smashapi.views.SplashScreen
import com.example.smashapi.viewmodel.CharactersViewModel

@Composable
fun Navigation(navController: NavHostController, viewModel: CharactersViewModel) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("character_list") {
            val charactersState = viewModel.characters.collectAsState()
            CharacterListScreen(
                characters = charactersState.value,
                navController = navController
            )
        }
        composable("character_detail/{order}") { backStackEntry ->
            val order = backStackEntry.arguments?.getString("order") ?: ""
            val character = viewModel.characters.value.find { it.order == order }
            character?.let {
                CharacterDetailScreen(it, navController)
            }
        }
    }
}
