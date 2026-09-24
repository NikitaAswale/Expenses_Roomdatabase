package com.example.expenses_roomdatabase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun Expenses_UI(viewModel: Expenses_ViewModel = hiltViewModel(), navController: NavHostController) {

    val expenses by viewModel.expenses.collectAsStateWithLifecycle()
    val totalAmount = expenses.sumOf { it.amount }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(android.R.drawable.ic_menu_always_landscape_portrait),
                tint = Color.White,
                contentDescription = "Notes Header Icon",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Blue)
                    .padding(6.dp)
                    .size(30.dp)
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = "All Expenses",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(Modifier.weight(1f))

            Icon(
                painter = painterResource(android.R.drawable.ic_menu_camera),
                tint = Color.White,
                contentDescription = "Notes Header Icon",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Blue)
                    .padding(6.dp)
                    .size(30.dp)
            )

        }

        Spacer(Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(1.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Blue)
        ) {

            Column(modifier = Modifier.padding(12.dp)) {

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                        tint = Color.White,
                        contentDescription = "Notes Header Icon",
                        modifier = Modifier
                            .size(30.dp)
                    )

                    Text(
                        text = "OCTOBER SPEND",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(Modifier.weight(1f))

                    Text(
                        text = "${expenses.size} visible",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color(0x80FFFFFF))
                            .padding(horizontal = 10.dp, vertical = 1.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "$$totalAmount",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(Modifier.weight(1f))

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .clickable { navController.navigate("Screen1") }
                            .padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_add),
                            contentDescription = "",
                            tint = Color.Blue,
                            modifier = Modifier.size(20.dp)
                        )

                        Text(
                            text = "Log",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                    }
                }

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Keep up the mindful balance",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Blue)
                    .size(10.dp)
            )

            Spacer(modifier = Modifier.width(14.dp))

            Text(
                text = "Recent Expenses",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "All",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFBBDEFB))
                    .padding(horizontal = 14.dp, vertical = 2.dp)
            )

        }

        Spacer(Modifier.height(12.dp))

        if (expenses.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Expenses list is empty",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(expenses) { expense ->

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {

                        Row(
                            modifier = Modifier.padding(12.dp),
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

                            Spacer(modifier = Modifier.width(8.dp))

                            Column(
                                modifier = Modifier,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Text(
                                    text = expense.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                                Text(
                                    text = "Expense #${expense.id}",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )

                            }

                            Spacer(Modifier.weight(1f))

                            Text(
                                text = "$${expense.amount}",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )

                            IconButton(
                                onClick = {

                                    viewModel.deleteExpenses(id = Long.MAX_VALUE)
                                }
                            ){
                                Icon(
                                painter = painterResource(android.R.drawable.ic_menu_delete),
                                contentDescription = "",
                                tint = Color.Blue,
                                modifier = Modifier
                                    .size(30.dp)
                            )
                            }

                        }

                    }
                }

            }
        }

        Spacer(Modifier.height(14.dp))

        Button(
            onClick = { navController.navigate("Screen1") },
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .padding(6.dp)
                .align(alignment = Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {

            Icon(
                painter = painterResource(android.R.drawable.ic_menu_add),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "Log New Expense",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}