package com.example.marvelcodetest.ui.characters.characterslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcodetest.databinding.FragmentCharactersListBinding
import com.example.marvelcodetest.domain.model.Resource
import com.example.marvelcodetest.ui.base.BaseFragment
import com.example.marvelcodetest.ui.characters.characterDetail.CharacterDetailsFragment
import com.example.marvelcodetest.ui.characters.characterslist.list.CharactersAdapter
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterDetailUI
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterListInfoUI
import com.example.marvelcodetest.ui.component.addFragment
import com.example.marvelcodetest.ui.main.CharactersMainActivity
import com.example.marvelcodetest.ui.util.makeGone
import com.example.marvelcodetest.ui.util.makeVisible
import com.example.marvelcodetest.ui.util.viewModelProvider
import javax.inject.Inject

class CharactersListFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CharactersListViewModel
    private lateinit var charactersAdapter: CharactersAdapter
    private val charactersList: MutableList<CharacterListInfoUI> = mutableListOf()
    private var charactersTotal = 0


    override val viewBinding by lazy { FragmentCharactersListBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = viewModelProvider(viewModelFactory)
        return this.viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetHeroesList()
        charactersAdapter = CharactersAdapter(requireContext(), charactersList) { onCharacterClick(it) }
        with(this.viewBinding.charactersRecyclerView) {
            val linearLayoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            layoutManager = linearLayoutManager
            adapter = charactersAdapter
        }
        viewModel.onStart()
        observeViewModel()

    }

    private fun resetHeroesList() {
        charactersList.clear()
    }

    private fun observeViewModel() {
        viewModel.characters.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    showLocalProgress()
                }
                is Resource.Success -> {
                    hideLocalProgress()
                        showCharactersError(false)
                        onCharactersReceived(it.data)
                    }

                is Resource.Error -> {
                hideLocalProgress()
                showCharactersError(true)
                }
            }
        }
        viewModel.characterDetails.observe(this) {
            when (it) {
                is Resource.Loading -> {
                    showLocalProgress()
                }
                is Resource.Success -> {
                    hideLocalProgress()
                    showCharactersError(false)
                    goToCharacterDetail(it.data)
                }

                is Resource.Error -> {
                    hideLocalProgress()
                    showCharactersError(true)
                }
            }
        }
    }

    private fun goToCharacterDetail(characterDetail: CharacterDetailUI) {
        (activity as? CharactersMainActivity)?.addFragment(CharacterDetailsFragment.getFragment(characterDetail))
    }

    private fun onCharactersReceived(recentCharacters: List<CharacterListInfoUI>) {
        if (recentCharacters.isNotEmpty()) {
            charactersList.addAll(recentCharacters)
            charactersTotal += recentCharacters.size
            charactersAdapter.notifyItemRangeChanged(0, charactersTotal)
        }
    }

    private fun showLocalProgress() {
        this.viewBinding.charactersRecyclerView.isVisible = false
        this.viewBinding.mprogresscharacters.progressBar.makeVisible()
    }

    private fun hideLocalProgress() {
        this.viewBinding.charactersRecyclerView.isVisible = true
        this.viewBinding.mprogresscharacters.progressBar.makeGone()
    }

    private fun showCharactersError(shouldShow: Boolean) {
        this.viewBinding.charactersErrorList.isVisible = shouldShow
        this.viewBinding.charactersRecyclerView.isVisible = !shouldShow
    }


    private fun onCharacterClick(characterUI: CharacterListInfoUI) {
      viewModel.onCharacterClick(characterUI)
    }

}