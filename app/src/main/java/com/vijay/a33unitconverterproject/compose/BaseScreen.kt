package com.vijay.a33unitconverterproject.compose

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
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

    //Has all information about current configuration
    val configuration = LocalConfiguration.current
    var isLandScape by remember { mutableStateOf(false) }

    Log.d("MYTAG", "ORIENTATION_LANDSCAPE: ${Configuration.ORIENTATION_LANDSCAPE}")
    Log.d("MYTAG", "ORIENTATION_PORTRAIT: ${Configuration.ORIENTATION_PORTRAIT}")
    Log.d("MYTAG", "Current: ${configuration.orientation}")

    //check App orientation
    when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE ->{
            isLandScape = true
            Row(
                modifier = modifier
                    .padding(30.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround) {
                TopScreen(
                    isLandScape,
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue){ message1, message2 ->
                    converterViewModel.addResult(message1, message2)
                }
                Spacer(modifier = modifier.width(1.dp))

                //Higher order function has String return type String which is just trial to check how lambda works with return type value
                HistoryScreen(historyList, onCloseTask = { item->
                    converterViewModel.removeResult(item)
                    "ABCDEF"
                }, onClearTask = {
                    converterViewModel.clearAll()
                })
            }
        }

        else ->{
            isLandScape = false
            Column(modifier = modifier.padding(30.dp)) {
                TopScreen(
                    isLandScape,
                    list,
                    converterViewModel.selectedConversion,
                    converterViewModel.inputText,
                    converterViewModel.typedValue){ message1, message2 ->
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
    }



}