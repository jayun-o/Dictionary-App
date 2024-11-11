package com.typ.dictionaryapp.presentation

import com.typ.dictionaryapp.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",

    val wordItem: WordItem? = null
)
