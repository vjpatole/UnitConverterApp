package com.vijay.a33unitconverterproject.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.vijay.a33unitconverterproject.data.ConversionResult

/**
 * Author : vijay
 * Created On : 7/31/24
 *Class :
 **/

@Composable
fun HistoryList(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn {
        items(
            itemContent = {
                HistoryItem(
                    message1 = list.value[it].messagePart1,
                    message2 = list.value[it].messagePart2
                ) {
                    onCloseTask(list.value[it])
                }
            },
            count = list.value.size
        )
    }
}