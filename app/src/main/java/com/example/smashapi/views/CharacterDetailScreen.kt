package com.example.smashapi.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.navigation.NavController
import com.example.smashapi.data.SmashCharacter

@Composable
fun CharacterDetailScreen(character: SmashCharacter, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, Color(0xFFFFD700)),
            colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = character.images.portrait,
                    contentDescription = character.name,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))
                AsyncImage(
                    model = character.images.icon,
                    contentDescription = character.name,
                    modifier = Modifier
                        .height(30.dp)
                        .fillMaxWidth()
                )
                Text("Nombre: ${character.name}", color = Color.White)
                Text("Series: ${character.series.name}", color = Color.White)
                Text("Disponible en: ${character.availability}", color = Color.White)
                Text("También aparece en: ${character.alsoAppearsIn.joinToString()}", color = Color.White)
                Text("Order (ID): ${character.order}", color = Color.White)
            }
        }
    }
}
