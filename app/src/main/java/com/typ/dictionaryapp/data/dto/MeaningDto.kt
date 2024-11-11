package com.typ.dictionaryapp.data.dto

data class MeaningDto(
    val definitions: List<DefinitionDto>? = null,
    val partOfSpeech: String? = null,
 )