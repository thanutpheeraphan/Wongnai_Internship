package com.example.wongnai_internship.APi

import com.example.wongnai_internship.Model.APiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


    @GET("public/coins")
    fun getAllCoins(): Call<APiResponse>
}