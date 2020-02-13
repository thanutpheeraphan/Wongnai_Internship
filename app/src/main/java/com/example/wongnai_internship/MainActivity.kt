package com.example.wongnai_internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wongnai_internship.Model.APiResponse
import com.example.wongnai_internship.APi.ApiService
import com.example.wongnai_internship.APi.RetrofitClientInstance
import com.example.wongnai_internship.Adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var coinAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClientInstance.retrofitInstance?.create(ApiService::class.java)

        retrofit!!.getAllCoins().enqueue(object : Callback<APiResponse>{
            override fun onResponse(call: Call<APiResponse>, response: Response<APiResponse>) {
                showData(response.body()!!)

            }

            override fun onFailure(call: Call<APiResponse>, t: Throwable) {

            }

        })



    }

    private fun showData(body: APiResponse) {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            coinAdapter =
                RecyclerAdapter(body.data.coins)
            adapter = coinAdapter
        }

    }


}
