package com.example.rm_characters.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rm_characters.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = true
)
abstract class RMDatabase: RoomDatabase(){
    abstract fun charactersDao(): CharacterDao
}