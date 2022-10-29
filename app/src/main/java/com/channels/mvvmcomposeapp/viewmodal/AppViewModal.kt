package com.channels.mvvmcomposeapp.viewmodal

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.channels.mvvmcomposeapp.modal.Categories
import com.channels.mvvmcomposeapp.modal.DataRepository
import com.channels.mvvmcomposeapp.modal.MealsModal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModal(private val dataRepository: DataRepository = DataRepository()) : ViewModel() {
    var mealsListData = mutableStateOf(emptyList<Categories>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMealListData()
            mealsListData.value = meals
        }
    }
    private suspend fun getMealListData() : List<Categories>{
        return dataRepository.getMealData().categories
    }
}