package com.sabanciuniv.edu.finalprojectataberkresatozek.services

import com.sabanciuniv.edu.finalprojectataberkresatozek.data.entity.MealResponse
import retrofit2.http.GET

interface ApiService {
    @GET("tumYemekleriGetir.php")
    suspend fun getMeals(): MealResponse
}
