package com.typ.dictionaryapp.presentation

sealed class MainUiEvents {
    data class OnSearchWordChange(
        val newWord: String
    ) : MainUiEvents()

    object OnSearchClick: MainUiEvents()

}