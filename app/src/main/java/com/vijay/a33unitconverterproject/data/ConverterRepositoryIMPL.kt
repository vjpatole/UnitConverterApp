package com.vijay.a33unitconverterproject.data

import kotlinx.coroutines.flow.Flow

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/
class ConverterRepositoryIMPL(private val converterDao: ConverterDao): ConverterRepository {

    override suspend fun insertResult(result: ConversionResult) {
        converterDao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        converterDao.deleteResult(result)
    }

    override suspend fun deleteAllResults() {
        converterDao.deleteAll()
    }

    override fun getAllResult(): Flow<List<ConversionResult>> {
        return converterDao.getAllResult()
    }

}