package com.example.wongnai_internship.APi

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Datasource {
    companion object{
        fun createDataSet(){
            val retrofit = RetrofitClientInstance.retrofitInstance?.create(ApiService::class.java)

            retrofit!!.getAllCoins().enqueue(object : Callback<APiResponse> {
                override fun onResponse(call: Call<APiResponse>, response: Response<APiResponse>) {
                    //showData(response.body()!!)
                    Log.d("daniel", "onResponse: ${response.body()!!.data.coins[0].description}")

                }

                override fun onFailure(call: Call<APiResponse>, t: Throwable) {
                    Log.d("daniel", "onFailure")

                }


            })

        }
    }
}