package com.example.expenses_roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Expenses::class], version = 1, exportSchema = false)
abstract class ExpensesDatabase : RoomDatabase() {
    abstract fun expensesDao(): ExpensesDao
}