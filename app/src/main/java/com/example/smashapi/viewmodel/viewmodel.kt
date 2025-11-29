package com.example.smashapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smashapi.data.RetrofitInstance
import com.example.smashapi.data.SmashCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    private val _characters = MutableStateFlow<List<SmashCharacter>>(emptyList())
    val characters: StateFlow<List<SmashCharacter>> get() = _characters

    fun loadCharacters() {
        viewModelScope.launch {
            try {
                _characters.value = RetrofitInstance.api.getCharacters()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
