package com.vijay.a33unitconverterproject.compose.converter

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vijay.a33unitconverterproject.data.Conversion

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBlock(
    isLandScape: Boolean,
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    calculate: (String)-> Unit
){
    if (isLandScape) {
        Column(
            modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Row() {
                TextField(
                    value = inputText.value,
                    onValueChange = {
                        inputText.value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(color = Color.DarkGray, fontSize = 18.sp)
                    /*colors = TextFieldDefaults.textFieldColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3F),

                )*/
                )

                Text(
                    text = conversion.convertFrom,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(10.dp, 30.dp, 0.dp, 0.dp)
                )
            }

            Spacer(modifier = modifier.height(20.dp))

            OutlinedButton(
                onClick = {
                    if (inputText.value != "")
                        calculate(inputText.value)
                    else
                        Toast.makeText(context, "Enter valid Number", Toast.LENGTH_SHORT).show()
                },
            ) {
                Text(
                    text = "Convert",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
        }
    }else {

        Column(
            modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                TextField(
                    value = inputText.value,
                    onValueChange = {
                        inputText.value = it
                    },
                    modifier = modifier.fillMaxWidth(0.65F),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(color = Color.DarkGray, fontSize = 18.sp)
                    /*colors = TextFieldDefaults.textFieldColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3F),

                )*/
                )

                Text(
                    text = conversion.convertFrom,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(10.dp, 30.dp, 0.dp, 0.dp)
                        .fillMaxWidth(0.35F)
                )
            }

            Spacer(modifier = modifier.height(20.dp))

            OutlinedButton(
                onClick = {
                    if (inputText.value != "")
                        calculate(inputText.value)
                    else
                        Toast.makeText(context, "Enter valid Number", Toast.LENGTH_SHORT).show()
                },
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Convert",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
        }
    }
}