package com.typ.dictionaryapp.domain.repository

import com.typ.dictionaryapp.domain.model.WordItem
import com.typ.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>>
}