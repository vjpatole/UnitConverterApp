package com.vijay.a33unitconverterproject.compose.history

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vijay.a33unitconverterproject.data.ConversionResult

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/
@Composable
fun HistoryScreen(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> String,
    modifier: Modifier = Modifier,
    onClearTask: () -> Unit
){

    Column {
        //Display History label and Button if there are records in the DB
        if (list.value.isNotEmpty()) {
            //Need to set Text and button at start and en so,
            // Set arrangement SpaceBetween
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "History",
                    color = Color.Gray
                )

                OutlinedButton(onClick = {
                    onClearTask()
                }) {
                    Text(
                        text = "Clear All",
                        color = Color.Gray
                    )
                }
            }
        }

        HistoryList(list = list, onCloseTask = {
            val strValue = onCloseTask(it)

            Log.d("MYTAG", "$strValue")
        })
    }
}