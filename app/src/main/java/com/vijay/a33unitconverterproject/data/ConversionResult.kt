package com.vijay.a33unitconverterproject.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/
@Entity(tableName = "result_table")
data class ConversionResult(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id")
    val id: Int,
    @ColumnInfo(name = "result_message1")
    val messagePart1: String,
    @ColumnInfo(name = "result_message2")
    val messagePart2: String
)
