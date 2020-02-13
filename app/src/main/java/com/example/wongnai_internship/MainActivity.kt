package com.example.wongnai_internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wongnai_internship.APi.APiResponse
import com.example.wongnai_internship.APi.ApiService
import com.example.wongnai_internship.APi.Coins
import com.example.wongnai_internship.APi.RetrofitClientInstance
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
                d("daniel","onResponse: ${response.body()!!.data.coins[0].description}")

            }

            override fun onFailure(call: Call<APiResponse>, t: Throwable) {
                d("daniel","onFailure")

            }


        })



        //init_recycler_view()


    }

    private fun showData(body: APiResponse) {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            coinAdapter = RecyclerAdapter(body.data.coins)
            adapter = coinAdapter
        }

    }

    /*
    private fun showData(body: APiResponse) {
        val data = body.data.coins
        coinAdapter.submitList(data)
    }

     */



/*
    private fun init_recycler_view(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            coinAdapter = RecyclerAdapter()
            adapter = coinAdapter
        }
    }

 */
}
