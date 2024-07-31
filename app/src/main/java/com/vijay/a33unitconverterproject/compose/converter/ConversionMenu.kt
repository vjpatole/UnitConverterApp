package com.vijay.a33unitconverterproject.compose.converter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.vijay.a33unitconverterproject.data.Conversion

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/

@Composable
fun ConversionMenu(list: List<Conversion>, modifier: Modifier = Modifier, convert: (Conversion) -> Unit){

    /**
     * Using remember composable inline function
     * to avoid displaying text value being reset to initial value while re-composition
     */
    var displayingText by remember {
        mutableStateOf("Select the conversion Type")
    }

    //To assign the dropdown the same width as TextField
    var textFieldSize by remember {
            mutableStateOf(Size.Zero)
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    //put Dropdown menu in column to display drop down as expected.
    Column {
        OutlinedTextField(
            value = displayingText,
            onValueChange = { displayingText = it },
            textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { layoutCoordinates ->
                    textFieldSize = layoutCoordinates.size.toSize()
                },
            label = { Text(text = "Conversion Type") },
            trailingIcon = {
                Icon(icon, contentDescription = "icon",
                    modifier.clickable {
                        expanded = !expanded
                    })
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier.width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {
            list.forEach { conversion ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = conversion.description,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    onClick = {
                        displayingText = conversion.description
                        expanded = false
                        convert(conversion)
                    })
            }
        }
    }
}