package com.example.marvelcodetest.ui.characters.characterDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.marvelcodetest.R
import com.example.marvelcodetest.databinding.FragmentCharacterDetailBinding
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterDetailUI
import com.example.marvelcodetest.ui.component.ToolBarFragment
import com.example.marvelcodetest.ui.model.ToolbarConfig
import com.example.marvelcodetest.ui.model.ToolbarLeftItem
import com.example.marvelcodetest.ui.util.viewModelProvider
import javax.inject.Inject

class CharacterDetailsFragment: ToolBarFragment() {

    companion object {

        private lateinit var characterDetails: CharacterDetailUI

        fun getFragment(selectedCharacter: CharacterDetailUI): CharacterDetailsFragment {
            characterDetails = selectedCharacter
            return CharacterDetailsFragment()
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CharacterDetailsViewModel

    override var toolbarConfig: ToolbarConfig = (ToolbarConfig(title = R.string.character_detail,leftSide = ToolbarLeftItem.Back(::clickOnBack)))

    override val viewBinding by lazy { FragmentCharacterDetailBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = viewModelProvider(viewModelFactory)
        return this.viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
    }

    private fun prepareView() {
        viewBinding.characterName.text = characterDetails.name
        Glide.with(requireContext())
            .load(characterDetails.imageResource)
            .into(viewBinding.characterImage)
        viewBinding.characterDescription.text = characterDetails.description
        viewBinding.numberOfComics.text = String.format(resources.getString(R.string.comics_number),
            characterDetails.numberOfComics)
        viewBinding.numberOfSeries.text = String.format(resources.getString(R.string.series_number),
            characterDetails.numberOfSeries)
        viewBinding.linkToComics.text = characterDetails.linkToComics
    }
}