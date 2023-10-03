package com.example.marvelcodetest.ui.characters.characterslist.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcodetest.databinding.ItemCharacterBinding
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterListInfoUI

class CharactersAdapter (private val context: Context,
                         private val items: List<CharacterListInfoUI>,
                         private val onCharacterClick: ((CharacterListInfoUI) -> Unit)?): RecyclerView.Adapter<CharacterViewHolder>() {

    override fun getItemCount(): Int = items.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(context), parent, false)){ onClickOption(it) }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = items[position]
        holder.bindViewHolder(context, item)
    }

    private fun onClickOption(position: Int){
        notifyItemChanged(position)
        onCharacterClick?.invoke(items[position])
    }

}