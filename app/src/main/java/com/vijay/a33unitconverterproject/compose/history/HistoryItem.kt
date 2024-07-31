package com.vijay.a33unitconverterproject.compose.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/

@Composable
fun HistoryItem(
    message1: String,
    message2: String,
    modifier: Modifier = Modifier,
    onClose: () -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(border = BorderStroke(0.5.dp, Color.Gray)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column{
            Text(text = message1,
                fontSize = 18.sp)
            Text(text = message2,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)
        }
        
        IconButton(onClick = { onClose() }) {
            Icon(Icons.Filled.Close, contentDescription = "")
        }
    }
}