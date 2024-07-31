package com.vijay.a33unitconverterproject.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vijay.a33unitconverterproject.ConverterViewModel
import com.vijay.a33unitconverterproject.ConverterViewModelFactory
import com.vijay.a33unitconverterproject.compose.converter.TopScreen
import com.vijay.a33unitconverterproject.compose.history.HistoryScreen

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
    modifier: Modifier = Modifier,
    converterViewModel: ConverterViewModel = viewModel(factory = factory)
){
    //This list is constant so no need to convert to a state
    val list = converterViewModel.getConversions()
    val historyList = converterViewModel.resultsList.collectAsState(initial = emptyList())

    Column(modifier = modifier.padding(30.dp)) {
        TopScreen(list){ message1, message2 ->
            converterViewModel.addResult(message1, message2)
        }
        //Spacer(modifier = modifier.height(1.dp))

        //Higher order function has String return type String which is just trial to check how lambda works with return type value
        HistoryScreen(historyList, onCloseTask = { item->
            converterViewModel.removeResult(item)
            "ABCDEF"
        }, onClearTask = {
            converterViewModel.clearAll()
        })
    }
}