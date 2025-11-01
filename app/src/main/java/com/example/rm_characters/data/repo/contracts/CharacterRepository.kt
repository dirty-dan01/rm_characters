package com.example.rm_characters.data.repo.contracts

import com.example.rm_characters.data.utils.Results
import com.example.rm_characters.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun observeCharacters(): Flow<List<Characters>>
    suspend fun refreshCharacters(): Results<Unit>
}