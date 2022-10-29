package com.channels.mvvmcomposeapp.modal

import com.channels.mvvmcomposeapp.modal.webservice.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository(var webService: WebService = WebService()) {
    suspend fun getMealData() : MealsModal{
        return webService.getMeals()
    }
}