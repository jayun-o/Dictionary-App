package com.typ.dictionaryapp.data.dto

data class WordItemDto(
    val meanings: List<MeaningDto>? = null,
    val phonetic: String? = null,
    val word: String? = null
)