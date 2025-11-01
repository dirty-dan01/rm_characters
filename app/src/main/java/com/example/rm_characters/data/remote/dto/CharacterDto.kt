package com.example.rm_characters.data.remote.dto

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val imgUrl:String,
)


data class CharactersResponseDto(
    val results: List<CharacterDto>
)