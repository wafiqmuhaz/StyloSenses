package com.example.stylosenses.presentations.screen.order_summary_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stylosensess.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderSummaryScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Order Summary") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Order Details",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                OrderSummaryItem(
                    imageVector = ImageVector.vectorResource(id = R.drawable.img_profile),
                    title = "Penjahit A",
                    description = "vermak, jahit, gorden"
                )
                Spacer(modifier = Modifier.height(16.dp))
                SummaryList(
                    items = listOf(
                        SummaryListItem("Vermak", "Rp25.000"),
                        SummaryListItem("Platform fee", "Rp1.500"),
                        SummaryListItem("Delivery fee", "Rp10.000")
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                SummaryListItem("Total", "Rp36.500")
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /* Handle place order click */ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Place Order")
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Filled.ArrowForward,
                            contentDescription = "Forward"
                        )
                    }
                }
            }
        }
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderSummaryItem(
    imageVector: ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = "Tailor",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun SummaryList(items: List<SummaryListItem>) {
    Column {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.label)
                Text(text = item.value)
            }
        }
    }
}


data class SummaryListItem(val label: String, val value: String)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OrderSummaryScreen()
}