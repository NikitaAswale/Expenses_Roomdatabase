package com.example.expenses_roomdatabase

import android.R
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Expenses_UI() {
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
                        text = "3 visible",
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
                        text = "$189.55",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(Modifier.weight(1f))

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .padding(horizontal = 10.dp, vertical = 1.dp),
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
                            color = Color.Blue,
                            modifier = Modifier
                        )
                    }
                }

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Keep up the mindful balance",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
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
                color = Color.Black,
                modifier = Modifier
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

        LazyColumn() {

            item {

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
                                text = "Weekly Groceries",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                            )

                            Text(
                                text = "Essential Market . Today",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                modifier = Modifier
                            )

                        }

                        Spacer(Modifier.weight(1f))

                        Text(
                            text = "$68.50",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier
                        )

                    }

                }
            }

        }

        Spacer(Modifier.height(14.dp))

        Button(onClick = {},
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .padding(6.dp)
                .align(alignment = Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {

            Icon(
                painter = painterResource(android.R.drawable.ic_menu_add),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(text = "Log New Expense",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}