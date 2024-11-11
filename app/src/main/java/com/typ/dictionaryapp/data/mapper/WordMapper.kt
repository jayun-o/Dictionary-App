package com.typ.dictionaryapp.data.mapper

import com.typ.dictionaryapp.data.dto.DefinitionDto
import com.typ.dictionaryapp.data.dto.MeaningDto
import com.typ.dictionaryapp.data.dto.WordItemDto
import com.typ.dictionaryapp.domain.model.Definition
import com.typ.dictionaryapp.domain.model.Meaning
import com.typ.dictionaryapp.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem (
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)


fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)