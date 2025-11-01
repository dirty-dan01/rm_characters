package com.example.rm_characters.data.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.rm_characters.data.repo.contracts.CharacterRepository

class SyncCharactersWorker(
    appContext: Context,
    params: WorkerParameters,
    private val repo: CharacterRepository
): CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        return when(repo.refreshCharacters()){
            is com.example.rm_characters.data.utils.Results.Success -> Result.success()
            is com.example.rm_characters.data.utils.Results.Error -> Result.retry()
        }
    }
}