package com.example.expenses_roomdatabase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun AddExpense(navController: NavHostController, viewModel: Expenses_ViewModel = hiltViewModel()) {

    val expenses by viewModel.expenses.collectAsStateWithLifecycle()

    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(android.R.drawable.ic_menu_camera),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Blue)
                    .padding(6.dp)
                    .size(30.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Add Expense",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(android.R.drawable.ic_media_previous),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Blue)
                    .padding(6.dp)
                    .size(20.dp)
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFBBDEFB))
                .padding(horizontal = 8.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(android.R.drawable.ic_media_previous),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
            )

            Spacer(Modifier.width(4.dp))

            Text(
                text = "Quick Ledger",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Add Expense",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "Track your daily spending with mindful clarity.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )


        Spacer(modifier = Modifier.height(25.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Expense Title",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        text = "Required",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(Modifier.height(2.dp))

                OutlinedTextField(
                    value = title,
                    onValueChange = {title = it},
                    label = {
                        Text(
                            "",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFBBDEFB),
                        unfocusedContainerColor = Color(0xFFBBDEFB),
                        focusedBorderColor = Color(0xFFBBDEFB),
                        unfocusedBorderColor = Color(0xFFBBDEFB)
                    )
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Expense Amount",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(Modifier.height(2.dp))

                OutlinedTextField(
                    value = amount,
                    onValueChange = {amount = it},
                    label = {
                        Text(
                            "",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFBBDEFB),
                        unfocusedContainerColor = Color(0xFFBBDEFB),
                        focusedBorderColor = Color(0xFFBBDEFB),
                        unfocusedBorderColor = Color(0xFFBBDEFB)
                    )
                )

                Spacer(Modifier.height(20.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    maxItemsInEachRow = 4
                ) {
                    ExpenseCategory(
                        icon = painterResource(android.R.drawable.ic_media_previous),
                        text = "Coffee",
                        amount = "$4.50"
                    )

                    ExpenseCategory(
                        icon = painterResource(android.R.drawable.ic_media_previous),
                        text = "Groceries",
                        amount = "$45.20"
                    )

                    ExpenseCategory(
                        icon = painterResource(android.R.drawable.ic_media_previous),
                        text = "Transit",
                        amount = "$2.90"
                    )
                }
            }
        }



        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val amountInt = amount.toIntOrNull() ?: 0
                if (title.isNotBlank()) {
                    viewModel.addExpenses(title, amountInt)
                    navController.navigate("Screen2")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {

            Icon(
                painter = painterResource(android.R.drawable.ic_media_previous),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
            )

            Text(
                "Add Expenses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Button(
            onClick = {
                navController.navigate("Screen2")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBDEFB))
        ) {

            Text(
                "Go to Expenses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )


            Icon(
                painter = painterResource(android.R.drawable.ic_menu_revert),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Composable
fun ExpenseCategory(
    icon : Painter,
    text: String,
    amount : String
){

    Surface(
        shape = RoundedCornerShape(30.dp),
        color = Color(0xFFBBDEFB)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 2.dp,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = icon, contentDescription = "",
                modifier = Modifier.size(15.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = amount,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }

    Spacer(Modifier.width(6.dp))

}