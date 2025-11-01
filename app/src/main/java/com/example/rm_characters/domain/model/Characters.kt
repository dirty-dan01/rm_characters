package com.example.rm_characters.domain.model

data class Characters(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val imgUrl: String,
)