package com.example.wongnai_internship

import android.net.Uri
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wongnai_internship.Model.Coins
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

import kotlinx.android.synthetic.main.layout_coins.view.*

class RecyclerAdapter (private val coins: List<Coins> ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CoinViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_coins,parent,false))
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CoinViewHolder ->{
            holder.bind(coins.get(position))}
        }

    }


}


class CoinViewHolder constructor(
    itemView: View
): RecyclerView.ViewHolder(itemView){
    val coin_name = itemView.coin_name
    val coin_description = itemView.coin_description
    val coin_image = itemView.coin_image

    fun bind(coins: Coins){
        coin_name.setText(coins.name)
        coin_description.setText(coins.description)
        GlideToVectorYou.init().with(itemView.context).setPlaceHolder(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background).load(
            Uri.parse(coins.iconUrl),coin_image)

    }


}