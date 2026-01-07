package com.adriav.tcgpokemon.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adriav.tcgpokemon.database.dao.CardDao
import com.adriav.tcgpokemon.database.entity.CardEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyCollectionViewModel @Inject constructor(private val dao: CardDao) : ViewModel() {
    private val _cards = MutableLiveData<List<CardEntity>>()
    val cards: LiveData<List<CardEntity>> = _cards

    fun loadCards() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                dao.getAllCards().collect { cards ->
                    _cards.postValue(cards)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}