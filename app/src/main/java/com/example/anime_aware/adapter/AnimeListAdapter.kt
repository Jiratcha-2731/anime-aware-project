package com.example.anime_aware.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anime_aware.R
import com.example.anime_aware.model.Characters
import kotlinx.android.synthetic.main.adapter_anime.view.*
import java.util.ArrayList

class AnimeListAdapter( val completionBlock: (Characters?) -> Unit) : RecyclerView.Adapter<AnimeListAdapter.AnimeListViewHolder>() {

    private var characters = ArrayList<Characters>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder {
        return AnimeListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_anime, parent, false),completionBlock
        )
    }

    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        holder.bindData(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun addItem(animeList: ArrayList<Characters>?){
        characters.clear()
        animeList?.let {
            characters.addAll(it)
        }
        notifyDataSetChanged()
    }

    inner class AnimeListViewHolder(itemView: View, completionBlock: (Characters?) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindData(characters: Characters) {
            itemView.setOnClickListener { completionBlock(characters) }

            characters.imageUrl.let {
                Glide.with(itemView).load(it).into(itemView.img_anime)
            }
            itemView.name_anime.text = characters.name
        }
    }

}