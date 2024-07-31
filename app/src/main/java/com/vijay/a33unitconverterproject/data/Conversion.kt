package com.vijay.a33unitconverterproject.data

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/
data class Conversion(
    val id: Int,
    val description: String,
    val convertFrom: String,
    val convertTo: String,
    val multiplyBy: Double
)
