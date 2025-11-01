package com.example.rm_characters.data.remote.api

import retrofit2.http.GET
import com.example.rm_characters.data.remote.dto.CharactersResponseDto
import retrofit2.http.Query

interface RmApi {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1
    ): CharactersResponseDto
}