package com.example.expenses_roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expenses_roomdatabase.ui.theme.Expenses_RoomDatabaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Expenses_RoomDatabaseTheme {
                NavComponent()
            }
        }
    }
}

@Composable
fun NavComponent(){

    val navController = rememberNavController() // to define the state of the navigation

    NavHost(navController = navController, startDestination = "Screen1")
    {
        composable("Screen1") {
            AddExpense(navController = navController)
        }

        composable("Screen2") {
            Expenses_UI(navController = navController)
        }

    }
}