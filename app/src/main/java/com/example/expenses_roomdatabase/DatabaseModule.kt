package com.example.expenses_roomdatabase

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideExpensesDatabase(@ApplicationContext context: Context): ExpensesDatabase {
        return Room.databaseBuilder(
            context,
            ExpensesDatabase::class.java,
            "expenses_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideExpensesDao(database: ExpensesDatabase): ExpensesDao {
        return database.expensesDao()
    }
}
