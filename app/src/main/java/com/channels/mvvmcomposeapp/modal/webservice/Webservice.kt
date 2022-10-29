package com.channels.mvvmcomposeapp.modal.webservice

import com.channels.mvvmcomposeapp.modal.MealsModal
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
const val MEALS_CATEGORY_ENDPOINT = "categories.php"

class WebService {
   private lateinit var apiInterface: APIInterface

   init {
       val retrofit = Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
       apiInterface = retrofit.create(APIInterface::class.java)
   }

    suspend fun getMeals() : MealsModal{
        return apiInterface.getMeals()
    }

    internal interface APIInterface {
        @GET(MEALS_CATEGORY_ENDPOINT)
        suspend fun getMeals(): MealsModal
    }
}