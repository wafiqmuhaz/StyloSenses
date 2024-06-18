package com.example.stylosenses.presentations.commons.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylosenses.presentations.screen.on_board_screen.Purple


@Composable
fun CustomDefaultBtn(
    shapeSize: Float,
    btnText: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 30.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(shapeSize.dp)),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
//            backgroundColor = MaterialTheme.colors.PrimaryColor,
            contentColor = Color.White,
            containerColor = Purple
        ),
    ) {
        Text(text = btnText, fontSize = 16.sp)
    }
}