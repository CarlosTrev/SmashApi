package com.example.smashapi.data
data class SmashCharacter(
    val alsoAppearsIn: List<String>,
    val availability: String,
    val images: Images,
    val name: String,
    val order: String,
    val series: Series
)

data class Images(
    val icon: String,
    val portrait: String
)

data class Series(
    val icon: String,
    val name: String
)
