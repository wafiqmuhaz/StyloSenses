package com.example.stylosenses.presentations.screen.payment_successful_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentSuccessfulScreen() {
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Payment Successful",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    CheckMarkIcon()
                }
                // Adding the circles
                Spacer(modifier = Modifier.fillMaxSize())
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Circle(modifier = Modifier.size(100.dp))
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Circle(modifier = Modifier.size(100.dp))
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Circle(modifier = Modifier.size(100.dp))
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Circle(modifier = Modifier.size(100.dp))
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun CheckMarkIcon() {
    Canvas(
        modifier = Modifier
            .size(120.dp)
    ) {
        drawCheckMark()
    }
}

fun DrawScope.drawCheckMark() {
    // Draw the green shape behind the checkmark
    val paint = Paint().apply {
        color = Color(0xFF4CAF50)
        style = PaintingStyle.Fill // Use PaintingStyle instead of Paint.Style
        isAntiAlias = true
    }
    drawPath(
        path = Path().apply {
            moveTo(30f, 70f)
            lineTo(60f, 100f)
            lineTo(100f, 30f)
        },
        color = Color(0xFF4CAF50)
    )

    // Draw the white checkmark outline
    drawPath(
        path = Path().apply {
            moveTo(30f, 70f)
            lineTo(60f, 100f)
            lineTo(100f, 30f)
        },
        color = Color.White,
        style = Stroke(width = 8f)
    )
}

@Composable
fun Circle(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .background(
                color = Color(0xFF9C27B0),
                shape = CircleShape
            )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PaymentSuccessfulScreen()
}