package com.example.wongnai_internship.APi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {



    @GET("public/coins")
    fun getAllCoins(): Call<APiResponse>
}