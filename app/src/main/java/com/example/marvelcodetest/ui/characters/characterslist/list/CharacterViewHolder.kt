package com.example.marvelcodetest.ui.characters.characterslist.list

import android.content.Context
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelcodetest.databinding.ItemCharacterBinding
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterListInfoUI

class CharacterViewHolder(view: ItemCharacterBinding, private val onclick: ((Int) -> Unit)?): RecyclerView.ViewHolder(view.root) {

    private val image: AppCompatImageView = view.characterImage
    private val name: TextView = view.characterInfo

    fun bindViewHolder(context: Context, item: CharacterListInfoUI) {
        //image.right = item.title
        Glide.with(context)
            .load(item.imageResource)
            .into(image)
        name.text = item.name
        itemView.setOnClickListener {
            onclick?.invoke(adapterPosition)
        }
    }

}