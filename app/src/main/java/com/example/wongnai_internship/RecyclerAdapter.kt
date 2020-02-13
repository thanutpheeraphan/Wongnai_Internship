package com.example.wongnai_internship

import android.net.Uri
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.util.Util
import com.example.wongnai_internship.APi.Coins
import com.example.wongnai_internship.Utils.Utils
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_coins.view.*

class RecyclerAdapter (private val coins: List<Coins> ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CoinViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_coins,parent,false))
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val temp = coins[position]
        d("daniel","url? ${temp.iconUrl}")
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

        val requestOptions = RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
        //Utils.fetchSvg(itemView.context,coins.iconUrl,coin_image)
        //Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions).load(coins.iconUrl).into(coin_image)
        GlideToVectorYou.init().with(itemView.context).setPlaceHolder(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background).load(
            Uri.parse(coins.iconUrl),coin_image)

    }


}