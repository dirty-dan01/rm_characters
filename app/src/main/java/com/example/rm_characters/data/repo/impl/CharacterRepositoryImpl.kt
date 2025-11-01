package com.example.rm_characters.data.repo.impl

import com.example.rm_characters.data.flags.FeatureFlags
import com.example.rm_characters.data.local.database.CharacterDao
import com.example.rm_characters.data.mapper.toDomain
import com.example.rm_characters.data.mapper.toEntity
import com.example.rm_characters.data.remote.api.RmApi
import com.example.rm_characters.data.repo.contracts.CharacterRepository
import com.example.rm_characters.data.utils.Results
import com.example.rm_characters.domain.model.Characters
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CharacterRepositoryImpl(
    private val api: RmApi,
    private val dao: CharacterDao,
    private val flags: FeatureFlags,
    private val io: CoroutineDispatcher
): CharacterRepository {
    override fun observeCharacters(): Flow<List<Characters>> =
        dao.observeAll().map { list -> list.map { it.toDomain() } }

    override suspend fun refreshCharacters(): Results<Unit> = withContext(io) {
        try {
            val dto = api.getCharacters(page = 1)
            val now = System.currentTimeMillis()
            val entities = dto.results.map { it.toEntity(now) }
            if (flags.enableRemoteFirst){
                dao.clear()
            }
            dao.upsertAll(entities)
            Results.Success(Unit)
        }catch (e: Throwable){
            Results.Error(e)
        }
    }
}