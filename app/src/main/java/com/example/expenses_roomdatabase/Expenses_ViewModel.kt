package com.example.expenses_roomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class Expenses_ViewModel @Inject constructor(
    private val repository: Expenses_Repository
) : ViewModel() {

    private val _expenses = MutableStateFlow<List<Expenses>>(emptyList())
    val expenses: StateFlow<List<Expenses>> = _expenses.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllExpenses().collect {
                _expenses.value = it
            }
        }
    }

    fun addExpenses(title: String, amount : Int) {
        viewModelScope.launch {
            repository.insertExpenses(title, amount)
        }
    }

    fun deleteExpenses(id : Long){
        viewModelScope.launch {
            repository.deleteExpenses(id)
        }
    }
}