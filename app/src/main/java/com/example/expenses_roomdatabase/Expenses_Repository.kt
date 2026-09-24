package com.example.expenses_roomdatabase

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.Int
import kotlin.String

class Expenses_Repository @Inject constructor(
    private val expensesDao : ExpensesDao
){

    fun getAllExpenses(): Flow<List<Expenses>> = expensesDao.getAllExpenses()

    suspend fun insertExpenses(title: String, amount: Int) {
        expensesDao.insertExpenses(
            Expenses(
                title = title,
                amount = amount
            )
        )
    }

    suspend fun deleteExpenses(id : Long){
        expensesDao.deleteExpenses(id = id)
    }
}