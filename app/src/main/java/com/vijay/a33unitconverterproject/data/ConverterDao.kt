package com.vijay.a33unitconverterproject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/
@Dao
interface ConverterDao {
    @Insert
    suspend fun insertResult(result: ConversionResult)

    @Delete
    suspend fun deleteResult(result: ConversionResult)

    @Query("DELETE FROM result_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM result_table")
    fun getAllResult(): Flow<List<ConversionResult>>

}