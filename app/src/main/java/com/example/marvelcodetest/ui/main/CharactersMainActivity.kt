package com.example.marvelcodetest.ui.main

import android.os.Bundle
import com.example.marvelcodetest.R
import com.example.marvelcodetest.databinding.ActivityHeroesMainBinding
import com.example.marvelcodetest.ui.characters.characterslist.CharactersListFragment
import com.example.marvelcodetest.ui.component.addFragment
import com.example.marvelcodetest.ui.component.toolbar.ToolbarActivity
import com.example.marvelcodetest.ui.model.ToolbarConfig
import com.example.marvelcodetest.ui.util.viewModelProvider

class CharactersMainActivity : ToolbarActivity() {

    private lateinit var charactersMainViewModel: CharactersMainViewModel

    override var toolbarConfig: ToolbarConfig = ToolbarConfig(imageView = R.drawable.ic_launcher_foreground)

    public override val viewBinding by lazy { ActivityHeroesMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        charactersMainViewModel = viewModelProvider(viewModelFactory)
        addFragment(CharactersListFragment())
    }

    override fun onBackPressed() {
        super.getOnBackPressedDispatcher().onBackPressed()
        updateToolbarConfig(ToolbarConfig(imageView = R.drawable.ic_launcher_foreground))
    }




}