package com.vijay.a33unitconverterproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vijay.a33unitconverterproject.data.ConverterRepository
import javax.inject.Inject

/**
 * Author : vijay
 * Created On : 7/30/24
 *Class :
 **/
class ConverterViewModelFactory @Inject constructor(private val repository: ConverterRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ConverterViewModel(repository) as T
        //return super.create(modelClass)
}