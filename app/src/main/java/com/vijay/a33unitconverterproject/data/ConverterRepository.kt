package com.vijay.a33unitconverterproject.data

import kotlinx.coroutines.flow.Flow

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/
interface ConverterRepository {
    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResults()
    fun getAllResult(): Flow<List<ConversionResult>>
}