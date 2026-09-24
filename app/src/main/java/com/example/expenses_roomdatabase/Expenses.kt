package com.example.expenses_roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "expenses")
data class Expenses(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val amount: Int
)
