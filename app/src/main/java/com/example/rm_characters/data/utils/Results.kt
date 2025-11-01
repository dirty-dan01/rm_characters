package com.example.rm_characters.data.utils

sealed class Results<out T> {
    data class Success<T>(val data: T): Results<T>()
    data class  Error(val cause: Throwable): Results<Nothing>()
}