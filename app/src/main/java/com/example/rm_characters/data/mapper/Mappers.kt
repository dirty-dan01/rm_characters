package com.example.rm_characters.data.mapper

import com.example.rm_characters.data.local.entity.CharacterEntity
import com.example.rm_characters.data.remote.dto.CharacterDto
import com.example.rm_characters.domain.model.Characters

fun CharacterDto.toEntity(now: Long) = CharacterEntity(
    id = id,
    name = name,
    status = status,
    species = species,
    imgUrl = imgUrl,
    lastUpdated = now,
)

fun CharacterEntity.toDomain() = Characters(
    id = id,
    name = name,
    status = status,
    species = species,
    imgUrl = imgUrl,
)