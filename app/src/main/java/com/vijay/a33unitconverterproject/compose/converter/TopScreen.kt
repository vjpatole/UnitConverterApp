package com.vijay.a33unitconverterproject.compose.converter

import android.icu.text.DecimalFormat
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.vijay.a33unitconverterproject.data.Conversion

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/

@Composable
fun TopScreen(
    list: List<Conversion>,
    save: (String, String) -> Unit
    ) {
    val selectedConversion: MutableState<Conversion?> = remember {
        mutableStateOf(null)
    }

    val inputText: MutableState<String> = remember {
        mutableStateOf("")
    }

    val typedValue = remember {
        mutableStateOf("0.0")
    }

    ConversionMenu(list = list){
        selectedConversion.value = it

        //reset to 0 once user changes the Conversion Type to avoid duplicate entries
        typedValue.value = "0.0"
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText){ input ->
            val a: Double = input.toDouble()
            Log.d("MYTAG", "$input to Output: ${it.multiplyBy * a}")
            typedValue.value = input
        }
    }

    if (typedValue.value != "0.0"){
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy

        val result = input * multiply

        //rounding off result to 4 decimal points
        val df = DecimalFormat("#.###")
        //df.roundingMode = RoundingMode.DOWN

        val roundedResult = df.format(result)

        val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
        val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
        save(message1, message2)
        ResultBlock(message1 = message1, message2 = message2)
    }


}