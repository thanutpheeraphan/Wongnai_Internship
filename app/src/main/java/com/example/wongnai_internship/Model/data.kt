package com.example.wongnai_internship.Model

data class APiResponse(
    val status: String,
    val data: Data
)


data class Data(
    val coins : List<Coins>
)

data class Coins(
    val id: Int,
    val symbol: String,
    val name: String,
    val description: String,
    val iconUrl: String
)

